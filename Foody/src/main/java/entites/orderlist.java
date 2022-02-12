package entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class orderlist{

	@Id
	private int userID;
	private String name;
	private String Username;
	private String UserPhone;
	private String UserAddress;
	private String userCIty;
	private String about;
	private String image;
	private int price;
	private String orderStatus ;
	
	
	
	
	public orderlist() {
		super();
	}
	public orderlist(String name, String username, String userPhone, String userAddress, String userCIty, String about,
			String image, int price, String orderStatus) {
		super();
		this.name = name;
		Username = username;
		UserPhone = userPhone;
		UserAddress = userAddress;
		this.userCIty = userCIty;
		this.about = about;
		this.image = image;
		this.price = price;
		this.orderStatus = orderStatus;
	}
	public orderlist(int userID, String name, String username, String userPhone, String userAddress, String userCIty,
			String about, String image, int price, String orderStatus) {
		super();
		this.userID = userID;
		this.name = name;
		Username = username;
		UserPhone = userPhone;
		UserAddress = userAddress;
		this.userCIty = userCIty;
		this.about = about;
		this.image = image;
		this.price = price;
		this.orderStatus = orderStatus;
	}
	public int getUserId() {
		return userID;
	}
	public void setUserId(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUserPhone() {
		return UserPhone;
	}
	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public String getUserCIty() {
		return userCIty;
	}
	public void setUserCIty(String userCIty) {
		this.userCIty = userCIty;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
}
