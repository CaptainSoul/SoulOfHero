package skill;


import archive.Code;

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

	
	
	public int getCode() {
		return code;
	}
	
	public static int getNumSkills() {
		return numSkills;
	}
	
	public static void setNumSkills(int numSkills) {
		Skill.numSkills = numSkills;
	}
	
	// in database may change the number, so it need to be reset
	public static int reNumSkills() {
		return numSkills--;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getDamage() {
		return damage;
	}



	public void setDamage(double damage) {
		this.damage = damage;
	}



	public double attack( int strength ) {
		double skillDamage = damage * strength;
		return skillDamage;
	}

}

