package databaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseDao.DaoException;
import databaseDao.InventoryDao;
import inventory.Inventory;
import databaseUtils.JdbcUtils;

public class InventoryDaoImpl implements InventoryDao{

	@Override
	public void addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO inventory(code, maxitem)"
					+ " VALUES (?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, inventory.getCode());
			st.setInt(2, inventory.getMaxItem());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Inventory getInventory(int code) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM inventory WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, code);
			rs = st.executeQuery();
			Inventory inventory = new Inventory();
			while(rs.next()) {
				inventory.setMaxItem(rs.getInt("maxitem"));
				Inventory.reNumInventories();
			}
			return inventory;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Inventory inventory) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE inventory SET  maxitem = ? WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, inventory.getMaxItem());
			st.setInt(2, inventory.getCode());
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
	public int delete(Inventory inventory) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM inventory WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, inventory.getCode());
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
