package databaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseDao.DaoException;
import databaseDao.SkillDao;
import databaseUtils.JdbcUtils;
import skill.Skill;

public class SkillDaoImpl implements SkillDao {

	@Override
	public void addSkill(Skill skill) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO skill(code, name, description,damage)"
					+ " VALUES (?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, skill.getCode());
			st.setString(2,skill.getName());
			st.setString(3,skill.getDescription());
			st.setDouble(4,skill.getDamage());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Skill getSkill(int code) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM skill WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, code);
			rs = st.executeQuery();
			Skill skill = new Skill(null, null, 0);
			while(rs.next()) {
				skill.setDamage(rs.getDouble("damage"));
				skill.setName(rs.getString("name"));
				skill.setDescription(rs.getString("description"));
				Skill.reNumSkills();
			}
			return skill;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Skill skill) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE item SET  name = ? , description = ? , damage = ? WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setString(1, skill.getName());
			st.setString(2, skill.getDescription());
			st.setDouble(3, skill.getDamage());
			st.setInt(4, skill.getCode());
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
	public int delete(Skill skill) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM skill WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, skill.getCode());
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
