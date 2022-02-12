package helper;

public class Massage {

	
	private String type;
	private String icon;
	private String css;
	
	
	public Massage(String type, String icon, String css) {
		super();
		this.type = type;
		this.icon = icon;
		this.css = css;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	
	
}
