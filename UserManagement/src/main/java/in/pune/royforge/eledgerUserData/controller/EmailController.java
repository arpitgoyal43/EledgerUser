package in.pune.royforge.eledgerUserData.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.service.EmailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reset-password")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/{email}", method = RequestMethod.POST)
	public ResponseEntity<String> sendMail(@PathVariable(value = "email") String email) throws MessagingException {
		int otp = emailService.generateOTP(email);

		return new ResponseEntity<>(
				emailService.send(email, "Testing Mail",
						"Smtp Test Message Check, OTP is : " + otp + "/n getOTP MEthod() = " + emailService.getOtp(email)),
				HttpStatus.CREATED);
	}
}
