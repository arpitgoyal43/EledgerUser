package in.pune.royforge.eledgerUserData.data.service;

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
	public String sendResetMail(EmailData emailData) throws MessagingException {
		return emailDao.sendResetMail(emailData);
	}

	@Override
	public String sendAddCustomerMail(EmailData emailData) throws MessagingException {
		return emailDao.sendAddCustomerMail(emailData);
	}

	public String sendSignupEmail(EmailData emailData) throws MessagingException {
		return emailDao.sendSignupEmail(emailData);
	}

}
