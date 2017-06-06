package inventory;

import archive.Code;
import dsa.iface.IIterator;
import dsa.iface.INode;
import dsa.impl.SLinkedList;

public class Inventory {

	private int maxItem;
	private SLinkedList<Item> items;
	private static int numInventories = 0;
	private final int code;

	public Inventory() {
		this(20);
	}
	
	public Inventory(int maxItem) {
		this.maxItem = maxItem;
		items = new SLinkedList<>();
		numInventories++;
		code = Code.getCode(this);
	}
	
	public int getCode(){
		return code;
	}

	public void addItem(Item item) {
		if(items.size() >= maxItem)
			throw new RuntimeException("cannot add item");
		if(items.first() == null)
			items.insertLast(item);
		else
			items.insertAfter(items.last(), item);
	}

	public Item findItem(int code) {
		IIterator<Item> iterator = items.iterator();
		Item item = iterator.next();
		while(iterator.hasNext() && code != item.getCode()) {
			item = iterator.next();
		}
		return item;
	}

	public Item removeItem(int code) {
		INode<Item> node = items.first();
		while(items.next(node) != null && node.element().getCode() != code) {
			node = items.next(node);
		}
		return items.remove(node);
	}

	public Weapon getWeapon(int code) {
		Item toReturn = findItem(code);
		if(toReturn instanceof Weapon)
			return (Weapon) toReturn;
		else
			return null;
	}

	public Food getFood(int code) {
		Item toReturn = findItem(code);
		if(toReturn instanceof Food)
			return (Food) toReturn;
		else
			return null;
	}

	public Armor getArmor(int code) {
		Item toReturn = findItem(code);
		if(toReturn instanceof Armor)
			return (Armor) toReturn;
		else
			return null;
	}
	
	public String toString() {
		IIterator<Item> iterator = items.iterator();
		String toReturn = "";
		while(iterator.hasNext()) {
			toReturn += iterator.next().toString();
		}
		return toReturn;
	}

	public void changeMaxItem(int max) {
		maxItem = max;
	}
	
	public static int getNumInventories() {
		return numInventories;
	}
	
	public static void setNumInventories(int numInventories) {
		Inventory.numInventories = numInventories;
	}
	
	public static void reNumInventories() {
		numInventories--;
	}

	public int getMaxItem() {
		return maxItem;
	}

	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}

	public SLinkedList<Item> getItems() {
		return items;
	}

	public void setItems(SLinkedList<Item> items) {
		this.items = items;
	}
	
}
