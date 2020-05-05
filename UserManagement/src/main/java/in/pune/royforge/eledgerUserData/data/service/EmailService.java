package in.pune.royforge.eledgerUserData.data.service;

import javax.mail.MessagingException;

public interface EmailService {

	String send(String to, String subject, String body) throws MessagingException;

	int getOtp(String key);

	Object clearOTP(String key);

	int generateOTP(String key);

}
