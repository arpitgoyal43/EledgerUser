package in.pune.royforge.eledgerUserData.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class UserDataEntity {

	@Column
	private String userId;
	
	@Column
	private String userName;
	
	@Column
	private String UserPhoneNo;
	
	@Column
	private String UserPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneNo() {
		return UserPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		UserPhoneNo = userPhoneNo;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	
	
	
}
