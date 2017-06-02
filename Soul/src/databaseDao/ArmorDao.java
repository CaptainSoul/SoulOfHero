package databaseDao;

import inventory.Armor;

public interface ArmorDao {
	public void addArmor ( Armor armor);
	public Armor getArmor ( int code );
	public int update ( Armor armor);
	public int delete ( Armor armor);
}
