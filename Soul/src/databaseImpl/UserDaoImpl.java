package databaseImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import archive.User;
import character.Sprite;
import databaseDao.DaoException;
import databaseDao.UserDao;
import databaseService.SpriteService;
import databaseUtils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		Connection con  = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO users(code, ID, password, dateOfSignUp, spriteCode, canvasCode)"
					+ " VALUES (?,?,?,?,?,?);";
			st = con.prepareStatement(sql);
			st.setInt(1, user.getCode());
			st.setString(2, user.getID());
			st.setString(3, user.getPassword());
			st.setDate(4, new Date(user.getDateOfSignUp().getTime()));
			st.setInt(5, user.getSprite().getCode());
			st.setInt(6, user.getCanvasCode());
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
				int code = rs.getInt("code");
				Date dateOfSignUp = rs.getDate("dateOfSignUp");
				User user = new User(ID, password, code, dateOfSignUp);
				SpriteService spriteService = new SpriteService();
				Sprite sprite = spriteService.query(rs.getInt("spriteCode"));
				user.setSprite(sprite);
				user.setCanvasCode(rs.getInt("canvasCode"));
				return user;
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
		return null;
	}

	@Override
	public int update(User user) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE users SET ID = ?, password = ?, dateOfSignUp = ?, spriteCode = ?, canvasCode = ?"
					+ " WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setString(1, user.getID());
			st.setString(2, user.getPassword());
			st.setDate(3, new Date(user.getDateOfSignUp().getTime()));
			st.setInt(4, user.getSprite().getCode());
			st.setInt(5, user.getCanvasCode());
			st.setInt(6, user.getCode());
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
			String sql = "DELETE FROM users WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, user.getCode());
			int count = st.executeUpdate();
			System.out.println("Delete record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}
	
}
