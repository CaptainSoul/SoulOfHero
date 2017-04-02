package map;

import inventory.Inventory;
import character.NPC;
import dsa.impl.BSTMap;

public class Location {

	private String name;

	private String description;

	private Inventory inventory;

	private int numNpcs;

	private Exit connections[];
	
	private BSTMap<Integer, NPC> npcs;
	
	private final int code;
	
	private static int numLocations = 0;

	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		numNpcs = 0;
		numLocations++;
		code = numLocations; // need to be encoded
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
	/*	if(numNpcs < npcs.length) {
			npcs[numNpcs] = c;
			numNpcs++;
			npcMap
		} else {
			throw new RuntimeException("There have been " + numNpcs + " npcs, cannot add a npc.");
		}*/
	}
	
	public int getNumNpcs() {
		return numNpcs;
	}

	public void addConnection(Exit e) {
		connections[e.getDirection().index] = e;
	}

	public Exit getConnection(Direction d) {
		for(int i=0; i<connections.length; i++) {
			if(d.index == connections[i].getDirection().index) {
				return connections[i];
			}
		}
		return null;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public NPC getNpc(int code) {
		return npcs.get(code);
	}

}
