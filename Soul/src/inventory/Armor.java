package inventory;

public class Armor extends Item {

	private int defence;

	public Armor() {
		this("cloth", "a common cloth", 5);
	}
	
	public Armor(String name, String description, int defence) {
		super(name, description);
		this.defence = defence;
	}

	public int getDefence() {
		return defence;
	}

	public boolean equals(Item item) {
		if(item instanceof Armor) {
			Armor armor = (Armor)item;
			if(super.equals(item) && defence == armor.getDefence()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String message = super.toString() + " and its defence is " + defence;
		return message;
	}

}
