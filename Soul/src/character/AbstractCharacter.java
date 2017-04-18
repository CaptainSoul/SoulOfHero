package character;

import inventory.Inventory;
import inventory.Weapon;
import archive.Code;
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
	private int level = 1;
	private int gold = 1;
	private final int code;
	private static int numCharacters = 0;
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

	public AbstractCharacter(String n, int h, int m, int s, int d) {
		name = n;
		hp = h;
		mp = m;
		strength = s;
		defence = d;
		code = Code.getCode(this);
		numCharacters++;
	}

	public String getName() {
		return name;
	}

	public int getNumCharacters() {
		return numCharacters;
	}
	
	public int getCode() {
		return code;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Location getLocation() {
		return location;
	}

	public abstract void takeTurn();

	public void attack(AbstractCharacter target) {
		// target_hp,defence, AC_strength
		int damage = strength - target.defence;
		if ( damage < 0 ){
			damage = 0;
		}
		target.hp = target.hp - damage;
		//System.out.println("Character "+name+" attacks "+"Character "+target.name++" ! ");
		//System.out.println("Character "+target.name+" is taken "+damage+"damage! ");
		if ( target.hp < 0){
			target.hp = 0;
			//System.out.println("Character "+target.name+" has died! ");
		}
		
	}

	public void eat(Food food) {
		// AC_hp,mp food_hp,mp
		hp = hp + food.getHp();
		mp = mp + food.getMp();
		if (  hp > 100 ){
			hp = 100;
		}
		if (  mp > 100 ){
			mp = 100;
		}
		//System.out.println("Character "+name+" eats "+food.getName++" ! ");
	}

	public String toString() {
		String message = name + ":" + name;
		return message;
	}


}
