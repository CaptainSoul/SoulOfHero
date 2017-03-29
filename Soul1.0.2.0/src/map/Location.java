package map;

import inventory.Inventory;
import character.AbstractCharacter;
import character.NPC;

public class Location {

	private String name;

	private String description;

	private Inventory inventory;

	private AbstractCharacter characters[];

	private int numCharacters;

	private Exit connections[];

	public Location(String name, String description) {

	}

	public void addNpc(NPC c) {

	}

	public String getName() {
		return null;
	}

	public String getDescription() {
		return null;
	}

	public int getNumCharacters() {
		return 0;
	}

	public void addExit(Connection e) {

	}

	public Connection getExit(Direction d) {
		return null;
	}

	public Inventory getInventory() {
		return null;
	}

	public NPC getNpc(String name) {
		return null;
	}

	public NPC[] getNpcs() {
		return null;
	}

}
