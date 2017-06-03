package databaseService;

import databaseDao.InventoryDao;
import inventory.Inventory;
import databaseDao.DaoFactory;;

public class InventoryService {
	private InventoryDao inventoryDao;
	
	public InventoryService(){
		inventoryDao = DaoFactory.getInstace().createInventoryDao();
		System.out.println("inventoryDao: " + inventoryDao);
	}
	
	public void add(Inventory inventory) {
		if(inventory == null) {
			System.out.println("Invalid addition!!");
		} else {
			inventoryDao.addInventory(inventory);
		}
	}
	
	public Inventory query(int code) {
		Inventory inventory = inventoryDao.getInventory(code);
		if(inventory == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(inventory.toString());
		}
		return inventory;
	}
	
	public void update(Inventory inventory) {
		if(inventory.getCode() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			inventoryDao.update(inventory);
		}
	}
	
	public void delete(Inventory inventory) {
		if(inventory.getCode() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			inventoryDao.delete(inventory);
		}
	}
}
