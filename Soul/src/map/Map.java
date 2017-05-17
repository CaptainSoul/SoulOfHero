package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import archive.Code;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Map {
	private final int code;
	private static int numMaps = 0;
	private static final int MAP_WIDTH = 25;
	private static final int MAP_HEIGHT = 14;
	private int tileWidth;
	private int tileHeight;
	private int cols;
	private Image image;
	private int[][] mapIndex = new int[MAP_HEIGHT][MAP_WIDTH];
	
	public Map(int tileWidth, int tileHeight, Image image, int numExit) {
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.image = image;
		cols = (int) (image.getWidth() / tileWidth);
		code = Code.getCode(this);
	//	setPrimaryMap();
	}
	
	public Map(int tileWidth, int tileHeight, Image image, String url, int numExit) {
		this(tileWidth, tileHeight, image, 4);
		setMapIndex(url);
	//	setPrimaryMap();
	}
	
	public Map(int tileWidth, int tileHeight, Image image) {
		this(tileWidth, tileHeight, image, 4);
	//	setPrimaryMap();
	}
	
	public Map(int tileWidth, int tileHeight, Image image, String url) {
		this(tileWidth, tileHeight, image, url, 4);
	}
	
	public void drawMap(GraphicsContext gc) {
	/*	int mapWidth = mapIndex[0].length;
	*	int mapHeight = mapIndex.length;
	*	for(int y = 0; y < mapHeight; y++) {
	*		for(int x = 0; x < mapWidth; x++) {
	*			int px = mapIndex[y][x] % cols;
	*			int py = mapIndex[y][x] / cols;
	*			gc.drawImage(image, px * tileWidth, py * tileHeight, tileWidth, tileHeight, x * tileWidth, y
	*					* tileHeight, tileWidth, tileHeight);
	*		}
	*	}
	*	
	**/
		gc.drawImage(image, 0, 0, 800, 600);
		gc.drawImage(image, 50, 550, 32, 32);
	}
	
	public void drawMapMain(GraphicsContext gc) {
		for(int y = 0; y < MAP_HEIGHT; y++) {
			for(int x = 0; x < MAP_WIDTH; x++) {
			int px = mapIndex[y][x] % cols;
			int py = mapIndex[y][x] / cols;
			gc.drawImage(image, px * tileWidth, py * tileHeight, tileWidth, tileHeight, x * 2 * tileWidth, y
				* 2 * tileHeight, 2 * tileWidth, 2 * tileHeight);
			}
		}
	}
	
	public int[][] getMapIndex() {
		return mapIndex;
	}
	
	public void setMapIndex(int[][] mapIndex) {
		this.mapIndex = mapIndex;
	}
	
	public void setMapIndex(String url) {
		String[] map = new String[MAP_HEIGHT];
		try(BufferedReader br = new BufferedReader(new FileReader(url))) {
			for(int y = 0; y < MAP_HEIGHT; y++) {
				map[y] = br.readLine();
				for(int x = 0; x < MAP_WIDTH; x++) {
					mapIndex[y][x] = Integer.parseInt(map[y].substring(2*x, 2*x+1));
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getCode() {
		return code;
	}
	
	public int getNumMaps() {
		return numMaps;
	}
}
