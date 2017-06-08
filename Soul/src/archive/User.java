package archive;

import java.util.Date;

public class User {
	private String ID;
	private String password;
	private Date dateOfSignUp;
	private Archive[] archives;
	private static int numUsers = 0;
	
	public User(String ID, String password) {
		this.ID = ID;
		this.password = password;
		dateOfSignUp = new Date(System.currentTimeMillis());
	}
	
	public User(String ID, String password, Date dateOfSignUp) {
		this.ID = ID;
		this.password = password;
		this.dateOfSignUp = dateOfSignUp;
	}
	
	public static int getNumUsers() {
		return numUsers;
	}
	
	public static void setNumUsers(int numUsers) {
		User.numUsers = numUsers;
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
	
	public Archive[] getArchives() {
		return archives;
	}
	
	public void setArchives(Archive[] archives) {
		this.archives = archives;
	}
	
}
