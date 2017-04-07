package archive;

public class User {
	private String ID;
	private String password;
	private final int code;
	private static int numUsers = 0;
	
	public User() {
		code = Code.getCode(this);
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
	
	public String getPassword() {
		return password;
	}
	
}
