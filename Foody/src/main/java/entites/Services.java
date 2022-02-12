package entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Services {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String Logo ;
	private String name ;
	private String about ;
	
	
	
	public Services() {
		super();
	}
	public Services(String logo, String name, String about) {
		super();
		Logo = logo;
		this.name = name;
		this.about = about;
	}
	public Services(int id, String logo, String name, String about) {
		super();
		this.id = id;
		Logo = logo;
		this.name = name;
		this.about = about;
	}
	public int getIdd() {
		return id;
	}
	public void setIdd(int idd) {
		this.id = idd;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
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
	
	
}
