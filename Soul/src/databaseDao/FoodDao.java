package databaseDao;

import inventory.Food;

public interface FoodDao {
	public void addFood ( Food food);
	public Food getFood ( int code );
	public int update ( Food food);
	public int delete ( Food food);
}
