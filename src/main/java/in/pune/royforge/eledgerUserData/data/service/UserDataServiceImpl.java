package in.pune.royforge.eledgerUserData.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pune.royforge.eledgerUserData.data.dao.IUserDataDao;
import in.pune.royforge.eledgerUserData.data.entity.UserDataEntity;
import in.pune.royforge.eledgerUserData.data.model.UserData;

@Service
public class UserDataServiceImpl implements UserDataService {

	@Autowired
	private IUserDataDao userEntityDao;

	@Override
	public UserDataEntity save(UserData userData) {
		return userEntityDao.save(userData);
	}

	@Override
	public List<UserData> getUsers() {
		return userEntityDao.getUsers();
	}

}
