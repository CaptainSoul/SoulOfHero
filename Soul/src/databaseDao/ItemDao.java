package databaseDao;

import inventory.Item;

public interface ItemDao {
	public void addItem ( Item item);
	public Item getItem ( int code );
	public int update ( Item item);
	public int delete ( Item item);
}
