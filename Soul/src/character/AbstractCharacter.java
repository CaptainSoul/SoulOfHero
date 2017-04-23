package character;

import inventory.Inventory;
import inventory.Weapon;

import java.util.Random;

import UI.fight.FightObject;
import archive.Code;
import inventory.Armor;
import skill.Skill;
import skill.SkillBase;
import inventory.Food;

public abstract class AbstractCharacter extends FightObject {
	private String name;
	private int hp;
	private int mp;
	private int strength;
	private int defence;
	private int exp = 0;
	private int level = 1;
	private int gold = 1;
	private Random random = new Random();

	private final int code;
	
	private int max_exp = 50;
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
//	private Location location;
	private SkillBase skillBase;

	public AbstractCharacter(String name) {
		this(name, 100, 100, 70, 15);
	}
	
	public AbstractCharacter(String name, int hp, int mp, int strength, int defence) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.strength = strength;
		this.defence = defence;
		inventory = new Inventory();
		weapon = new Weapon();
		armor = new Armor();
		skillBase = new SkillBase();
		code = Code.getCode(this);
		numCharacters++;
	}
	
	public void putExp(int exp) {
		this.exp += exp;
		if(this.exp >= max_exp) {
			levelUp();
			this.exp = 0;
		}
	}
	
	public int getExp() {
		return exp;
	}
	
	public void levelUp() {
		hp = MAX_HP;
		mp = MAX_MP;
		strength += random.nextInt(5);
		defence += random.nextInt(3);
		level++;
		max_exp += level * 50;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Armor getArmor() {
		return armor;
	}
	
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
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
	
	public int getAttack() {
		return strength + weapon.getStrength();
	}
	
	public int getDefence() {
		return defence + armor.getDefence();
	}
	
	public int getGold() {
		return gold;
	}
	
	public Skill getSkill(String skillName) {
		return skillBase.findSkill(skillName);
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
/*	public Location getLocation() {
		return location;
	} */

	public void attack(AbstractCharacter target) {
		// target_hp,defence, AC_strength
		int damage = strength - target.defence;
		if ( damage < MIN_DAMAGE ){
			damage = MIN_DAMAGE;
		}
		target.hp = target.hp - damage;
		//System.out.println("Character "+name+" attacks "+"Character "+target.name++" ! ");
		//System.out.println("Character "+target.name+" is taken "+damage+"damage! ");
		if ( target.hp < MIN_HP){
			target.hp = MIN_HP;
			//System.out.println("Character "+target.name+" has died! ");
		}
	}

	public void eat(Food food) {
		// AC_hp,mp food_hp,mp
		hp = hp + food.getHp();
		mp = mp + food.getMp();
		if (  hp > MAX_HP ){
			hp = MAX_HP;
		}
		if (  mp > MAX_MP ){
			mp = MAX_MP;
		}
		//System.out.println("Character "+name+" eats "+food.getName++" ! ");
	}

	public String toString() {
		String message = "Name:" + name;
		return message;
	}
	
	public int getMaxHp() {
		return MAX_HP;
	}
	
	public int getMaxMp() {
		return MAX_MP;
	}

	public abstract void takeTurn();
}
