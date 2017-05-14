package inventory;

import archive.Code;

public class Item {

	private String name;

	private String description;
	
	private static int numItems = 0;
	
	private final int code;

	public Item(String name, String description) {
		this.name =  name;
		this.description = description;
		numItems++;
		code = Code.getCode(this);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public int getCode() {
		return code;
	}
	
	public int getNumItems() {
		return numItems;
	}

	public boolean equals(Item item) {
		if( this.code == item.getCode() ) {
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

}
