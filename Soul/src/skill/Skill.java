package skill;

import archive.Code;
import character.Sprite;

public class Skill {

	private String name;

	private String description;
	
	private static int numSkills = 0;
	
	private final int code;

	private double damage;

	public Skill(String n, String de, double da) {
		name = n;
		description = de;
		damage = da;
		numSkills++;
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
	
	public int getNumSkills() {
		return numSkills;
	}

	public double attack( int strength ) {
		double skillDamage = damage * strength;
		return skillDamage;
	}

}
