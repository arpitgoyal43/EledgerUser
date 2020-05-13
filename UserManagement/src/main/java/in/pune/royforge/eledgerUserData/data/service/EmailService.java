package in.pune.royforge.eledgerUserData.data.service;

import javax.mail.MessagingException;

import in.pune.royforge.eledgerUserData.data.model.EmailData;

public interface EmailService {

	String sendResetMail(EmailData emailData) throws MessagingException;

	String sendSignupEmail(EmailData emailData) throws MessagingException;

	String sendAddCustomerMail(EmailData emailData) throws MessagingException;
}
