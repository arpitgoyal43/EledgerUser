package in.pune.royforge.eledgerUserData.data.dao;

import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import in.pune.royforge.eledgerUserData.data.model.EmailData;

public interface IEmailDao {

	String send(EmailData emailData, String subject) throws MessagingException;

	String sendSignupEmail(EmailData emailData, String subject) throws MessagingException;

	int getOtp(String key);

	void clearOTP(String key);

	int generateOTP(String key);

	String getMd5(String input) throws NoSuchAlgorithmException;

}
