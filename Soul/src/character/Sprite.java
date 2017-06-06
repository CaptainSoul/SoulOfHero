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

public class Sprite extends FightObject {
	public enum Group {
		PLAYER, COMMON, ENEMY;
	}
	private Group group;
	private String name;
	private int hp;
	private int mp;
	private int strength;
	private int defence;
	private int exp;
	private int level;
	private int gold;
	private int move;
	private Random random = new Random();

	private final int code;

	private int max_exp = 50;
	private static int numCharacters = 0;
	private int MAX_HP = 500;
	private int MIN_HP = 0;
	private int MAX_MP = 200;
//	private int MIN_MP = 0;
	private static final int MIN_DAMAGE = 0;
//	private static final int MIN_HEAL = 0;

	private Inventory inventory;
	private Weapon weapon;
	private Armor armor;
	private SkillBase skillBase;


	public Sprite(String name) {
		this(name, 500, 200, 70, 15);
	}
	
	public Sprite(String name, int hp, int mp, int strength, int defence) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.strength = strength;
		this.defence = defence;
		this.group = Group.COMMON;
		this.exp = 0;
		this.level = 1;
		this.gold = 1;
		this.move = 4;
		inventory = new Inventory();
		weapon = new Weapon();
		armor = new Armor();
		skillBase = new SkillBase();
		code = Code.getCode(this);
		numCharacters++;
	}
	
	public Sprite(String name, int code) {
		this.name = name;
		this.code = code;
	}
	
	public void putExp(int exp) {
		this.exp += exp;
		if(this.exp >= max_exp) {
			levelUp();
			this.exp = 0;
		}
	}
	
	public void levelUp() {
		hp = MAX_HP;
		mp = MAX_MP;
		strength += random.nextInt(40);
		defence += random.nextInt(10);
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
	
	public int getMove() {
		return move;
	}
	
	public void setMove(int move) {
		this.move = move;
	}
	
	public Skill getSkill(int skillCode) {
		return skillBase.findSkill(skillCode);
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getArmorCode() {
		return armor.getCode();
	}

	public int getWeaponCode() {
		return weapon.getCode();
	}

	public int getInventoryCode() {
		return inventory.getCode();
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup( Group group){
		this.group = group;
	}
	
	public int getCode() {
		return code;
	}
	
	public void attack(Sprite target) {
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
	
	public void setMaxHp(int maxHP) {
		this.MAX_HP = maxHP;
	}
	
	public int getMaxMp() {
		return MAX_MP;
	}
	
	public void setMaxMp(int maxMP) {
		this.MAX_MP = maxMP;
	}

	public static int getNumCharacters() {
		return numCharacters;
	}
	
	public static void setNumCharacters(int numCharacters) {
		Sprite.numCharacters = numCharacters;
	}

	// in database may change the number, so it need to be reset
	public static int reNumCharacters() {
		return numCharacters--;
	}
	
	public int getAttack() {
		return strength+weapon.getStrength();
	}

	
}
