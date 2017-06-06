package databaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import archive.Code;
import character.Sprite;
import inventory.Armor;
import inventory.Food;
import inventory.Inventory;
import inventory.Item;
import inventory.Weapon;
import skill.Skill;
import skill.SkillBase;

public class DatabaseMethod {
	public String DBURL = "jdbc:mysql://localhost:3306/SaveSoul?characterEncoding=gbk&useSSL=true";
	private static Connection connect;
	private static Statement state;
	
	//method used by other class to build connection
	private static void buildConnect(){
		try{
			connect = DriverManager.getConnection(SaveAndLoad.DBURL,SaveAndLoad.DBUSER,SaveAndLoad.DBPASS);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection connect(){
		if(connect == null) {
			buildConnect();
		}
		return connect;
	}
	
	//method used by other class to build statement
	private static void buildState() {
		try{
			state = connect.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Statement state() {
		if(state == null) {
			buildState();
		}
		return state;
	}
	
	//method used to close JDBC connection
	public void closeConnection() {
		if (state != null) {
			try{
				state.close();
				}catch (SQLException e) {
				e.printStackTrace();
				}
		}
		if (connect != null){
			try{
				if(!connect.isClosed()){
					connect.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//method used to insert values into table Item
	public static void InsertItem(Item item) {
		String sql = "INSERT INTO Item ("
				+ "code, "
				+ "name, "
				+ "description "
				+ ") VALUES ("
				+ item.getCode()
				+ ", '" + item.getName() + "'"
				+ ", '" + item.getDescription() +"'"
				+");";
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method used to insert values into table Armor
	public static void InsertArmor(Armor armor) {
		String sql = "INSERT INTO Armor ("
				+ "code, "
				+ "name, "
				+ "description, "
				+ "defence "
				+ ") VALUES ("
				+ armor.getCode()
				+ ", '" + armor.getName() + "'"
				+ ", '" + armor.getDescription() +"', "
				+ armor.getDefence()
				+ ");";
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method used to insert values into table Weapon
	public static void InsertWeapon(Weapon weapon) {
		
		String sql = "INSERT INTO Weapon ("
				+ "code, "
				+ "name, "
				+ "description, "
				+ "strength"
				+ ") VALUES ("
				+ weapon.getCode() 
				+ ", '" + weapon.getName() + "' "
				+ ", '" + weapon.getDescription() +"', "
				+ weapon.getStrength()
				+ ");";
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method used to insert values into table Food
	public static void InsertFood(Food food) {
		String sql = "INSERT INTO Food ("
				+ "code, "
				+ "name, "
				+ "description, "
				+ "hp, "
				+ "mp "
				+ ") VALUES ("
				+ food.getCode() 
				+ ", '" + food.getName() + "'"
				+ ", '" + food.getDescription() +"', "
				+ food.getHp() + ", "
				+ food.getMp()
				+ ");";
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method used to insert values into table inventory
	public static void InsertInventory(Inventory inventory, int armorCode, int weaponCode, int foodCode ) {
		String sql = "INSERT INTO Inventory ("
				+ "code, "
				+ "armorCode, "
				+ "weaponCode, "
				+ "foodCode"
				+ ") VALUES ("
				+ inventory.getCode() + ", "
				+ armorCode + ", "
				+ weaponCode + ", "
				+ foodCode
				+ ");";
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method used to insert values into table Sprite
	public void InsertSprite(Sprite sprite, int armorCode, int weaponCode, int skillBaseCode, int inventoryCode) {
		String sql = "INSERT INTO Sprite ("
				+ "code, "
				+ "name, "
				+ "hp, "
				+ "MAX_HP, "
				+ "mp, "
				+ "MAX_MP, "
				+ "level, "
				+ "defence, "
				+ "strength, "
				+ "skillBase, "
				+ "inventoryCode, "
				+ "armorCode, "
				+ "weaponCode, "
				+ "gold"
				+ ") VALUES ("
				+ sprite.getCode() + ", "
				+ sprite.getName() + "', "
				+ sprite.getHp() + ", "
				+ sprite.getMaxHp() + ", "
				+ sprite.getMp() + ", "
				+ sprite.getMaxMp() + ", "
				+ sprite.getLevel() + ", "
				+ sprite.getDefence() + ", "
				+ sprite.getStrength() + ", "
				+ skillBaseCode + ", "
				+ inventoryCode + ", "
				+ armorCode + ", "
				+ weaponCode + ", "
				+ sprite.getGold()
				+ ");";
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to insert information into table map
	/*public void InsertMap(Map map){
		String sql = "INSERT INTO Sprite ("
				+ "code, "
				+ "tileWidth, "
				+ "tileHeight, "
				+ "cols"
				+ ") VALUES ("
				+ map.getCode() + ", "
				+ map.get
				+ ");";
		
	}*/
	
	//method to insert values into table skill
	public static void InsertSkill(Skill skill){
		String sql = "INSERT INTO SKill ("
				+ "code, "
				+ "name, "
				+ "description, "
				+ "damage"
				+ ") VALUES ("
				+ skill.getCode() + ", "
				+ "'" + skill.getName() + "', "
				+ "'" + skill.getDescription() + "', "
				+ skill.getDamage()
				+ ");";
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to insert values into table sill base
	public static void InsertSkillBase(SkillBase skillBase){
		String sql = "INSERT INTO SKILLBase ("
				+ "code"
				+ ") VALUE ("
				+ skillBase.getCode() 
				+ ");";
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method used to remove a line of table
	public static void Delete(String tableName,int code) {
		String sql = "DELETE FROM "+ tableName + " WHERE code = " + code;
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method used to update an attribute
	public void Update(String tableName, String attribute, String terminal, Code code) {
		String sql = "UPDATE " + tableName + " SET " + attribute + " = " + terminal + " WHERE Code = " + code;
		try{
			state.execute("USE SaveSoul");
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}	