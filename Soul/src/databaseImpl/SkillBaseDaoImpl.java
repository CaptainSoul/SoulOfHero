package databaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseDao.DaoException;
import databaseDao.SkillBaseDao;
import databaseUtils.JdbcUtils;
import skill.SkillBase;

public class SkillBaseDaoImpl implements SkillBaseDao {

	@Override
	public void addSkillBase(SkillBase skillBase) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO skillbase(code, spritecode)"
					+ " VALUES (?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, skillBase.getCode());
			st.setInt(2, skillBase.getSpriteCode());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public SkillBase getSkillBase(int code) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM skillbase WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, code);
			rs = st.executeQuery();
			SkillBase skillBase = new SkillBase();
			while(rs.next()) {
				skillBase.setSkillCode(rs.getInt("skillcode"));
				skillBase.setSpriteCode(rs.getInt("spritecode"));
				SkillBase.reNumSkillBase();
			}
			return skillBase;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(SkillBase skillBase) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE skillBase SET  skillcode = ? ,spritecode = ? WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, skillBase.getSkillCode());
			st.setInt(2, skillBase.getSpriteCode());
			st.setInt(3, skillBase.getCode());
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
	public int delete(SkillBase skillBase) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM skillBase WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, skillBase.getCode());
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
