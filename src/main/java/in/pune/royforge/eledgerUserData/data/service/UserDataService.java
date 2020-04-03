package in.pune.royforge.eledgerUserData.data.service;

import java.util.List;

import in.pune.royforge.eledgerUserData.data.entity.UserDataEntity;
import in.pune.royforge.eledgerUserData.data.model.UserData;

public interface UserDataService {

	UserDataEntity save(UserData userData);
	
	List<UserData> getUsers();
}
