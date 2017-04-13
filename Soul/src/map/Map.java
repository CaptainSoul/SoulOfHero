package map;

import archive.Code;
import dsa.impl.BSTMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Map {
	private final int code;
	private BSTMap<Integer, Location> locationBSTMap;
	private Exit exit[];
	private static int numMaps = 0;
	private int tileWidth;
	private int tileHeight;
	private int cols;
	private Image image;
	private int[][] mapIndex;
	
	public Map(int tileWidth, int tileHeight, Image image, int numExit) {
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.image = image;
		cols = (int) (image.getWidth() / tileWidth);
		locationBSTMap = new BSTMap<Integer, Location>();
		exit = new Exit[numExit];
		code = Code.getCode(this);
		setPrimaryMap();
	}
	
	public Map(int tileWidth, int tileHeight, Image image) {
		this(tileWidth, tileHeight, image, 4);
	}
	
	public void drawMap(GraphicsContext gc) {
		int mapWidth = mapIndex[0].length;
		int mapHeight = mapIndex.length;
		for(int y = 0; y < mapHeight; y++) {
			for(int x = 0; x < mapWidth; x++) {
				int px = mapIndex[y][x] % cols;
				int py = mapIndex[y][x] / cols;
				gc.drawImage(image, px * tileWidth, py * tileHeight, tileWidth, tileHeight, x * tileWidth, y
						* tileHeight, tileWidth, tileHeight);
			}
		}
	}
	
	public int[][] getMapIndex() {
		return mapIndex;
	}
	
	public void setMapIndex(int[][] mapIndex) {
		this.mapIndex = mapIndex;
	}
	
	public void setPrimaryMap() {
		mapIndex =new int[][] { 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
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
