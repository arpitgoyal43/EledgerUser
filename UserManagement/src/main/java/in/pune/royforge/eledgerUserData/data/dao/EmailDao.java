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

		String body = "Smtp Test Message Check, OTP is : " + generateOTP(to);

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
