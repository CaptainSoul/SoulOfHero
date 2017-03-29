package map;

import inventory.Inventory;
import character.NPC;

public class Location {

	private String name;

	private String description;

	private Inventory inventory;

	private NPC npcs[];

	private int numNpcs;

	private Exit connections[];
	
	private final int codeLocation;
	
	private static int numLocations = 0;

	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		numNpcs = 0;
		npcs = new NPC[7];
		numLocations++;
		codeLocation = numLocations;
	}

	public String getName() {
		return name;
	}
	
	public int getCodeLocation() {
		return codeLocation;
	}
	
	public int getNumLocations() {
		return numLocations;
	}

	public String getDescription() {
		return description;
	}

	public void addNpc(NPC c) {
		if(numNpcs < npcs.length) {
			npcs[numNpcs] = c;
			numNpcs++;
		} else {
			throw new RuntimeException("There have been " + numNpcs + " npcs, cannot add a npc.");
		}
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

	public NPC getNpc(String name) {
		for(int i=0; i<npcs.length; i++) {
			if(npcs[i].getName().equals(name)) {
				return (NPC) npcs[i];
			}
		}
		return null;
	}

	public NPC[] getNpcs() {
		return (NPC[]) npcs;
	}

}
