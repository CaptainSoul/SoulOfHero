package inventory;

import dsa.impl.BSTMap;

public class Inventory {

	private int numItems;

	private int maxItem;

	private BSTMap<Integer, Item> items;

	public Inventory(int maxItem) {
		this.maxItem = maxItem;
		items = new BSTMap<Integer, Item>();
	}

	public void addItem(Item Item) {
		
	}

	public Item findItem(int code) {
		return null;
	}

	public Item removeItem(int code) {
		return null;
	}

	public Weapon getWeapon(int code) {
		return null;
	}

	public Food getFood(int code) {
		return null;
	}

	public Armor getArmor(int name) {
		return null;
	}

	public String toString() {
		return null;
	}

	public void changeMaxItem(int max) {

	}

}
