package databaseDao;

import inventory.Weapon;

public interface WeaponDao {
	public void addWeapon ( Weapon weapon);
	public Weapon getWeapon ( int code );
	public int update ( Weapon weapon);
	public int delete ( Weapon weapon);
}
