package databaseImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import archive.User;
import databaseDao.DaoException;
import databaseDao.UserDao;
import databaseUtils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		Connection con  = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO users(ID, password, dateOfSignUp)"
					+ " VALUES (?,?,?);";
			st = con.prepareStatement(sql);
			st.setString(1, user.getID());
			st.setString(2, user.getPassword());
			st.setDate(3, new Date(user.getDateOfSignUp().getTime()));
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public User getUser(String ID) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM users WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setString(1, ID);
			rs = st.executeQuery();
			while(rs.next()) {
				String password = rs.getString("password");
				Date dateOfSignUp = rs.getDate("dateOfSignUp");
				User user = new User(ID, password, dateOfSignUp);
				return user;
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
		return null;
	}
	
	public User[] getUsers() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			int count = getCount();
			User[] users = new User[count];
			String sql = "SELECT * FROM users";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			int i = 0;
			while(rs.next()) {
				String ID = rs.getString("ID");
				String password = rs.getString("password");
				Date dateOfSignUp = rs.getDate("dateOfSignUp");
				User user = new User(ID, password, dateOfSignUp);
				users[i] = user;
			}
			return users;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(User user) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE users SET password = ?, dateOfSignUp = ?"
					+ " WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setString(1, user.getPassword());
			st.setDate(2, new Date(user.getDateOfSignUp().getTime()));
			st.setString(3, user.getID());
			int count = st.executeUpdate();
			System.out.println("Update record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public int delete(User user) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM users WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setString(1, user.getID());
			int count = st.executeUpdate();
			System.out.println("Delete record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}
	
	@Override
	public int getCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT COUNT(*) FROM users";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int count = rs.getInt("COUNT(*)");
				return count;
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
		return 0;
	}
}
