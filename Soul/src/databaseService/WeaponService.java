package databaseService;

import databaseDao.DaoFactory;
import databaseDao.WeaponDao;
import inventory.Weapon;

public class WeaponService {
	private WeaponDao weaponDao;
	
	public WeaponService(){
		weaponDao = DaoFactory.getInstace().createWeaponDao();
		System.out.println("weaponDao: " + weaponDao);
	}
	
	public void add(Weapon weapon) {
		if(weapon == null) {
			System.out.println("Invalid addition!!");
		} else {
			weaponDao.addWeapon(weapon);
		}
	}
	
	public Weapon query(int code) {
		Weapon weapon = weaponDao.getWeapon(code);
		if(weapon == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(weapon.toString());
		}
		return weapon;
	}
	
	public void update(Weapon weapon) {
		if(weapon.getCode() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			weaponDao.update(weapon);
		}
	}
	
	public void delete(Weapon weapon) {
		if(weapon.getCode() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			weaponDao.delete(weapon);
		}
	}
}
