package archive;

import dsa.impl.BSTMap;

public class UserManagement {
	private static BSTMap<String, User> users = new BSTMap<String, User>();
	
	public static boolean isDuplication(String ID) {
		User user = users.get(ID);
		if(user == null) {
			return false;
		}
		return true;
	}
	
	public static boolean checkPassword(String ID, String password) {
		User user = users.get(ID);
		if(user == null) {
			return false;
		}
		if(user.getPassword().equals(password)){
			return true;
		}
		return false;
	}
	
	public static boolean addUser(String ID, String password) {
		if(users.get(ID) != null) {
			return false;
		}
		User user = new User(ID, password);
		users.put(ID, user);
		return true;
	}
}
