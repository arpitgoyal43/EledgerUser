package in.pune.royforge.eledgerUserData.data.service;

import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import in.pune.royforge.eledgerUserData.data.model.EmailData;

public interface EmailService {

	String send(EmailData emailData, String subject) throws MessagingException;

	String sendSignupEmail(EmailData emailData, String subject) throws MessagingException;

	int getOtp(String key);

	Object clearOTP(String key);

	int generateOTP(String key);

	String getMd5(String input) throws NoSuchAlgorithmException;

}
