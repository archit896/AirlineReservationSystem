package bean;

public class UserInfo {
	private int userId;
	private String name;
	private String email;
	private int phone;
	private String password;
	private String type;
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", password=" + password
				+ ", type=" + type + "]";
	}
	public UserInfo(int userId, String name, String email, int phone,
			String password, String type) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.type = type;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
