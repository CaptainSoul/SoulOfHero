package databaseService;

import databaseDao.DaoFactory;
import databaseDao.ItemDao;
import inventory.Item;

public class ItemService {
	private ItemDao itemDao;
	
	public ItemService(){
		itemDao = DaoFactory.getInstace().createItemDao();
		System.out.println("itemDao: " + itemDao);
	}
	
	public void add(Item item) {
		if(item == null) {
			System.out.println("Invalid addition!!");
		} else {
			itemDao.addItem(item);
		}
	}
	
	public Item query(int code) {
		Item item = itemDao.getItem(code);
		if(item == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(item.toString());
		}
		return item;
	}
	
	public void update(Item item) {
		if(item.getCode() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			itemDao.update(item);
		}
	}
	
	public void delete(Item item) {
		if(item.getCode() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			itemDao.delete(item);
		}
	}
}
