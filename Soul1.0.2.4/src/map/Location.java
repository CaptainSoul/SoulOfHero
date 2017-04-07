package map;

import inventory.Inventory;
import archive.Code;
import character.NPC;
import dsa.impl.BSTMap;

public class Location {

	private String name;

	private String description;

	private Inventory inventory;

	private Exit connections[];
	
	private BSTMap<Integer, NPC> npcs;
	
	private final int code;
	
	private static int numLocations = 0;

	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		numLocations++;
		code = Code.getCode(this);
		npcs = new BSTMap<Integer, NPC>();
	}

	public String getName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}
	
	public int getNumLocations() {
		return numLocations;
	}

	public String getDescription() {
		return description;
	}

	public void addNpc(NPC c) {
		if(npcs.get(c.getCode()) != null) {
			throw new RuntimeException("cannot add a same npc.");
		}
		npcs.put(c.getCode(), c);
	}
	
	public int getNumNpcs() {
		return npcs.size();
	}

	public void addConnection(Exit e) {
		connections[e.getDirection().getCode()] = e;
	}

	public Exit getConnection(Direction d) {
		return connections[d.getCode()];
	}

	public Inventory getInventory() {
		return inventory;
	}

	public NPC getNpc(int code) {
		return npcs.get(code);
	}

}
