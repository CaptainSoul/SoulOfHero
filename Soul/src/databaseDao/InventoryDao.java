package databaseDao;

import inventory.Inventory;

public interface InventoryDao {
	public void addInventory ( Inventory inventory);
	public Inventory getInventory ( int code );
	public int update ( Inventory inventory);
	public int delete ( Inventory inventory);
}
