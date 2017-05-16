package databaseAccess;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Predicate;

public class SaveAndLoad {

		public static final String DBDRIVER = "com.mysql.jdbc.Driver";
		public static final String DBURL = "jdbc:mysql://localhost:3306/?characterEncoding=gbk&useSSL=true";
		public static final String DBUSER = "root";
		public static final String DBPASS = "";
		private Connection con;
		private Statement stmt;
		private ResultSet result;
		
		public static void main(String[] args) throws Exception{
			Connection con = null;
			Statement stmt = null;
			ResultSet result = null;
			Class.forName(DBDRIVER);
			con = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			stmt = con.createStatement();
			//create database called "SaveAndLoad"
			stmt.executeUpdate("CREATE DATABASE SaveSoul");
			stmt.execute("USE SaveSoul");
			//create table Item to save Items' information
			stmt.execute("CREATE TABLE Item("
					+ "code INT PRIMARY KEY, "
					+ "name VARCHAR(20) NOT NULL, "
					+ "description VARCHAR(100)"
					+ ");");
			//create table Armor to save information of armors in inventories
			stmt.execute("CREATE TABLE Armor("
					+ "code INT PRIMARY KEY, "
					+ "name VARCHAR(20), "
					+ "description VARCHAR(100)"
					+ "defence INT"
					+ ");");
			//create table Weapon to save information of weapon in inventories
			stmt.execute("CREATE TABLE Weapon("
					+ "code INT PRIMARY KEY, "
					+ "name VARCHAR(20), "
					+ "description VARCHAR(100),"
					+ "strength INT"
					+ ");");
			//create table Food to save information of food in inventories
			stmt.execute("CREATE TABLE Food("
					+ "code INT PRIMARY KEY, "
					+ "name VARCHAR(20),"
					+ "description VARCHAR(100),"
					+ "hp INT NOT NULL,"
					+ "mp INT NOT NULL"
					+ ");");
			//create table Inventory to save information of all inventories
			stmt.execute("CREATE TABLE Inventory("
					+ "code INT PRIMARY KEY, "
					+ "armorCode INT, "
					+ "weaponCode INT, "
					+ "foodCode INT, "
					//create connection between inventory and other items
					+ "FOREIGN KEY (code) REFERENCES Item(code) "
					+ "ON DELETE SET NULL ON UPDATE CASCADE, "
					+ "FOREIGN KEY (armorCode) REFERENCES Armor(code) "
					+ "ON DELETE SET NULL ON UPDATE CASCADE, "
					+ "FOREIGN KEY (weaponCode) REFERENCES Weapon(code) "
					+ "ON DELETE SET NULL ON UPDATE CASCADE, "
					+ "FOREIGN KEY (foodCode) REFERENCES Food(code) "
					+ "ON DELETE SET NULL ON UPDATE CASCADE "
					+ ");");
			//create table Sprite to save information of characters
			stmt.execute("CREATE TABLE Sprite ("
					+ "code INT PRIMARY KEY, "
					+ "name VARCHAR(20) NOT NULL,"
					+ "hp INT NOT NULL, "
					+ "MAX_HP INT NOT NULL, "
					+ "mp INT NOT NULL, "
					+ "MAX_MP INT NOT NULL, "
					+ "level INT NOT NULL,"
					+ "defence INT NOT NULL, "
					+ "strength INT NOT NULL, "
					+ "skillBase INT, "
					+ "inventoryCode INT, "
					+ "armorCode INT, "
					+ "weaponCode INT, "
					+ "gold INT, "
					//create connection between sprite and inventory
					+ "FOREIGN KEY (inventoryCode) REFERENCES Inventory(code) "
					+ "ON DELETE SET NULL ON UPDATE CASCADE"
					+ ");");
			//create table Map to save map information
			stmt.execute("CREATE TABLE Map ("
					+ "code INT PRIMARY KEY, "
					+ "tileWidth INT, "
					+ "tileHeight INT, "
					+ "cols INT"
					+ ");");
			//create table Skill to  save skill information
			stmt.execute("CREATE TABLE Skill ("
					+ "code INT PRIMARY KEY, "
					+ "name VARCHAR(20), "
					+ "description VARCHAR(100), "
					+ "damage DOUBLE"
					+ ");");
		}
	}