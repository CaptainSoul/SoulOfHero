package character;

import inventory.Inventory;
import inventory.Weapon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

import UI.BaseObject;
import archive.Code;
import inventory.Armor;
import map.Location;
import map.MapCanvas;
import skill.SkillBase;
import inventory.Food;

public abstract class AbstractCharacter extends BaseObject {
	private String name;
	private int hp;
	private int mp;
	private int strength;
	private int defence;
	private int exp = 0;
	private int level = 1;
	private int gold = 1;
	private Random random = new Random();
	private Image image;
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
	
	private boolean isChoose = false;
	private boolean isWaitToAttack = false;
	private boolean isWaitToMove = false;
	private boolean isCanAction = true;
	private boolean isCanMove = true;
	private boolean isCanAttack = true;
	
	private int flashCount = 10;
	private int startCount = 10;
	private boolean isFlash = false;

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
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		setWidth(MapCanvas.tileWidth);
		setHeight(MapCanvas.tileHeight);
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
	
	public void draw(GraphicsContext gc) {
		gc.save();
		if(image != null) {
			if(isCanAction) {
				if(isFlash) {
					if(startCount < flashCount) {
						gc.setGlobalAlpha(0.3f);
						gc.setFill(Color.RED);
						gc.fillRect(getX(), getY(), width, height);
					} else {
						startCount = 0;
						isFlash = false;
					}
				}
				gc.setGlobalAlpha(1.0f);
				gc.drawImage(image, x, y, width, height);
			} else {
				gc.setGlobalAlpha(0.5f);
				gc.drawImage(image, x, y, width, height);
			}
			gc.setGlobalAlpha(1.5f);
			if(isChoose) {
				gc.strokeRect(x, y, 32, 32);
			}
		}
		gc.restore();
	}
	
	public void flash() {
		isFlash = true;
		startCount = 0;
	}
	
	public boolean isHasNearBP(List<AbstractCharacter> players) {
		int mx = (int) (getX() / width);
		int my = (int) (getY() / height);
		for (AbstractCharacter bp : players) {
			int x = (int) (bp.getX() / width);
			int y = (int) (bp.getY() / height);
			if ((x == mx && y == my + 1) || (x == mx - 1 && y == my) || (x == mx + 1 && y == my)
					|| (x == mx && y == my - 1)) {
				return true;
			}
		}
		return false;
	}
	
	public AbstractCharacter getNearestBP(List<AbstractCharacter> players) {
		AbstractCharacter basePlayer = players.get(0);
		for (int i = 0; i < players.size(); i++) {
			AbstractCharacter player = players.get(i);
			if (Math.abs(getX() - basePlayer.getX()) + Math.abs(getY() - basePlayer.getY()) > Math.abs(getX()
					- player.getX())
					+ Math.abs(getY() - player.getY())) {
				basePlayer = player;
			}
		}
		return basePlayer;
	}
	
	@Override
	public void update() {
		
	}
	
	public void reset() {
		isChoose = false;
		isWaitToAttack = false;
		isWaitToMove = false;
		isCanAction = true;
		isCanMove = true;
		isCanAttack = true;
	}
	
	public boolean isCollisionWith(double x, double y) {
		if (x > getX() && y > getY() && x < getX() + getWidth() && y < getY() + getHeight()) {
			return true;
		}
		return false;
	}
	
	public boolean isChoose() {
		return isChoose;
	}

	public void setChoose(boolean isChoose) {
		this.isChoose = isChoose;
	}
	
	public boolean isWaitToAttack() {
		return isWaitToAttack;
	}

	public void setWaitToAttack(boolean isWaitToAttack) {
		this.isWaitToAttack = isWaitToAttack;
	}

	public boolean isWaitToMove() {
		return isWaitToMove;
	}

	public void setWaitToMove(boolean isWaitToMove) {
		this.isWaitToMove = isWaitToMove;
	}
	
	public boolean isCanAction() {
		return isCanAction;
	}

	public void setCanAction(boolean isCanAction) {
		this.isCanAction = isCanAction;
	}

	public boolean isCanMove() {
		return isCanMove;
	}

	public void setCanMove(boolean isCanMove) {
		this.isCanMove = isCanMove;
	}

	public boolean isCanAttack() {
		return isCanAttack;
	}

	public void setCanAttack(boolean isCanAttack) {
		this.isCanAttack = isCanAttack;
	}

	public boolean isFlash() {
		return isFlash;
	}

	public void setFlash(boolean isFlash) {
		this.isFlash = isFlash;
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
