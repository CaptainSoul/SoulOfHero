package databaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import archive.Archive;
import archive.User;
import character.Sprite;
import databaseDao.ArchiveDao;
import databaseDao.DaoException;
import databaseService.SpriteService;
import databaseService.UserService;
import databaseUtils.JdbcUtils;

public class ArchiveDaoImpl implements ArchiveDao {

	@Override
	public void addArchive(Archive archive) {
		Connection con  = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO archives(code, name, userCode, spriteCode, taskProgress)"
					+ " VALUES (?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, archive.getCode());
			st.setString(2, archive.getName());
			st.setInt(3, archive.getUser().getCode());
			st.setInt(4, archive.getSprite().getCode());
			st.setInt(5, archive.getTaskProgress());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
		
	}

	@Override
	public Archive getArchive(int code) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM archives WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, code);
			rs = st.executeQuery();
			SpriteService spriteService = new SpriteService();
			while(rs.next()) {
				Archive archive = new Archive(rs.getString("name"));
				UserService userService = new UserService();
				User user = userService.query(rs.getString("userID"));
				archive.setUser(user);
				Sprite sprite = spriteService.query(rs.getInt("spriteCode"));
				if(sprite != null)
					archive.setSprite(sprite);
				archive.setTaskProgress(rs.getInt("taskProgress"));
				return archive;
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
		return null;
	}

	@Override
	public Archive[] getArchives(User user) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			int count = getCount(user);
			Archive[] archives = new Archive[count];
			String sql = "SELECT * FROM archives WHERE userCode = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, user.getCode());
			rs = st.executeQuery();
			int i = 0;
			SpriteService spriteService = new SpriteService();
			while(rs.next()) {
				Archive archive = new Archive(rs.getString("name"));
				archive.setUser(user);
				Sprite sprite = spriteService.query(rs.getInt("spriteCode"));
				if(sprite != null)
					archive.setSprite(sprite);
				archive.setTaskProgress(rs.getInt("taskProgress"));
				archives[i] = archive;
			}
			return archives;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Archive archive) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE archives SET name = ?, userID = ?, spriteCode = ?, taskProgress = ?)"
					+ " WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setString(1, archive.getName());
			st.setString(2, archive.getUser().getID());
			st.setInt(3, archive.getSprite().getCode());
			st.setInt(4, archive.getTaskProgress());
			st.setInt(5, archive.getCode());
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
	public int delete(Archive archive) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM archives WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, archive.getCode());
			int count = st.executeUpdate();
			System.out.println("Delete record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int getCount(User user) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT COUNT(*) FROM archives WHERE userID = ?";
			st = con.prepareStatement(sql);
			st.setString(1, user.getID());
			rs = st.executeQuery();
			while(rs.next()) {
				int count = rs.getInt("COUNT(*)");
				return count;
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
		return 0;
	}

	@Override
	public int getCount() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT COUNT(*) FROM archives";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				int count = rs.getInt("COUNT(*)");
				return count;
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
		return 0;
	}

}
