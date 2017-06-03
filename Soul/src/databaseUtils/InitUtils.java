package databaseUtils;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class InitUtils {
	public static void createDataBase() {
		Connection con = null;
		Statement st = null;
		try{
			con = JdbcUtils.getBasicConnection();
			st = con.createStatement();

			String sql = "CREATE DATABASE SoulOfHero";
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "new success", "message", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "can not do repititive new database", "error", JOptionPane.ERROR_MESSAGE);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}
	
	public static void dropDatabase() {
		Connection con = null;
		Statement st = null;
		try{
			con = JdbcUtils.getBasicConnection();
			st = con.createStatement();
			
			String sql = "DROP DATABASE SoulOfHero";
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "drop success", "message", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "you need create a database firstly", "error", JOptionPane.ERROR_MESSAGE);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}
	
	public static void initTables(){
		Connection con = null;
		Statement st = null;
		try{
			con = JdbcUtils.getConnection();
			st = con.createStatement();
			
			
			String sql = "CREATE TABLE inventory("
					+ "code INT PRIMARY KEY,"
					+ "maxitem INT DEFAULT 20 NOT NULL)";
			st.execute(sql);

			sql = "CREATE TABLE item("
				+ "code INT PRIMARY KEY,"
				+ "name VARCHAR(20) NOT NULL,"
				+ "description VARCHAR(100) NOT NULL,"
				+ "inventorycode INT,"
				+ ""
				+ "FOREIGN KEY (inventorycode) REFERENCES inventory(code) ON DELETE SET NULL ON UPDATE CASCADE"
				+ ")AUTO_INCREMENT=10000000";
			st.execute(sql);
	 
			sql = "CREATE TABLE armor("
					+ "code INT PRIMARY KEY,"
					+ "defence INT NOT NULL,"
					+ ""
					+ "FOREIGN KEY (code) REFERENCES item(code) ON DELETE SET NULL ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10100000";
				st.execute(sql);
			
			sql = "CREATE TABLE weapon("
					+ "code INT PRIMARY KEY,"
					+ "strength INT NOT NULL,"
					+ ""
					+ "FOREIGN KEY (code) REFERENCES item(code) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10200000";
			st.execute(sql);

			sql = "CREATE TABLE food("
					+ "code INT PRIMARY KEY,"
					+ "hp INT NOT NULL,"
					+ "mp INT NOT NULL,"
					+ ""
					+ "FOREIGN KEY (code) REFERENCES item(code) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10300000";
			st.execute(sql);
			
			sql = "CREATE TABLE skill("
					+ "code INT PRIMARY KEY,"
					+ "name VARCHAR(20) NOT NULL UNIQUE,"
					+ "descripton VARCHAR(100) NOT NULL,"
					+ "damage DOUBLE NOT NULL,"
					+ ""
					+ ")AUTO_INCREMENT=10300000";
			st.execute(sql);
			
			sql = "CREATE TABLE sprite("
					+ "code INT PRIMARY KEY,"
					+ "name VARCHAR(20) NOT NULL UNIQUE,"
					+ "hp INT NOT NULL,"
					+ "mp INT NOT NULL,"
					+ "strength INT NOT NULL,"
					+ "defence INT NOT NULL,"
					+ "level INT Default 1 NOT NULL,"
					+ "gold INT NOT NULL,"
					+ "exp INT NOT NULL,"
					+ "move INT Default 0 NOT NULL,"
					+ "inventorycode INT,"
					+ "armorcode INT,"
					+ "weaponcode INT,"
					+ "FOREIGN KEY (inventorycode) REFERENCES inventory(code) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY (armorcode) REFERENCES aromor(code) ON DELETE CASCADE ON UPDATE CASCADE"
					+ "FOREIGN KEY (weaponcode) REFERENCES weaponcode(code) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10400000";
			st.execute(sql);
			
			sql = "CREATE TABLE skillbase("
					+ "code INT PRIMARY KEY,"
					+ "spritecode INT,"
					+ "skillcode INT,"
					+ ""
					+ "FOREIGN KEY (skillcode) REFERENCES skill(code) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY (spritecode) REFERENCES sprite(code) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10500000";
			st.execute(sql);
			
			sql = "ALTER TABLE sprite ADD COLUMN group ENUM('PLAYER','COMMON','ENEMY')(";
			
			st.execute(sql);
			
			
			JOptionPane.showMessageDialog(null, "initialize success", "message", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "can not do repititive initial options or you need new database", "error", JOptionPane.ERROR_MESSAGE);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}
	
	public static void main(String[] args) {
		initTables();
	}
}
