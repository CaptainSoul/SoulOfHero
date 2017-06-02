package databaseDao;

import skill.SkillBase;

public interface SkillBaseDao {
	public void addSkillBase ( SkillBase skillBase);
	public SkillBase getSkillBase ( int code );
	public int update ( SkillBase skillBase);
	public int delete ( SkillBase skillBase);
}
