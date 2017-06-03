package databaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseDao.DaoException;
import databaseDao.FoodDao;
import databaseUtils.JdbcUtils;
import inventory.Food;
import inventory.Item;

public class FoodDaoImpl implements FoodDao {

	@Override
	public void addFood(Food food) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO item(code, name, description,inventorycode)"
					+ "VALUES (?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, food.getCode());
			st.setString(2,food.getName());
			st.setString(3,food.getDescription());
			st.setInt(4, food.getInventoryCode());
			String sql2 = "INSERT INTO food(code, hp, mp)"
					+ " VALUES (?,?,?)";
			st2 = con.prepareStatement(sql2);
			st2.setInt(1, food.getCode());
			st2.setInt(2, food.getHp());
			st2.setInt(3, food.getMp());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
			JdbcUtils.free(null, st2, con);
		}
	}

	@Override
	public Food getFood(int code) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM food WHERE code = ?";
			String sql2 = "SELECT * FROM item WHERE code = ?";
			st = con.prepareStatement(sql);
			st2 = con.prepareStatement(sql2);
			st.setInt(1, code);
			st2.setInt(1, code);
			rs = st.executeQuery();
			rs2 = st2.executeQuery();
			Food food = new Food(null, null, 0, 0);
			while(rs.next()) {
				food.setHp(rs.getInt("hp"));
				food.setMp(rs.getInt("mp"));
				food.setName(rs2.getString("name"));
				food.setDescription(rs2.getString("description"));
				food.setInventoryCode(rs2.getInt("inventorycode"));
				Item.reNumItems();
			}
			return food;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
			JdbcUtils.free(rs2, st2, con);
		}
	}

	@Override
	public int update(Food food) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE food SET  hp = ? , mp = ?  WHERE code = ?";
			String sql2 = "UPDATE item SET  name = ? , description = ? , inventorycode = ? WHERE code = ?";
			st = con.prepareStatement(sql);
			st2 = con.prepareStatement(sql2);
			st.setInt(1, food.getHp());
			st.setInt(2, food.getMp());
			st.setInt(3, food.getCode());
			st2.setString(1, food.getName());
			st2.setString(2, food.getDescription());
			st2.setInt(3, food.getInventoryCode());
			st2.setInt(4, food.getCode());
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
	public int delete(Food food) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM food WHERE code = ?";
			String sql2 = "DELETE FROM item WHERE code = ?";
			st = con.prepareStatement(sql);
			st2 = con.prepareStatement(sql2);
			st.setInt(1, food.getCode());
			st2.setInt(1, food.getCode());
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
