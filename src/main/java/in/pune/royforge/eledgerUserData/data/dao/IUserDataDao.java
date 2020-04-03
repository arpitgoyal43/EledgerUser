package in.pune.royforge.eledgerUserData.data.dao;

import java.util.List;

import in.pune.royforge.eledgerUserData.data.entity.UserDataEntity;
import in.pune.royforge.eledgerUserData.data.model.UserData;

public interface IUserDataDao {

	UserDataEntity save(UserData userData);

	List<UserData> getUsers();
}
