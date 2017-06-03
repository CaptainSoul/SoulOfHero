package databaseService;

import databaseDao.DaoFactory;
import databaseDao.SkillBaseDao;
import skill.SkillBase;

public class SkillBaseService {
	private SkillBaseDao skillBaseDao;
	
	public SkillBaseService(){
		skillBaseDao = DaoFactory.getInstace().createSkillBaseDao();
		System.out.println("skillBaseDao: " + skillBaseDao);
	}
	
	public void add(SkillBase skillBase) {
		if(skillBase == null) {
			System.out.println("Invalid addition!!");
		} else {
			skillBaseDao.addSkillBase(skillBase);
		}
	}
	
	public SkillBase query(int code) {
		SkillBase skillBase = skillBaseDao.getSkillBase(code);
		if(skillBase == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(skillBase.toString());
		}
		return skillBase;
	}
	
	public void update(SkillBase skillBase) {
		if(skillBase.getCode() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			skillBaseDao.update(skillBase);
		}
	}
	
	public void delete(SkillBase skillBase) {
		if(skillBase.getCode() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			skillBaseDao.delete(skillBase);
		}
	}
}
