package databaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseDao.DaoException;
import databaseDao.WeaponDao;
import databaseUtils.JdbcUtils;
import inventory.Item;
import inventory.Weapon;

public class WeaponDaoImpl implements WeaponDao {

	@Override
	public void addWeapon(Weapon weapon) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO item(code, name, description,inventorycode)"
					+ "VALUES (?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, weapon.getCode());
			st.setString(2,weapon.getName());
			st.setString(3,weapon.getDescription());
			st.setInt(4, weapon.getInventoryCode());
			String sql2 = "INSERT INTO weapon(code, strength)"
					+ " VALUES (?,?)";
			st2 = con.prepareStatement(sql2);
			st2.setInt(1, weapon.getCode());
			st2.setInt(2, weapon.getStrength());
			int count = st2.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
			JdbcUtils.free(null, st2, con);
		}
	}

	@Override
	public Weapon getWeapon(int code) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM weapon WHERE code = ?";
			String sql2 = "SELECT * FROM item WHERE code = ?";
			st = con.prepareStatement(sql);
			st2 = con.prepareStatement(sql2);
			st.setInt(1, code);
			st2.setInt(1, code);
			rs = st.executeQuery();
			rs2 = st2.executeQuery();
			Weapon weapon = new Weapon(null,null,0);
			while(rs.next()) {
				weapon.setStrength(rs.getInt("strength"));
				weapon.setName(rs2.getString("name"));
				weapon.setDescription(rs2.getString("description"));
				weapon.setInventoryCode(rs2.getInt("inventorycode"));
				Item.reNumItems();
			}
			return weapon;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
			JdbcUtils.free(rs2, st2, con);
		}
	}

	@Override
	public int update(Weapon weapon) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE weapon SET  strength = ? WHERE code = ?";
			String sql2 = "UPDATE item SET  name = ? , description = ? , inventorycode = ? WHERE code = ?";
			st = con.prepareStatement(sql);
			st2 = con.prepareStatement(sql2);
			st.setInt(1, weapon.getStrength());
			st.setInt(2, weapon.getCode());
			st2.setString(1, weapon.getName());
			st2.setString(2, weapon.getDescription());
			st2.setInt(3, weapon.getInventoryCode());
			st2.setInt(4, weapon.getCode());
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
	public int delete(Weapon weapon) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM weapon WHERE code = ?";
			String sql2 = "DELETE FROM item WHERE code = ?";
			st = con.prepareStatement(sql);
			st2 = con.prepareStatement(sql2);
			st.setInt(1, weapon.getCode());
			st2.setInt(1, weapon.getCode());
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
