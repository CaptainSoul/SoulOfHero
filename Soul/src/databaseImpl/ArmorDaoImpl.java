package databaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseDao.ArmorDao;
import databaseDao.DaoException;
import databaseUtils.JdbcUtils;
import inventory.Armor;
import inventory.Item;

public class ArmorDaoImpl implements ArmorDao {

	@Override
	public void addArmor(Armor armor) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql1 = "INSERT INTO item(code, name, description)"
					+ "VALUES (?,?,?)";
			st1 = con.prepareStatement(sql1);
			st1.setInt(1, armor.getCode());
			st1.setString(2,armor.getName());
			st1.setString(3,armor.getDescription());
			st1.executeUpdate();
			String sql2 = "INSERT INTO armor(code, defence)"
					+ " VALUES (?,?)";
			st2 = con.prepareStatement(sql2);
			st2.setInt(1, armor.getCode());
			st2.setInt(2, armor.getDefence());
			int count = st2.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st1, con);
			JdbcUtils.free(null, st2, con);
		}
	}

	@Override
	public Armor getArmor(int code) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM armor WHERE code = ?";
			String sql2 = "SELECT * FROM item WHERE code = ?";
			st = con.prepareStatement(sql);
			st2 = con.prepareStatement(sql2);
			st.setInt(1, code);
			st2.setInt(1, code);
			rs = st.executeQuery();
			rs2 = st2.executeQuery();
			Armor armor = new Armor(null,null,0);
			while(rs.next()) {
				armor.setDefence(rs.getInt("defence"));
				armor.setName(rs2.getString("name"));
				armor.setDescription(rs2.getString("description"));
				armor.setInventoryCode(rs2.getInt("inventorycode"));
				Item.reNumItems();
			}
			return armor;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
			JdbcUtils.free(rs2, st2, con);
		}
	}

	@Override
	public int update(Armor armor) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE armor SET  defence = ? WHERE code = ?";
			String sql2 = "UPDATE item SET  name = ? , description = ? , inventorycode = ? WHERE code = ?";
			st = con.prepareStatement(sql);
			st2 = con.prepareStatement(sql2);
			st.setInt(1, armor.getDefence());
			st.setInt(2, armor.getCode());
			st2.setString(1, armor.getName());
			st2.setString(2, armor.getDescription());
			st2.setInt(3, armor.getInventoryCode());
			st2.setInt(4, armor.getCode());
			int count = st.executeUpdate();
			System.out.println("Update record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
			JdbcUtils.free(null, st2, con);
		}
	}

	@Override
	public int delete(Armor armor) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM armor WHERE code = ?";
			String sql2 = "DELETE FROM item WHERE code = ?";
			st = con.prepareStatement(sql);
			st2 = con.prepareStatement(sql2);
			st.setInt(1, armor.getCode());
			st2.setInt(1, armor.getCode());
			int count = st.executeUpdate();
			System.out.println("Delete record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
			JdbcUtils.free(null, st2, con);
		}
	}

}
