package in.pune.royforge.eledgerUserData.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pune.royforge.eledgerUserData.data.model.Response;
import in.pune.royforge.eledgerUserData.data.service.EmailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reset-password")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Response> sendMail(String email) throws MessagingException, NoSuchAlgorithmException {

		return new ResponseEntity<>(new Response(new Date(), emailService.send(email, "Password Recovery Mail"),
				HttpStatus.CREATED, emailService.getMd5(String.valueOf(emailService.getOtp(email)))),
				HttpStatus.CREATED);
	}
}
