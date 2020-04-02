package in.pune.royforge.eledgerUserData.data.dao;

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
	}
}
