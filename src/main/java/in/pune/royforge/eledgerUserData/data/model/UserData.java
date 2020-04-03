package in.pune.royforge.eledgerUserData.data.model;

public class UserData {
	private Long userId;

	private String userName;

	private Long userPhoneNo;

	private String userPassword;

	private String userEmail;

	private String lenderId;

	public String getLenderId() {
		return lenderId;
	}

	public void setLenderId(String lenderId) {
		this.lenderId = lenderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(Long userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
