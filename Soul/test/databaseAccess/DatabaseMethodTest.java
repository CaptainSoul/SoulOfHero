package databaseAccess;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import character.Sprite;
import inventory.Armor;
import inventory.Food;
import inventory.Inventory;
import inventory.Item;
import inventory.Weapon;
import skill.Skill;
import skill.SkillBase;

public class DatabaseMethodTest {
	/*@Test
	public void testConnect() {
		Connection con = databaseAccess.DatabaseMethod.connect();
	}
	@Test
	public void testState() {
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
	}
	
	@Test
	public void testCloseConnection() {
		
	}
	
	@Test
	public void testInsertItem() {
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
		Item ironman = new Item("ironaman", "a cooal suit") ;
		Item ironaman = new Item("ironman", "a cool suit") ;
		System.out.println(ironman .getCode()+ironman.getName()+ironman.getDescription());
		System.out.println(ironaman .getCode()+ironaman.getName()+ironaman.getDescription());
		databaseAccess.DatabaseMethod .InsertItem(ironman);
		databaseAccess.DatabaseMethod .InsertItem(ironaman);
	}
	
	@Test
	public void testInsertArmor(){
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
		Armor sheild = new Armor("sheild", "captain of America", 100000);
		Armor armor = new Armor("armor", "captain of China", 200000);
		System.out.println(sheild.getCode() + sheild.getName() + sheild.getDescription() + sheild.getDefence());
		System.out.println(armor.getCode() + armor.getName() + armor.getDescription() + armor.getDefence());
		databaseAccess.DatabaseMethod.InsertArmor(sheild);
		databaseAccess.DatabaseMethod.InsertArmor(armor);
	}
	
	@Test
	public void testInsertWeapon(){
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
		Weapon sword = new Weapon("sword", "sword from stone", 50000000);
		Weapon harmor = new Weapon("harmor", "soers harmor", 600000000);
		System.out.println(sword.getCode() + sword.getName() + sword.getDescription() + sword.getStrength());
		System.out.println(harmor.getCode() + harmor.getName() + harmor.getDescription() + harmor.getStrength());
		databaseAccess.DatabaseMethod.InsertWeapon(sword);
		databaseAccess.DatabaseMethod.InsertWeapon(harmor);
	}
	
	@Test
	public void testInsertFood(){
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
		Food cake = new Food("cake", "sweat food children like it", 100, 1);
		Food cock = new Food("cock", "cococola", 1, 100);
		System.out.println(cake.getCode() + cake.getName() + cake.getDescription() + cake.getHp() + cake.getMp());
		System.out.println(cock.getCode() + cake.getName() + cock.getDescription() + cock.getHp() + cock.getMp());
		databaseAccess.DatabaseMethod.InsertFood(cake);
		databaseAccess.DatabaseMethod.InsertFood(cock);
	}
	
	@Test
	public void testInsertInventory(){
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
		Inventory bag = new Inventory();
		Inventory handBag = new Inventory();
		databaseAccess.DatabaseMethod.InsertInventory(bag, 1010078, 1010504, 1010220);
		databaseAccess.DatabaseMethod.InsertInventory(handBag, 1010149, 1010575, 1010291);
	}*/
	
	/*@Test
	public void testInsertSprite(){
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
		Sprite cj = new Sprite(name, hp, mp, strength, defence)
	}*/
	
	/*@Test
	public void testInsertSkill(){
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
		Skill kick = new Skill("kick", "kick by foot", 0.1);
		Skill talk = new Skill("talk", "talk with enermy", 2.9);
		System.out.println(kick.getCode() + kick.getName() + kick.getDescription() + kick.getDamage());
		System.out.println(talk.getCode() + talk.getName() + talk.getDescription() + talk.getDamage());
		databaseAccess.DatabaseMethod.InsertSkill(kick);
		databaseAccess.DatabaseMethod.InsertSkill(talk);
	}*/
	
	/*@Test
	public void testInsertSkillBase(){
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
		SkillBase b1 = new SkillBase();
		SkillBase b2 = new SkillBase();
		databaseAccess.DatabaseMethod.InsertSkillBase(b1);
		databaseAccess.DatabaseMethod.InsertSkillBase(b2);
	}*/
	
	@Test
	public void testDelete(){
		Connection con = databaseAccess.DatabaseMethod.connect();
		Statement state = databaseAccess.DatabaseMethod.state();
		databaseAccess.DatabaseMethod.Delete("SkillBase", 1070078);
	}
}
