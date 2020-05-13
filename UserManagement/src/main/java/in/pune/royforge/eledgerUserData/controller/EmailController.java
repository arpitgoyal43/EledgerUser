package in.pune.royforge.eledgerUserData.controller;

import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.model.EmailData;
import in.pune.royforge.eledgerUserData.data.service.EmailService;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	public String sendResetMail(@RequestBody EmailData emailData) throws MessagingException, NoSuchAlgorithmException {
		return emailService.sendResetMail(emailData);
	}

	@RequestMapping(value = "/new-customer", method = RequestMethod.POST)
	public String sendAddUserMail(@RequestBody EmailData emailData)
			throws MessagingException, NoSuchAlgorithmException {
		return emailService.sendAddCustomerMail(emailData);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String sendSignUpMail(@RequestBody EmailData emailData) throws MessagingException, NoSuchAlgorithmException {
		return emailService.sendSignupEmail(emailData);
	}
}
