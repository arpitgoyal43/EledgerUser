package in.pune.royforge.eledgerUserData.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping("/send-mail")
	public String sendMail() throws MessagingException {
		String email = "sahilkharya45@gmail.com";
		int otp = emailService.generateOTP(email);
		System.out.print(emailService.getOtp(email));

		return emailService.send(email, "Testing Mail",
				"Smtp Test Message, OTP is : " + otp + "\n getOTP MEthod() = " + emailService.getOtp(email));
	}
}
