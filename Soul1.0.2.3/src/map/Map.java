package map;

import archive.Code;
import dsa.impl.BSTMap;

public class Map {
	private final int code;
	
	private BSTMap<Integer, Location> locationBSTMap;

	private Exit exit[];
	
	private static int numMaps = 0;
	
	public Map() {
		this(4);
	}
	
	public Map(int numExit) {
		locationBSTMap = new BSTMap<Integer, Location>();
		exit = new Exit[numExit];
		code = Code.getCode(this);
	}
	
	public int getCode() {
		return code;
	}
	
	public int getNumMaps() {
		return numMaps;
	}

	public Location getLocation(int code) {
		return locationBSTMap.get(code);
	}
	
	public Exit[] getExits() {
		return exit;
	}
}
