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
	public static final int WIDTH = 50;
	public static final int HEIGHT = 28;
	public static int tileWidth;
	public static int tileHeight;
	private int cols;
	private Image image;
	private int[][] mapIndex = new int[HEIGHT][WIDTH];
	
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
		gc.drawImage(image, 0, 0, 800, 600);
		gc.drawImage(image, 50, 550, 32, 32);
	}
	
	public void drawMapMain(GraphicsContext gc) {
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				int px = mapIndex[y][x] % cols;
				int py = mapIndex[y][x] / cols;
				gc.drawImage(image, px * tileWidth, py * tileHeight, tileWidth, tileHeight, x * tileWidth, y
						 * tileHeight, tileWidth, tileHeight);
			}
		}
	}
	
	public void drawMapLayer(GraphicsContext gc) {
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				if(mapIndex[y][x] != 0) {
					int px = mapIndex[y][x] % cols;
					int py = mapIndex[y][x] / cols;
					gc.drawImage(image, px * tileWidth, py * tileHeight, tileWidth, tileHeight, x * tileWidth, y
							* tileHeight, tileWidth, tileHeight);
				}
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
		String[] map = new String[HEIGHT];
		try(BufferedReader br = new BufferedReader(new FileReader(url))) {
			int locEnd;
			int locStart = 0;
			for(int y = 0; y < HEIGHT; y++) {
				map[y] = br.readLine();
				locStart = 0;
				for(int x = 0; x < WIDTH; x++) {
					locEnd = map[y].indexOf(" ", locStart);
					System.out.println("locStart:" + locStart);
					mapIndex[y][x] = Integer.parseInt(map[y].substring(locStart, locEnd));
					locStart = locEnd + 1;
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
