package in.pune.royforge.eledgerUserData.data.dao;

import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

public interface IEmailDao {

	String send(String to, String subject) throws MessagingException;

	int getOtp(String key);

	void clearOTP(String key);

	int generateOTP(String key);

	String getMd5(String input) throws NoSuchAlgorithmException;

}
