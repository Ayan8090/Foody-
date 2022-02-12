package entites;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class user {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id ;
	private String name;
	private String email;
	private String password;
	private String phone;
	private String userType;
	
	

	public user() {
		super();
	}
	public user(String name, String email, String password, String phone,String userType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.setUserType(userType);
	}
	public user(int id, String name, String email, String password, String phone,String userType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.setUserType(userType);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
