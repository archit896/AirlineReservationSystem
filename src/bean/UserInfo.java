package bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserInfo {
	private int userId;
	private String name;
	private String email;
	private int phone;
	private String password;
	private String type;
	private int age;
	private String gender;
	private String secQues;
	private String secAns;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSecQues() {
		return secQues;
	}
	public void setSecQues(String secQues) {
		this.secQues = secQues;
	}
	public String getSecAns() {
		return secAns;
	}
	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", password=" + password
				+ ", type=" + type + ", age=" + age + ", gender=" + gender
				+ ", secQues=" + secQues + ", secAns=" + secAns + "]";
	}
	public UserInfo(int userId, String name, String email, int phone,
			String password, String type, int age, String gender,
			String secQues, String secAns) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.type = type;
		this.age = age;
		this.gender = gender;
		this.secQues = secQues;
		this.secAns = secAns;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
