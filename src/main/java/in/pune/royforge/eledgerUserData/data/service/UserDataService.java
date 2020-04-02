package in.pune.royforge.eledgerUserData.data.service;

import in.pune.royforge.eledgerUserData.data.entity.UserDataEntity;
import in.pune.royforge.eledgerUserData.data.model.UserData;

public interface UserDataService {

	UserDataEntity save(UserData userData);
}
