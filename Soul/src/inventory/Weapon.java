package inventory;

public class Weapon extends Item {

	private int strength;

	public Weapon() {
		this("sword", "a common sword", 19);
	}
	
	public Weapon(String name, String description, int strength) {
		super(name, description);
		this.strength = strength;
	}

	public int getStrength() {
		return strength;
	}

	public boolean equals(Item item) {
		if(item instanceof Weapon) {
			Weapon weapon = (Weapon)item;
			if(super.equals(item) && strength == weapon.getStrength()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String message = super.toString() + " and its strength is " + strength;
		return message;
	}

}
