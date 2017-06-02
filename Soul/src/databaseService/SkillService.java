package databaseService;

import databaseDao.DaoFactory;
import databaseDao.SkillDao;
import skill.Skill;

public class SkillService {
	private SkillDao skillDao;
	
	public SkillService(){
		skillDao = DaoFactory.getInstace().createSkillDao();
		System.out.println("skillDao" + skillDao);
	}
	
	public void add(Skill skill) {
		if(skill == null) {
			System.out.println("Invalid addition!!");
		} else {
			skillDao.addSkill(skill);
		}
	}
	
	public Skill query(int code) {
		Skill skill = skillDao.getSkill(code);
		if(skill == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(skill.toString());
		}
		return skill;
	}
	
	public void update(Skill skill) {
		if(skill.getCode() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			skillDao.update(skill);
		}
	}
	
	public void delete(Skill skill) {
		if(skill.getCode() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			skillDao.delete(skill);
		}
	}
}
