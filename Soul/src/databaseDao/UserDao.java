package databaseDao;

import archive.User;

public interface UserDao {
	public void addUser(User user);
	public User getUser(String ID);
	public User[] getUsers();
	public int update(User user);
	public int delete(User user);
	public int getCount();
}
