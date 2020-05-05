package in.pune.royforge.eledgerUserData.data.dao;

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

@Repository
public class EmailDao implements IEmailDao {

	@Autowired
	public JavaMailSender emailSender;

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
	public String send(String to, String subject, String body) throws MessagingException {
		MimeMessage msg = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		emailSender.send(msg);
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
}
