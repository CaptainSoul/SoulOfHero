package inventory;

public class Food extends Item {

	private int hp;

	private int mp;

	public Food(String name, String description, int hp, int mp) {
		super(name, description);
		this.hp = hp;
		this.mp = mp;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public boolean equals(Item item) {
		if(item instanceof Food) {
			Food food = (Food)item;
			if(super.equals(item) && hp == food.getHp() && mp == food.getMp()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String message = super.toString() + " and its hp, mp is " + hp + ", " + mp + " respectively";
		return message;
	}

}
