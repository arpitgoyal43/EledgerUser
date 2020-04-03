package in.pune.royforge.eledgerUserData.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.pune.royforge.eledgerUserData.data.entity.UserDataEntity;
import in.pune.royforge.eledgerUserData.data.model.UserData;
import in.pune.royforge.eledgerUserData.repo.EledgerUserRepository;

@Repository
public class UserDataDaoImpl implements IUserDataDao {

	@Autowired
	EledgerUserRepository eledgerUserRepository;

	@Override
	public UserDataEntity save(UserData userData) {
		UserDataEntity userDataEntity = new UserDataEntity();
		setUserData(userData, userDataEntity);
		return eledgerUserRepository.save(userDataEntity);
	}

	private void setUserData(UserData userData, UserDataEntity userDataEntity) {
		userDataEntity.setUserName(userData.getUserName());
		userDataEntity.setUserPassword(userData.getUserPassword());
		userDataEntity.setUserEmail(userData.getUserEmail());
		userDataEntity.setUserPhoneNo(userData.getUserPhoneNo());
		userDataEntity.setLenderId(userData.getLenderId());
		userDataEntity.setUserShopName(userData.getUserShopName());
	}

	private void getUserData(UserData userData, UserDataEntity userDataEntity) {
		userData.setUserId(userDataEntity.getUserId());
		userData.setUserName(userDataEntity.getUserName());
		userData.setUserPassword(userDataEntity.getUserPassword());
		userData.setUserEmail(userDataEntity.getUserEmail());
		userData.setUserPhoneNo(userDataEntity.getUserPhoneNo());
		userData.setLenderId(userDataEntity.getLenderId());
		userData.setUserShopName(userDataEntity.getUserShopName());
	}

	public List<UserData> getUsers() {
		List<UserData> users = new ArrayList<>();
		Iterable<UserDataEntity> usersList = eledgerUserRepository.findAll();
		if (null != usersList) {
			for (UserDataEntity UserDataEntity : usersList) {
				UserData UserData = new UserData();
				getUserData(UserData, UserDataEntity);
				users.add(UserData);
			}
		}
		return users;
	}

}