package entites;

import java.util.Random;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Food {

	@Id
	private int id;
	private String name;
	private String about;
	private String image;
	private int price;
	
	
	
	public Food() {
		super();
	}
	public Food(String name, String about, String image,int price) {
		super();
		this.id = new Random().nextInt(10000);
		this.name = name;
		this.about = about;
		this.image = image;
		this.price = price;
	}
	public Food(int id, String name, String about, String image,int price) {
		super();
		this.id = new Random().nextInt(10000);
		this.name = name;
		this.about = about;
		this.image = image;
		this.price = price;
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
	
	
	
}
