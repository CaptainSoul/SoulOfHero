package databaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseDao.DaoException;
import databaseDao.ItemDao;
import databaseUtils.JdbcUtils;
import inventory.Item;

public class ItemDaoImpl implements ItemDao {

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO item(code, name, description,inventorycode)"
					+ " VALUES (?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, item.getCode());
			st.setString(2,item.getName());
			st.setString(3,item.getDescription());
			st.setInt(4, item.getInventoryCode());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Item getItem(int code) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM item WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, code);
			rs = st.executeQuery();
			String s1 = null;
			String s2 = null;
			Item item = new Item(s1, s2);
			while(rs.next()) {
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setInventoryCode(rs.getInt("inventorycode"));
				Item.reNumItems();
			}
			return item;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Item item) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE item SET  name = ? , description = ? , inventorycode = ? WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setString(1, item.getName());
			st.setString(2, item.getDescription());
			st.setInt(3, item.getInventoryCode());
			st.setInt(4, item.getCode());
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
	public int delete(Item item) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM item WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, item.getCode());
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
