package kr.co.greenart.model;

public class JoinInfo {
	private String userId;
	private String password;
	private String passwordCheck;
	private String name;
	private String phone;
	private String nickName;
	private String gender;
	private String checkBox;
	private String otherTravel;
	public JoinInfo() {
		super();
	}
	
		
	public JoinInfo(String userId) {
		super();
		this.userId = userId;
	}

	

	public JoinInfo(String userId, String name, String phone, String nickName, String gender) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.nickName = nickName;
		this.gender = gender;
	}



	public JoinInfo(String userId, String password, String passwordCheck, String name, String phone, String nickName,
			String gender, String checkBox, String otherTravel) {
		super();
		this.userId = userId;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.name = name;
		this.phone = phone;
		this.nickName = nickName;
		this.gender = gender;
		this.checkBox = checkBox;
		this.otherTravel = otherTravel;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCheckBox() {
		return checkBox;
	}
	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}
	public String getOtherTravel() {
		return otherTravel;
	}
	public void setOtherTravel(String otherTravel) {
		this.otherTravel = otherTravel;
	}
	@Override
	public String toString() {
		return "JoinInfo [userId=" + userId + ", password=" + password + ", passwordCheck=" + passwordCheck + ", name="
				+ name + ", phone=" + phone + ", nickName=" + nickName + ", gender=" + gender + ", checkBox=" + checkBox
				+ ", otherTravel=" + otherTravel + "]";
	}
	
	
}
