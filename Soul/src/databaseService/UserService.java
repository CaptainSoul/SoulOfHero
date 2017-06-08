package databaseService;

import archive.User;
import databaseDao.DaoFactory;
import databaseDao.UserDao;

public class UserService {
	private UserDao userDao;
	
	public UserService() {
		userDao = DaoFactory.getInstace().createUserDao();
		System.out.println("userDao: " + userDao);
	}
	
	public void add(User user) {
		if(user == null)
			System.out.println("Invalid addition!!");
		else
			userDao.addUser(user);
	}
	
	public User query(String ID) {
		int count = userDao.getCount();
		if(count <= 0)
			return null;
		User user = userDao.getUser(ID);
		if(user == null)
			System.out.println("The query result is empty!!");
		else
			System.out.println(user.toString());
		return user;
	}
	
	public void delete(User user) {
		if(user.getID().equals(""))
			System.out.println("Invalid information, cannot delete!!");
		else
			userDao.delete(user);
	}
	
	public User[] getAll() {
		User[] users = userDao.getUsers();
		if(users.length == 0) {
			System.out.println("Empty table!!");
			return null;
		} else
			return users;
	}
}
