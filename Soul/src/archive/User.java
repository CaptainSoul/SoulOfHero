package archive;

import java.util.Date;

import character.Sprite;

public class User {
	private String ID;
	private String password;
	private Date dateOfSignUp;
	private Sprite sprite;
	private int canvasCode;
	private final int code;
	private static int numUsers = 0;
	
	public User(String ID, String password) {
		this.ID = ID;
		this.password = password;
		code = Code.getCode(this);
		dateOfSignUp = new Date(System.currentTimeMillis());
	}
	
	public User(String ID, String password, int code, Date dateOfSignUp) {
		this.ID = ID;
		this.password = password;
		this.code = code;
		this.dateOfSignUp = dateOfSignUp;
	}
	
	public int getNumUsers() {
		return numUsers;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getDateOfSignUp() {
		return dateOfSignUp;
	}
	
	public void setDateOfSignUp(Date dateOfSignUp) {
		this.dateOfSignUp = dateOfSignUp;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public int getCanvasCode() {
		return canvasCode;
	}
	
	public void setCanvasCode(int canvasCode) {
		this.canvasCode = canvasCode;
	}
	
}
