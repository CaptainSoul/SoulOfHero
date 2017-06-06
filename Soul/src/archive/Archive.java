package archive;

import character.Sprite;

public class Archive {
	private String name;
	private User user;
	private Sprite sprite;
	private int taskProgress = 0;
	private static int numArchives = 0;
	private final int code;
	
	public Archive(String name) {
		this.name = name;
		code = Code.getCode(this);
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getName() {
		return name;
	}
	
	public static int getNumArchives() {
		return numArchives;
	}
	
	public static void setNumArchives(int numArchives) {
		Archive.numArchives = numArchives;
	}
	
	public int getCode() {
		return code;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public int getTaskProgress() {
		return taskProgress;
	}
	
	public void setTaskProgress(int taskProgress) {
		this.taskProgress = taskProgress;
	}
	
}
