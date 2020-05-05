package in.pune.royforge.eledgerUserData.data.service;

import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

public interface EmailService {

	String send(String to, String subject) throws MessagingException;

	int getOtp(String key);

	Object clearOTP(String key);

	int generateOTP(String key);

	String getMd5(String input) throws NoSuchAlgorithmException;

}
