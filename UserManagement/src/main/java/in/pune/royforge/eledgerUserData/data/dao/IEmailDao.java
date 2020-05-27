package in.pune.royforge.eledgerUserData.data.dao;

import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import in.pune.royforge.eledgerUserData.data.model.EmailData;

public interface IEmailDao {

	String sendResetMail(EmailData emailData) throws MessagingException;

	String sendSignupEmail(EmailData emailData) throws MessagingException;

	String sendAddCustomerMail(EmailData emailData) throws MessagingException;

	int getOtp(String key);

	void clearOTP(String key);

	int generateOTP(String key);

	String getMd5(String input) throws NoSuchAlgorithmException;

}
