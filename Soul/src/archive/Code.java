package archive;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import character.Sprite;
import databaseDao.DaoException;
import databaseUtils.JdbcUtils;
import inventory.Inventory;
import inventory.Item;
import map.Map;
import skill.Skill;
import skill.SkillBase;

public class Code {
	private static final int scalar = 71;
	private static final int shift = 7;
	private static final int addedSprite = 1000000;
	private static final int addedItem = 1010000;
	private static final int addedMap = 1020000;
	private static final int addedInventory = 1030000;
	private static final int addedUser = 1040000;
	private static final int addedSkill = 1050000;
	private static final int addedArchive = 1060000;
	private static final int addedSkillBase = 1070000;

	public static int getCode(Sprite sprite) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM sprite ORDER BY code DESC LIMIT 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int num = (rs.getInt("code") - addedSprite - shift) / scalar;
				User.setNumUsers(num + 1);
			}
			return Sprite.getNumCharacters() * scalar + shift + addedSprite;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}
	
	public static int getCode(Item item) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM users ORDER BY code DESC LIMIT 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int num = (rs.getInt("code") - addedItem - shift) / scalar;
				Item.setNumItems(num + 1);
			}
			return Item.getNumItems() * scalar + shift + addedItem;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}
	
	public static int getCode(Map map) {
		return map.getNumMaps() * scalar + shift + addedMap;
	}
	
	public static int getCode(Inventory inventory) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM inventory ORDER BY code DESC LIMIT 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int num = (rs.getInt("code") - addedInventory - shift) / scalar;
				Inventory.setNumInventories(num + 1);
			}
			return Inventory.getNumInventories() * scalar + shift + addedInventory;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}
	
	public static int getCode(User user) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM users ORDER BY code DESC LIMIT 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int num = (rs.getInt("code") - addedUser - shift) / scalar;
				User.setNumUsers(num + 1);
			}
			return User.getNumUsers() * scalar + shift + addedUser;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}
	
	public static int getCode(Skill skill) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM skill ORDER BY code DESC LIMIT 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int num = (rs.getInt("code") - addedSkill - shift) / scalar;
				Skill.setNumSkills(num + 1);
			}
			return Skill.getNumSkills() * scalar + shift + addedSkill;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}
	
	public static int getCode(SkillBase skillBase){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM skill ORDER BY code DESC LIMIT 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int num = (rs.getInt("code") - addedSkillBase - shift) / scalar;
				SkillBase.setNumSkillBase(num + 1);
			}
			return SkillBase.getNumSkillBase() * scalar + shift + addedSkillBase;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}
	
	public static int getCode(Archive archive) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM archives ORDER BY code DESC LIMIT 1";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int num = (rs.getInt("code") - addedArchive - shift) / scalar;
				Archive.setNumArchives(num + 1);
			}
			return Archive.getNumArchives() * scalar + shift + addedArchive;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}
	
}
