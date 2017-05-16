package skill;

import dsa.iface.IIterator;
import dsa.iface.INode;
import dsa.impl.SLinkedList;

public class SkillBase {

	private SLinkedList<Skill> skills;

	public SkillBase(){
		 skills = new SLinkedList<>();
	}
	
	public int getNumSkill() {
		return skills.size();
	}
	
	public void addSkill(Skill skill) {
		if(skills.first() == null)
			skills.insertLast(skill);
		else
			skills.insertAfter(skills.last(), skill);
	}

	public Skill findSkill(int code) {
		IIterator<Skill> iterator = skills.iterator();
		Skill skill = iterator.next();
		while(iterator.hasNext() && code != skill.getCode()) {
			skill = iterator.next();
		}
		return skill;
	}

	public Skill removeSkill(String name) {
		INode<Skill> node = skills.first();
		while(skills.next(node) != null) {
			node = skills.next(node);
		}
		return skills.remove(node);
	}

	public String toString() {
		IIterator<Skill> iterator = skills.iterator();
		String toReturn = "";
		while(iterator.hasNext()) {
			toReturn += iterator.next().toString();
		}
		return toReturn;
	}

}
