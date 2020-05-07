package in.pune.royforge.eledgerUserData.data.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerUserData.data.dao.IEmailDao;
import in.pune.royforge.eledgerUserData.data.model.EmailData;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private IEmailDao emailDao;

	@Override
	public String sendResetMail(EmailData emailData, String subject) throws MessagingException {
		return emailDao.sendResetMail(emailData, subject);
	}

	@Override
	public int generateOTP(String key) {
		return emailDao.generateOTP(key);
	}

	@Override
	public int getOtp(String key) {
		return emailDao.getOtp(key);
	}

	@Override
	public String clearOTP(String key) {
		emailDao.clearOTP(key);
		return key;
	}

	@Override
	public String getMd5(String input) throws NoSuchAlgorithmException {
		return emailDao.getMd5(input);

	}

	@Override
	public String sendAddCustomerMail(EmailData emailData, String subject) throws MessagingException {
		return emailDao.sendAddCustomerMail(emailData, subject);

	}

}
