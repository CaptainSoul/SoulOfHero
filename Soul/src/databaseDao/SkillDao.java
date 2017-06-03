package databaseDao;

import skill.Skill;

public interface SkillDao {
	public void addSkill ( Skill skill);
	public Skill getSkill ( int code );
	public int update ( Skill skill);
	public int delete ( Skill skill);
}
