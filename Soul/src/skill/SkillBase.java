package skill;

import dsa.iface.IIterator;
import dsa.impl.BSTMap;

public class SkillBase {

	private BSTMap<String, Skill> skills;

	public SkillBase(){
		 skills = new BSTMap<String, Skill>();
	}
	
	public int getNumSkill() {
		return skills.size();
	}
	
	public void addSkill(Skill skill) {
		skills.put(skill.getName(), skill);
	}

	public Skill findSkill(String name) {
		return skills.get(name);
	}

	public Skill removeSkill(String name) {
		return skills.remove(name);
	}

	public String toString() {
		IIterator<Skill> iterator = skills.values();
		String toReturn = "";
		while(iterator.hasNext()) {
			toReturn += iterator.next().toString();
		}
		return toReturn;
	}

}
