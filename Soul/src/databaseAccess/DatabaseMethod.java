package databaseAccess;

import archive.Code;
import character.Sprite;
import inventory.Armor;
import inventory.Food;
import inventory.Inventory;
import inventory.Item;
import inventory.Weapon;

public class DatabaseMethod {
	
	public String sql;
	
	//method used to insert values into table Item
	public void InsertItem(Item item){
		sql = "INSERT INTO Item ("
				+ "code, "
				+ "name, "
				+ "description "
				+ ") VALUES ("
				+item.getCode()
				+ ", '" + item.getName() + "'"
				+ ", '" + item.getDescription() +"'"
				+");";
	}
	
	//method used to insert values into table Armor
	public void InsertArmor(Armor armor){
		sql = "INSERT INTO Armor ("
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
	}
	
	//method used to insert values into table Weapon
	public void InsertWeapon(Weapon weapon){
		sql = "INSERT INTO Weapon ("
				+ "code, "
				+ "name, "
				+ "description, "
				+ "strength"
				+ ") VALUES ("
				+ weapon.getCode() 
				+ ", '" + weapon.getName()
				+ ", '" + weapon.getDescription() +"', "
				+ weapon.getStrength()
				+ ");";
	}
	
	//method used to insert values into table Food
	public void InsertFood(Food food){
		sql = "INSERT INTO Food ("
				+ "code, "
				+ "name, "
				+ "description, "
				+ "hp, "
				+ "mp, "
				+ ") VALUE ("
				+ food.getCode() 
				+ ", '" + food.getName()
				+ ", '" + food.getDescription() +"', "
				+ food.getHp() + ", "
				+ food.getMp()
				+ ");";
	}
	
	//method used to insert values into table inventory
	public void InsertInventory(Inventory inventory, int armorCode, int weaponCode, int foodCode ){
		sql = "INSERT INTO Inventory ("
				+ "code, "
				+ "armorCode, "
				+ "weaponCode, "
				+ "foodCode"
				+ ") VALUES ("
				+ inventory.getCode() + ", "
				+ inventory.getArmor(armorCode) + ", "
				+ inventory.getWeapon(weaponCode) + ", "
				+ inventory.getFood(foodCode)
				+ ");";
	}
	
	//method used to insert values into table Sprite
	public void InsertSprite(Sprite sprite, int skillCode){
		sql = "INSERT INTO Sprite ("
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
				+ "'" + sprite.getName() + "', "
				+ sprite.getHp() + ", "
				+ sprite.getMaxHp() + ", "
				+ sprite.getMp() + ", "
				+ sprite.getMaxMp() + ", "
				+ sprite.getLevel() + ", "
				+ sprite.getDefence() + ", "
				+ sprite.getStrength() + ", "
				+ sprite.getSkill(skillCode) + ", "
				+ sprite.getArmor() + ", "
				+ sprite.getWeapon() + ", "
				+ sprite.getGold()
				+ ");";
	}
	
	//method used to remove a line of table
	public void Delete(String tableName,Code code){
		sql = "DELETE FROM "+ tableName + " WHERE code = " + code;
	}
	
	//method used to update an attribute
	public void Update(String tableName, String attribute, String terminal, Code code){
		sql = "UPDATE " + tableName + " SET " + attribute + " = " + terminal + " WHERE Code = " + code;
	}
}	