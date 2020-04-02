package in.pune.royforge.eledgerUserData.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerUserData.dao.IUserDataDao;

@Service
public class UserDataServiceImpl implements UserDataService {
	
	@Autowired
	private IUserDataDao userEntityDao;

}
