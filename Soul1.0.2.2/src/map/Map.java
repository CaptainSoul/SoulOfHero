package map;

import dsa.impl.BSTMap;

public class Map {
	private final int code;
	
	private BSTMap<Integer, Location> locationBSTMap;

	private Exit exit[];
	
	private static int numMaps;
	
	public Map() {
		
	}
	
	public int getCode() {
		return code;
	}

	public Location getLocation(int code) {
		return locationBSTMap.get(code);
	}
	
	public Exit[] getExits() {
		return exit;
	}
}
