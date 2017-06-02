package databaseService;

import databaseDao.ArmorDao;
import databaseDao.DaoFactory;
import inventory.Armor;

public class ArmorService {
	private ArmorDao armorDao;
	
	public ArmorService(){
		armorDao = DaoFactory.getInstace().createArmorDao();
		System.out.println("armorDao: " + armorDao);
	}
	
	public void add(Armor armor) {
		if(armor == null) {
			System.out.println("Invalid addition!!");
		} else {
			armorDao.addArmor(armor);
		}
	}
	
	public Armor query(int code) {
		Armor armor = armorDao.getArmor(code);
		if(armor == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(armor.toString());
		}
		return armor;
	}
	
	public void update(Armor armor) {
		if(armor.getCode() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			armorDao.update(armor);
		}
	}
	
	public void delete(Armor armor) {
		if(armor.getCode() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			armorDao.delete(armor);
		}
	}
}
