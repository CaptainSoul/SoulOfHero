package character;

import inventory.Inventory;
import inventory.Weapon;
import inventory.Armor;
import map.Location;
import skill.SkillBase;
import inventory.Food;

public abstract class AbstractCharacter {

	private String name;

	private int hp;

	private int mp;

	private int strength;

	private int defence;

	private static int numCharacters;

	private static final int MAX_HP = 100;

	private static final int MIN_HP = 0;

	private static final int MAX_MP = 100;

	private static final int MIN_MP = 0;

	private static final int MIN_DAMAGE = 0;

	private static final int MIN_HEAL = 0;

	private Inventory inventory;

	private Weapon weapon;

	private Armor armor;

	private Location location;

	private SkillBase skillBase;

	public AbstractCharacter(String name, int hp, int mp, int strength, int defence) {

	}

	public String getName() {
		return null;
	}

	public int getNumCharacters() {
		return 0;
	}

	public int getHp() {
		return 0;
	}

	public int getMp() {
		return 0;
	}

	public Inventory getInventory() {
		return null;
	}

	public Location getLocation() {
		return null;
	}

	public abstract void takeTurn();

	public String attack(AbstractCharacter target) {
		return null;
	}

	public String eat(Food food) {
		return null;
	}

	public String toString() {
		return null;
	}

}
