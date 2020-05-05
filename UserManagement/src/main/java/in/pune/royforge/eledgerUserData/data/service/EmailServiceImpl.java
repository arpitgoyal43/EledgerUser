package in.pune.royforge.eledgerUserData.data.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerUserData.data.dao.IEmailDao;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private IEmailDao emailDao;

	@Override
	public String send(String to, String subject, String body) throws MessagingException {
		return emailDao.send(to, subject, body);
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

}
