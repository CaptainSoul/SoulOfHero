package archive;

import dsa.impl.BSTMap;

public class UserManagement {
	private static BSTMap<String, User> users;
	
	public static boolean checkPassword(String ID, String password) {
		User user = users.get(ID);
		if(user == null) {
			return false;
		}
		if(user.getPassword() == password){
			//open game
			return true;
		}
		return false;
	}
	
}
