package databaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import character.Sprite;
import character.Sprite.Group;
import databaseDao.DaoException;
import databaseDao.SpriteDao;
import databaseUtils.JdbcUtils;
import inventory.Item;

public class SpriteDaoImpl implements SpriteDao {

	@Override
	public void addSprite(Sprite sprite) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO sprite(code, name, hp,mp, strength,defence,exp,level,gold,move,group,armorcode,weaponcode,inventorycode)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, sprite.getCode());
			st.setString(2,sprite.getName());
			st.setInt(3,sprite.getHp());
			st.setInt(4,sprite.getMp());
			st.setInt(5,sprite.getStrength());
			st.setInt(6,sprite.getDefence());
			st.setInt(7,sprite.getExp());
			st.setInt(8,sprite.getLevel());
			st.setInt(9,sprite.getGold());
			st.setInt(10,sprite.getMove());
			st.setString(11, sprite.getGroup().toString());
			st.setInt(12,sprite.getArmorCode());
			st.setInt(13,sprite.getWeaponCode());
			st.setInt(14,sprite.getInventoryCode());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Sprite getSprite(int code) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM sprite WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, code);
			rs = st.executeQuery();
			Sprite sprite = new Sprite(null, 0, 0, 0, 0);
			while(rs.next()) {
				sprite.setName(rs.getString("name"));
				sprite.setHp(rs.getInt("hp"));
				sprite.setMp(rs.getInt("mp"));
				sprite.setStrength(rs.getInt("strength"));
				sprite.setDefence(rs.getInt("defence"));
				sprite.setExp(rs.getInt("exp"));
				sprite.setLevel(rs.getInt("level"));
				sprite.setGold(rs.getInt("gold"));
				sprite.setMove(rs.getInt("move"));
				//setGroup
				if ( rs.getString("group").equals("PLAYER")){
					sprite.setGroup(Group.PLAYER);
				}
				else if (rs.getString("group").equals("COMMON")){
					sprite.setGroup(Group.COMMON);
				}
				else if (rs.getString("group").equals("ENEMY")){
					sprite.setGroup(Group.ENEMY);
				}
				sprite.setArmorCode(rs.getInt("armorcode"));
				sprite.setWeaponCode(rs.getInt("weaponcode"));
				sprite.setInventoryCode(rs.getInt("inventorycode"));
				Sprite.reNumCharacters();
			}
			return sprite;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Sprite sprite) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE sprite SET  name = ? , hp = ? ,  mp = ? , strength = ? ,  defence = ? ,  exp = ? , level = ? ,  gold = ? ,  move = ? ,  group = ? , armorcode = ? ,  weaponcode = ? , inventorycode = ? ,  WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setString(1,sprite.getName());
			st.setInt(2,sprite.getHp());
			st.setInt(3,sprite.getMp());
			st.setInt(4,sprite.getStrength());
			st.setInt(5,sprite.getDefence());
			st.setInt(6,sprite.getExp());
			st.setInt(7,sprite.getLevel());
			st.setInt(8,sprite.getGold());
			st.setInt(9,sprite.getMove());
			st.setString(10, sprite.getGroup().toString());
			st.setInt(11,sprite.getArmorCode());
			st.setInt(12,sprite.getWeaponCode());
			st.setInt(13,sprite.getInventoryCode());
			st.setInt(14, sprite.getCode());
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
	public int delete(Sprite sprite) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM sprite WHERE code = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, sprite.getCode());
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
