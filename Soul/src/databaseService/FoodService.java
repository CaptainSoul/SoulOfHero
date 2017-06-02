package databaseService;

import databaseDao.DaoFactory;
import databaseDao.FoodDao;
import inventory.Food;

public class FoodService {
	private FoodDao foodDao;
	
	public FoodService(){
		foodDao = DaoFactory.getInstace().createFoodDao();
		System.out.println("foodDao: " + foodDao);
	}
	
	public void add(Food food) {
		if(food == null) {
			System.out.println("Invalid addition!!");
		} else {
			foodDao.addFood(food);
		}
	}
	
	public Food query(int code) {
		Food food = foodDao.getFood(code);
		if(food == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(food.toString());
		}
		return food;
	}
	
	public void update(Food food) {
		if(food.getCode() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			foodDao.update(food);
		}
	}
	
	public void delete(Food food) {
		if(food.getCode() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			foodDao.delete(food);
		}
	}
}
