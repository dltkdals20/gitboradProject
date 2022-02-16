package kr.co.greenart.model;

public class LoginInfo {

	private int id;
	private String userId;
	private String password;
	private String name;
	private String nickname;
	
	
	public LoginInfo() {
	
	}

	
	
	
	
	public LoginInfo(int id, String userId, String password, String name, String nickname) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
	}

		




	public LoginInfo(String userId, String name, String nickname) {
		super();
		this.userId = userId;
		this.name = name;
		this.nickname = nickname;
	}





	public String getNickname() {
		return nickname;
	}





	public void setNickname(String nickname) {
		this.nickname = nickname;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}





	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name
				+ ", nickname=" + nickname + "]";
	}
	
	

	
	
}
