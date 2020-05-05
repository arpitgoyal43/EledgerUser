package in.pune.royforge.eledgerUserData.data.dao;

import javax.mail.MessagingException;

public interface IEmailDao {

	String send(String to, String subject, String body) throws MessagingException;

	int getOtp(String key);

	void clearOTP(String key);

	int generateOTP(String key);
}
