package databaseDao;

import java.io.FileInputStream;
import java.util.Properties;

public class DaoFactory {
	private static InventoryDao inventoryDao = null;
	private static ItemDao itemDao = null;
	private static ArmorDao armorDao = null;
	private static WeaponDao weaponDao = null;
	private static FoodDao foodDao = null;
	private static SpriteDao spriteDao = null;
	private static SkillDao skillDao = null;
	private static SkillBaseDao skillBaseDao = null;
	private static UserDao userDao = null;
	private static DaoFactory instance = new DaoFactory();
	
	private DaoFactory() {
		Properties prop = new Properties();
		try{
			FileInputStream fis = new FileInputStream("src/databaseUtils/daoconfig.properties");
			prop.load(fis);
			
			String className = prop.getProperty("inventoryDaoClass");
			Class<?> clazz = Class.forName(className);
			inventoryDao = (InventoryDao) clazz.newInstance();
			
			className = prop.getProperty("itemDaoClass");
			clazz = Class.forName(className);
			itemDao = (ItemDao) clazz.newInstance();
			
			className = prop.getProperty("armorDaoClass");
			clazz = Class.forName(className);
			armorDao = (ArmorDao) clazz.newInstance();
			
			className = prop.getProperty("weaponDaoClass");
			clazz = Class.forName(className);
			weaponDao = (WeaponDao) clazz.newInstance();
			
			className = prop.getProperty("foodDaoClass");
			clazz = Class.forName(className);
			foodDao = (FoodDao) clazz.newInstance();
			
			className = prop.getProperty("spriteDaoClass");
			clazz = Class.forName(className);
			spriteDao = (SpriteDao) clazz.newInstance();
			
			className = prop.getProperty("skillDaoClass");
			clazz = Class.forName(className);
			skillDao = (SkillDao) clazz.newInstance();

			className = prop.getProperty("skillBaseDaoClass");
			clazz = Class.forName(className);
			skillBaseDao = (SkillBaseDao) clazz.newInstance();
			
			className = prop.getProperty("userDaoClass");
			clazz = Class.forName(className);
			userDao = (UserDao) clazz.newInstance();
			
			fis.close();
		} catch(Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DaoFactory getInstace() {
		return instance;
	}
	
	public InventoryDao  createInventoryDao() {
		return inventoryDao ;
	}
	
	public ItemDao  createItemDao() {
		return itemDao ;
	}
	
	public ArmorDao  createArmorDao() {
		return armorDao ;
	}
	
	public WeaponDao  createWeaponDao() {
		return weaponDao ;
	}
	
	public FoodDao  createFoodDao() {
		return foodDao ;
	}
	
	public SpriteDao  createSpriteDao() {
		return spriteDao ;
	}
	
	public SkillDao  createSkillDao() {
		return skillDao ;
	}
	
	public SkillBaseDao  createSkillBaseDao() {
		return skillBaseDao ;
	}
	
	public UserDao createUserDao() {
		return userDao;
	}
}

