package in.pune.royforge.eledgerUserData.data.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import in.pune.royforge.eledgerUserData.data.model.EmailData;
import in.pune.royforge.eledgerUserData.data.service.EmailServiceImpl;

@Repository
public class EmailDao implements IEmailDao {

	@Autowired
	public JavaMailSender emailSender;
	EmailData emailData;

	// cache based on username and OPT MAX 8
	private static final Integer EXPIRE_MINS = 10;
	private LoadingCache<String, Integer> otpCache;

	public EmailDao() {
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}

	@Override
	public String send(String to, String subject) throws MessagingException {
		MimeMessage msg = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		String body = "<!doctype html>\r\n" + "<html>\r\n" + "  <head>\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width\" />\r\n"
				+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n"
				+ "    <title>Simple Transactional Email</title>\r\n" + "    <style>\r\n"
				+ "      /* -------------------------------------\r\n" + "          GLOBAL RESETS\r\n"
				+ "      ------------------------------------- */\r\n" + "      \r\n"
				+ "      /*All the styling goes here*/\r\n" + "      \r\n" + "      img {\r\n"
				+ "        border: none;\r\n" + "        -ms-interpolation-mode: bicubic;\r\n"
				+ "        max-width: 100%; \r\n" + "      }\r\n" + "\r\n" + "      body {\r\n"
				+ "        background-color: #f6f6f6;\r\n" + "        font-family: sans-serif;\r\n"
				+ "        -webkit-font-smoothing: antialiased;\r\n" + "        font-size: 14px;\r\n"
				+ "        line-height: 1.4;\r\n" + "        margin: 0;\r\n" + "        padding: 0;\r\n"
				+ "        -ms-text-size-adjust: 100%;\r\n" + "        -webkit-text-size-adjust: 100%; \r\n"
				+ "      }\r\n" + "\r\n" + "      table {\r\n" + "        border-collapse: separate;\r\n"
				+ "        mso-table-lspace: 0pt;\r\n" + "        mso-table-rspace: 0pt;\r\n"
				+ "        width: 100%; }\r\n" + "        table td {\r\n" + "          font-family: sans-serif;\r\n"
				+ "          font-size: 14px;\r\n" + "          vertical-align: top; \r\n" + "      }\r\n" + "\r\n"
				+ "      /* -------------------------------------\r\n" + "          BODY & CONTAINER\r\n"
				+ "      ------------------------------------- */\r\n" + "\r\n" + "      .body {\r\n"
				+ "        background-color: #f6f6f6;\r\n" + "        width: 100%; \r\n" + "      }\r\n" + "\r\n"
				+ "      /* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\r\n"
				+ "      .container {\r\n" + "        display: block;\r\n" + "        margin: 0 auto !important;\r\n"
				+ "        /* makes it centered */\r\n" + "        max-width: 580px;\r\n" + "        padding: 10px;\r\n"
				+ "        width: 580px; \r\n" + "      }\r\n" + "\r\n"
				+ "      /* This should also be a block element, so that it will fill 100% of the .container */\r\n"
				+ "      .content {\r\n" + "        box-sizing: border-box;\r\n" + "        display: block;\r\n"
				+ "        margin: 0 auto;\r\n" + "        max-width: 580px;\r\n" + "        padding: 10px; \r\n"
				+ "      }\r\n" + "\r\n" + "      /* -------------------------------------\r\n"
				+ "          HEADER, FOOTER, MAIN\r\n" + "      ------------------------------------- */\r\n"
				+ "      .main {\r\n" + "        background: #ffffff;\r\n" + "        border-radius: 3px;\r\n"
				+ "        width: 100%; \r\n" + "      }\r\n" + "\r\n" + "      .wrapper {\r\n"
				+ "        box-sizing: border-box;\r\n" + "        padding: 20px; \r\n" + "      }\r\n" + "\r\n"
				+ "      .content-block {\r\n" + "        padding-bottom: 10px;\r\n" + "        padding-top: 10px;\r\n"
				+ "      }\r\n" + "\r\n" + "      .footer {\r\n" + "        clear: both;\r\n"
				+ "        margin-top: 10px;\r\n" + "        text-align: center;\r\n" + "        width: 100%; \r\n"
				+ "      }\r\n" + "        .footer td,\r\n" + "        .footer p,\r\n" + "        .footer span,\r\n"
				+ "        .footer a {\r\n" + "          color: #999999;\r\n" + "          font-size: 12px;\r\n"
				+ "          text-align: center; \r\n" + "      }\r\n" + "\r\n"
				+ "      /* -------------------------------------\r\n" + "          TYPOGRAPHY\r\n"
				+ "      ------------------------------------- */\r\n" + "      h1,\r\n" + "      h2,\r\n"
				+ "      h3,\r\n" + "      h4 {\r\n" + "        color: #000000;\r\n"
				+ "        font-family: sans-serif;\r\n" + "        font-weight: 400;\r\n"
				+ "        line-height: 1.4;\r\n" + "        margin: 0;\r\n" + "        margin-bottom: 30px; \r\n"
				+ "      }\r\n" + "\r\n" + "      h1 {\r\n" + "        font-size: 35px;\r\n"
				+ "        font-weight: 300;\r\n" + "        text-align: center;\r\n"
				+ "        text-transform: capitalize; \r\n" + "      }\r\n" + "\r\n" + "      p,\r\n" + "      ul,\r\n"
				+ "      ol {\r\n" + "        font-family: sans-serif;\r\n" + "        font-size: 14px;\r\n"
				+ "        font-weight: normal;\r\n" + "        margin: 0;\r\n" + "        margin-bottom: 15px; \r\n"
				+ "      }\r\n" + "        p li,\r\n" + "        ul li,\r\n" + "        ol li {\r\n"
				+ "          list-style-position: inside;\r\n" + "          margin-left: 5px; \r\n" + "      }\r\n"
				+ "\r\n" + "      a {\r\n" + "        color: #3498db;\r\n" + "        text-decoration: underline; \r\n"
				+ "      }\r\n" + "\r\n" + "      /* -------------------------------------\r\n"
				+ "          BUTTONS\r\n" + "      ------------------------------------- */\r\n" + "      .btn {\r\n"
				+ "        box-sizing: border-box;\r\n" + "        width: 100%; }\r\n"
				+ "        .btn > tbody > tr > td {\r\n" + "          padding-bottom: 15px; }\r\n"
				+ "        .btn table {\r\n" + "          width: auto; \r\n" + "      }\r\n"
				+ "        .btn table td {\r\n" + "          background-color: #ffffff;\r\n"
				+ "          border-radius: 5px;\r\n" + "          text-align: center; \r\n" + "      }\r\n"
				+ "        .btn a {\r\n" + "          background-color: #ffffff;\r\n"
				+ "          border: solid 1px #3498db;\r\n" + "          border-radius: 5px;\r\n"
				+ "          box-sizing: border-box;\r\n" + "          color: #3498db;\r\n"
				+ "          cursor: pointer;\r\n" + "          display: inline-block;\r\n"
				+ "          font-size: 14px;\r\n" + "          font-weight: bold;\r\n" + "          margin: 0;\r\n"
				+ "          padding: 12px 25px;\r\n" + "          text-decoration: none;\r\n"
				+ "          text-transform: capitalize; \r\n" + "      }\r\n" + "\r\n"
				+ "      .btn-primary table td {\r\n" + "        background-color: #3498db; \r\n" + "      }\r\n"
				+ "\r\n" + "      .btn-primary a {\r\n" + "        background-color: #3498db;\r\n"
				+ "        border-color: #3498db;\r\n" + "        color: #ffffff; \r\n" + "      }\r\n" + "\r\n"
				+ "      /* -------------------------------------\r\n"
				+ "          OTHER STYLES THAT MIGHT BE USEFUL\r\n"
				+ "      ------------------------------------- */\r\n" + "      .last {\r\n"
				+ "        margin-bottom: 0; \r\n" + "      }\r\n" + "\r\n" + "      .first {\r\n"
				+ "        margin-top: 0; \r\n" + "      }\r\n" + "\r\n" + "      .align-center {\r\n"
				+ "        text-align: center; \r\n" + "      }\r\n" + "\r\n" + "      .align-right {\r\n"
				+ "        text-align: right; \r\n" + "      }\r\n" + "\r\n" + "      .align-left {\r\n"
				+ "        text-align: left; \r\n" + "      }\r\n" + "\r\n" + "      .clear {\r\n"
				+ "        clear: both; \r\n" + "      }\r\n" + "\r\n" + "      .mt0 {\r\n"
				+ "        margin-top: 0; \r\n" + "      }\r\n" + "\r\n" + "      .mb0 {\r\n"
				+ "        margin-bottom: 0; \r\n" + "      }\r\n" + "\r\n" + "      .preheader {\r\n"
				+ "        color: transparent;\r\n" + "        display: none;\r\n" + "        height: 0;\r\n"
				+ "        max-height: 0;\r\n" + "        max-width: 0;\r\n" + "        opacity: 0;\r\n"
				+ "        overflow: hidden;\r\n" + "        mso-hide: all;\r\n" + "        visibility: hidden;\r\n"
				+ "        width: 0; \r\n" + "      }\r\n" + "\r\n" + "      .powered-by a {\r\n"
				+ "        text-decoration: none; \r\n" + "      }\r\n" + "\r\n" + "      hr {\r\n"
				+ "        border: 0;\r\n" + "        border-bottom: 1px solid #f6f6f6;\r\n"
				+ "        margin: 20px 0; \r\n" + "      }\r\n" + "      .center {\r\n" + "        display: block;\r\n"
				+ "        margin-left: auto;\r\n" + "        margin-right: auto;\r\n" + "        width: 55px;\r\n"
				+ "        height: 43px;\r\n" + "      }\r\n" + "\r\n"
				+ "      /* -------------------------------------\r\n"
				+ "          RESPONSIVE AND MOBILE FRIENDLY STYLES\r\n"
				+ "      ------------------------------------- */\r\n"
				+ "      @media only screen and (max-width: 620px) {\r\n" + "        table[class=body] h1 {\r\n"
				+ "          font-size: 28px !important;\r\n" + "          margin-bottom: 10px !important; \r\n"
				+ "        }\r\n" + "        table[class=body] p,\r\n" + "        table[class=body] ul,\r\n"
				+ "        table[class=body] ol,\r\n" + "        table[class=body] td,\r\n"
				+ "        table[class=body] span,\r\n" + "        table[class=body] a {\r\n"
				+ "          font-size: 16px !important; \r\n" + "        }\r\n"
				+ "        table[class=body] .wrapper,\r\n" + "        table[class=body] .article {\r\n"
				+ "          padding: 10px !important; \r\n" + "        }\r\n"
				+ "        table[class=body] .content {\r\n" + "          padding: 0 !important; \r\n" + "        }\r\n"
				+ "        table[class=body] .container {\r\n" + "          padding: 0 !important;\r\n"
				+ "          width: 100% !important; \r\n" + "        }\r\n" + "        table[class=body] .main {\r\n"
				+ "          border-left-width: 0 !important;\r\n" + "          border-radius: 0 !important;\r\n"
				+ "          border-right-width: 0 !important; \r\n" + "        }\r\n"
				+ "        table[class=body] .btn table {\r\n" + "          width: 100% !important; \r\n"
				+ "        }\r\n" + "        table[class=body] .btn a {\r\n" + "          width: 100% !important; \r\n"
				+ "        }\r\n" + "        table[class=body] .img-responsive {\r\n"
				+ "          height: auto !important;\r\n" + "          max-width: 100% !important;\r\n"
				+ "          width: auto !important; \r\n" + "        }\r\n" + "      }\r\n" + "\r\n"
				+ "      /* -------------------------------------\r\n"
				+ "          PRESERVE THESE STYLES IN THE HEAD\r\n"
				+ "      ------------------------------------- */\r\n" + "      @media all {\r\n"
				+ "        .ExternalClass {\r\n" + "          width: 100%; \r\n" + "        }\r\n"
				+ "        .ExternalClass,\r\n" + "        .ExternalClass p,\r\n" + "        .ExternalClass span,\r\n"
				+ "        .ExternalClass font,\r\n" + "        .ExternalClass td,\r\n"
				+ "        .ExternalClass div {\r\n" + "          line-height: 100%; \r\n" + "        }\r\n"
				+ "        .apple-link a {\r\n" + "          color: inherit !important;\r\n"
				+ "          font-family: inherit !important;\r\n" + "          font-size: inherit !important;\r\n"
				+ "          font-weight: inherit !important;\r\n" + "          line-height: inherit !important;\r\n"
				+ "          text-decoration: none !important; \r\n" + "        }\r\n"
				+ "        #MessageViewBody a {\r\n" + "          color: inherit;\r\n"
				+ "          text-decoration: none;\r\n" + "          font-size: inherit;\r\n"
				+ "          font-family: inherit;\r\n" + "          font-weight: inherit;\r\n"
				+ "          line-height: inherit;\r\n" + "        }\r\n" + "        .btn-primary table td:hover {\r\n"
				+ "          background-color: #34495e !important; \r\n" + "        }\r\n"
				+ "        .btn-primary a:hover {\r\n" + "          background-color: #34495e !important;\r\n"
				+ "          border-color: #34495e !important; \r\n" + "        } \r\n" + "      }\r\n"
				+ "    </style>\r\n" + "  </head>\r\n" + "  <body class=\"\">\r\n"
				+ "    <span class=\"preheader\">Hi there, We have received your Password Reset request. To reset your password, please use your One-Time Password: </span>\r\n"
				+ "    <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\">\r\n"
				+ "      <tr>\r\n" + "        <td>&nbsp;</td>\r\n" + "        <td class=\"container\">\r\n"
				+ "          <div class=\"content\">\r\n"
				+ "            <table role=\"presentation\" class=\"main\">\r\n" + "              <tr>\r\n"
				+ "                <td class=\"wrapper\">\r\n"
				+ "                  <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
				+ "                    <tr>\r\n" + "                      <td>\r\n"
				+ "                        <img src=\"https://e-ledger.s3.ap-south-1.amazonaws.com/logo1.png\" class=\"center\">\r\n"
				+ "                        <p>Hi there,</p>\r\n"
				+ "                        <p>We have received your Password Reset request. To reset your password, please use your One-Time Password (OTP): <strong>"
				+ generateOTP(to) + "</strong></p>\r\n" + "                        <br><br>\r\n"
				+ "                        <p><strong>The Eledger Team</strong></p>\r\n"
				+ "                      </td>\r\n" + "                    </tr>\r\n" + "                  </table>\r\n"
				+ "                </td>\r\n" + "              </tr>\r\n" + "            </table>\r\n"
				+ "            <div class=\"footer\">\r\n"
				+ "              <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
				+ "                <tr>\r\n" + "                  <td class=\"content-block\">\r\n"
				+ "                    <span class=\"apple-link\">IDEMIA, Amanora Town Center, Pune 411028</span>\r\n"
				+ "                  </td>\r\n" + "                </tr>\r\n" + "              </table>\r\n"
				+ "            </div>\r\n" + "          </div>\r\n" + "        </td>\r\n"
				+ "        <td>&nbsp;</td>\r\n" + "      </tr>\r\n" + "    </table>\r\n" + "  </body>\r\n" + "</html>";

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		emailSender.send(msg);
		System.out.print(getOtp(to));
		String action = "Recovery Email With OTP has been sent.";
		return action;
	}

	// This method is used to push the otp number against Key. Rewrite the OTP if it
	// exists
	// Using user id as key
	@Override
	public int generateOTP(String key) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(key, otp);
		return otp;
	}

	// This method is used to return the OTP number against Key->Key values is
	// username
	@Override
	public int getOtp(String key) {
		try {
			return otpCache.get(key);
		} catch (Exception e) {
			return 0;
		}
	}

	// This method is used to clear the OTP catched already
	@Override
	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}

	@Override
	public String getMd5(String input) throws NoSuchAlgorithmException {
		EmailServiceImpl service = new EmailServiceImpl();
		// Static getInstance method is called with hashing MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		// digest() method is called to calculate message digest
		// of an input digest() return array of byte
		byte[] messageDigest = md.digest(input.getBytes());

		// Convert byte array into signum representation
		BigInteger no = new BigInteger(1, messageDigest);

		// Convert message digest into hex value
		String hashtext = no.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}
}
