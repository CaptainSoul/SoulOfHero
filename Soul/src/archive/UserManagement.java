package archive;

import databaseService.UserService;

public class UserManagement {
	private static UserService userService;
	private static UserManagement userManagement;
	
	private UserManagement(){
		userService = new UserService();
	}
	
	public static UserManagement getUserManagement() {
		if(userManagement == null)
			userManagement = new UserManagement();
		return userManagement;
	}
	
	public boolean isDuplication(String ID) {
		User user = userService.query(ID);
		if(user == null) {
			return false;
		}
		return true;
	}
	
	public boolean checkPassword(String ID, String password) {
		User user = userService.query(ID);
		if(user == null) {
			return false;
		}
		if(user.getPassword().equals(password)){
			return true;
		}
		return false;
	}
	
	public boolean addUser(String ID, String password) {
		if(userService.query(ID) != null)
			return false;
		else if(isDuplication(ID)) {
			throw new RuntimeException("Cannot add a duplicative account");
		}
		User user = new User(ID, password);
		userService.add(user);
		return true;
	}
	
}
