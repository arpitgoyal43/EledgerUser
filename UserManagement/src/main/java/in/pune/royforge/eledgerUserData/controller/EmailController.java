package in.pune.royforge.eledgerUserData.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.service.EmailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reset-password")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/{email}", method = RequestMethod.POST)
	public ResponseEntity<String> sendMail(@PathVariable(value = "email") String email) throws MessagingException {
		int otp = emailService.generateOTP(email);
		String msg = "<!doctype html>\r\n" + "<html>\r\n" + "  <head>\r\n"
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
				+ otp + "</strong></p>\r\n" + "                        <br><br>\r\n"
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

		return new ResponseEntity<>(emailService.send(email, "Testing Mail", msg), HttpStatus.CREATED);
	}
}
