package archive;

import character.Player;

public class Archive {
	private String name;
	private Player player;
	private static int numArchives = 0;
	private final int code;
	
	public Archive(String name) {
		this.name = name;
		code = Code.getCode(this);
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumArchives() {
		return numArchives;
	}
	
	public int getCode() {
		return code;
	}
	
	public void save(Player player) {
		this.player = player;
	}
	
}
