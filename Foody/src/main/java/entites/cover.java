package entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class cover {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String image;
	private String CaptionL;
	private String captionS;
	private String button;
	
	
	
	
	public cover() {
		super();
	}
	public cover(String image, String captionL, String captionS, String button) {
		super();
		this.image = image;
		this.CaptionL = captionL;
		this.captionS = captionS;
		this.button = button;
	}
	public cover(int id, String image, String captionL, String captionS, String button) {
		super();
		this.id = id;
		this.image = image;
		this.CaptionL = captionL;
		this.captionS = captionS;
		this.button = button;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCaptionL() {
		return CaptionL;
	}
	public void setCaptionL(String captionL) {
		CaptionL = captionL;
	}
	public String getCaptionS() {
		return captionS;
	}
	public void setCaptionS(String captionS) {
		this.captionS = captionS;
	}
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	

}
