package archive;

import character.Sprite;
import inventory.Item;
import map.Map;
import skill.Skill;

public class Code {
	private static final int scalar = 114;
	private static final int shift = 514;
	private static final int addedAbstractCharacter = 1000000;
	private static final int addedItem = 1010000;
	private static final int addedMap = 1020000;
	private static final int addedUser = 1040000;
	private static final int addedSkill = 1050000;
	private static final int addedArchive = 1060000;

	public static int getCode(Sprite character) {
		return character.getNumCharacters() * scalar + shift + addedAbstractCharacter;
	}
	
	public static int getCode(Item item) {
		return item.getNumItems() * scalar + shift + addedItem;
	}
	
	public static int getCode(Map map) {
		return map.getNumMaps() * scalar + shift + addedMap;
	}
	
	public static int getCode(User user) {
		return user.getNumUsers() * scalar + shift + addedUser;
	}
	
	public static int getCode(Skill skill) {
		return skill.getNumSkills() * scalar + shift + addedSkill;
	}
	
	public static int getCode(Archive archive) {
		return archive.getNumArchives() * scalar + shift + addedArchive;
	}
	
}
