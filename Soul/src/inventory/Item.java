package inventory;

import archive.Code;

public class Item {

	private String name;

	private String description;
	
	private static int numItems = 0;
	
	private final int code;

	private int inventoryCode;
	
	public Item(String name, String description) {
		this.name =  name;
		this.description = description;
		numItems++;
		code = Code.getCode(this);
		this.inventoryCode = 0;
	}


	public int getCode() {
		return code;
	}
	
	public static int getNumItems() {
		return numItems;
	}

	public boolean equals(Item item) {
		if(name.equals(item.getName()) && description.equals(item.getDescription())) {
			return true;
		}
		return false;
	}

	public String toString() {
		char first = name.charAt(0);
		String message;
		if(first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') {
			message = "an ";
		} else {
			message = "a ";
		}
		message += name + ". " + description;
		return message;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public static void setNumItems(int numItems) {
		Item.numItems = numItems;
	}

	public static void reNumItems(){
		Item.numItems--;
	}


	public int getInventoryCode() {
		return inventoryCode;
	}


	public void setInventoryCode(int inventoryCode) {
		this.inventoryCode = inventoryCode;
	}


}
