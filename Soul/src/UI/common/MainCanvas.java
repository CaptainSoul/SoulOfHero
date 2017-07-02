package UI.common;

import character.Sprite;
import dsa.iface.IIterator;
import dsa.iface.INode;
import dsa.impl.SLinkedList;
import io.PropertyMenu;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import map.Map;

public class MainCanvas extends Canvas {
	private SLinkedList<Map> layers;
	private GraphicsContext gContext;
	private Image imageMap;
	private int canvasCode = 0;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	public boolean setProperty = false;
	
	private boolean isRunning = true;
	private long sleep = 100;

	private PropertyMenu propertyMenu;
	private String mapEmpty = "./resource/data/map/mapEmpty.txt";
	private String mapMain = "./resource/data/map/mapMain.txt";
	private String mapRoom1 = "./resource/data/map/mapRoom1.txt";
	private String mapHeaven1 = "./resource/data/map/mapHeaven1.txt";
	private String mapHeaven2 = "./resource/data/map/mapHeaven2.txt";
	private String mapCave1 = "./resource/data/map/mapCave1.txt";
	private String mapChurch = "./resource/data/map/mapChurch.txt";
	private String mapFort1 = "./resource/data/map/mapFort.txt";
	private String mapTown1 = "./resource/data/map/mapTown.txt";
	private String mapBeach1 = "./resource/data/map/mapBeach1.txt";
	private String mapBeach2 = "./resource/data/map/mapBeach2.txt";
	private String mapGardon1 = "./resource/data/map/mapGardon1.txt";
	private String mapGardon2 = "./resource/data/map/mapGardon2.txt";
	private String mapMaze1 = "./resource/data/map/mapMaze1.txt";
	private String mapMaze2 = "./resource/data/map/mapMaze2.txt";
	private String mapMaze3 = "./resource/data/map/mapMaze3.txt";
	private String mapMaze4 = "./resource/data/map/mapMaze4.txt";
	private String mapElement1 = "./resource/data/map/mapElement1.txt";
	private String mapElement2 = "./resource/data/map/mapElement2.txt";
	private String mapEarth1 = "./resource/data/map/mapEarth1.txt";
	private String mapEarth2 = "./resource/data/map/mapEarth2.txt";
	private String mapFire1 = "./resource/data/map/mapFire1.txt";
	private String mapFire2 = "./resource/data/map/mapFire2.txt";
	private String mapWater1 = "./resource/data/map/mapWater1.txt";
	private String mapWater2 = "./resource/data/map/mapWater2.txt";
	private String mapWind1 = "./resource/data/map/mapWind1.txt";
	private String mapWind2 = "./resource/data/map/mapWind2.txt";
	private String mapBoss1 = "./resource/data/map/mapBoss1.txt";
	private String mapBoss2 = "./resource/data/map/mapBoss2.txt";
	
	private String mapResCave = "/pic/map/043-Cave01.png";
	private String mapResTown1 = "/pic/map/014-PostTown02.png";
	private String mapResHeaven1 = "/pic/map/032-Heaven01.png";
	private String mapResChurch = "/pic/map/029-Church02.png";
	private String mapResClass = "/pic/map/Class.jpg";
	private String mapResFort = "/pic/map/037-Fort01.png";
	private String mapResTown = "/pic/map/015-ForestTown01.png";
	private String mapResGardon = "/pic/map/Gardon.png";
	private String mapResMaze = "/pic/map/Maze.png";
	private String mapResWind = "/pic/map/046-Cave04.png";
	private String mapResWater = "/pic/map/045-Cave03.png";
	private String mapResFire = "/pic/map/044-Cave02.png";
	private String mapResEvilCastle = "/pic/map/042-EvilCastle02.png";
	private String mapResBoss = "/pic/map/Boss.png";
	private String mapResOver = "/pic/common/GameOver.jpg";
	private String mapResEnd = "/pic/common/End.jpg";
	
	
	
	private Thread thread = new Thread(new Runnable() {

		@Override
		public void run() {
			while(isRunning) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						draw();
						update();
						
					}
				});
				try {
					Thread.sleep(sleep);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	});
	
	public MainCanvas(double width, double height, Sprite sprite, SpriteUI spriteUI) {
		super(width, height);
		gContext = getGraphicsContext2D();
		propertyMenu = new PropertyMenu(120, 215);
		propertyMenu.initPlayer(sprite);
	}
	
	public void loadLayerMain() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResCave));
		addLayer(mapEmpty);
		addLayer(mapMain);
	}
	
	public void loadLayerRoom() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResTown1));
		addLayer(mapEmpty);
		addLayer(mapRoom1);
	}
	
	public void loadLayerHeaven() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResHeaven1));
		addLayer(mapHeaven1);
		addLayer(mapHeaven2);
	}
	
	public void loadLayerCave() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResCave));
		addLayer(mapEmpty);
		addLayer(mapCave1);
	}
	
	public void loadLayerClass() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResClass));
		Map map = new Map(tileWidth, tileHeight, imageMap);
		Map map2 = new Map(tileWidth, tileHeight, imageMap);
		map.setPic(true);
		map2.setPic(true);
		addLayer(map);
		addLayer(map2);
	}
	
	public void loadLayerChurch() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResChurch));
		addLayer(mapEmpty);
		addLayer(mapChurch);
	}
	
	public void loadLayerFort() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResFort));
		addLayer(mapEmpty);
		addLayer(mapFort1);
	}
	
	public void loadLayerTown() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResTown));
		addLayer(mapEmpty);
		addLayer(mapTown1);
	}
	
	public void loadLayerBeach() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResGardon));
		addLayer(mapBeach1);
		addLayer(mapBeach2);
	}
	
	public void loadLayerGardon() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResGardon));
		addLayer(mapGardon1);
		addLayer(mapGardon2);
	}
	
	public void loadLayerMazeFirst() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResMaze));
		addLayer(mapMaze1);
		addLayer(mapMaze2);
	}
	
	public void loadLayerMazeSecond() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResMaze));
		addLayer(mapMaze1);
		addLayer(mapMaze3);
	}
	
	public void loadLayerMazeThird() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResMaze));
		addLayer(mapMaze1);
		addLayer(mapMaze4);
	}
	
	public void loadLayerElement() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResEvilCastle));
		addLayer(mapElement1);
		addLayer(mapElement2);
	}
	
	public void loadLayerEarth() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResCave));
		addLayer(mapEarth1);
		addLayer(mapEarth2);
	}
	
	public void loadLayerFire() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResFire));
		addLayer(mapFire1);
		addLayer(mapFire2);
	}
	
	public void loadLayerWater() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResWater));
		addLayer(mapWater1);
		addLayer(mapWater2);
	}
	
	public void loadLayerWind() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResWind));
		addLayer(mapWind1);
		addLayer(mapWind2);
	}
	
	public void loadLayerBoss() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResBoss));
		addLayer(mapBoss1);
		addLayer(mapBoss2);
	}
	
	public void loadLayerOver() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResOver));
		Map map = new Map(tileWidth, tileHeight, imageMap);
		Map map2 = new Map(tileWidth, tileHeight, imageMap);
		map.setPic(true);
		map2.setPic(true);
		addLayer(map);
		addLayer(map2);
	}
	
	public void loadLayerEnd() {
		clearLayer();
		imageMap = new Image(getClass().getResourceAsStream(mapResEnd));
		Map map = new Map(tileWidth, tileHeight, imageMap);
		Map map2 = new Map(tileWidth, tileHeight, imageMap);
		map.setPic(true);
		map2.setPic(true);
		addLayer(map);
		addLayer(map2);
	}
	
	public void clearLayer() {
		if(layers == null)
			layers = new SLinkedList<>();
		else {
			while(layers.size() != 0) {
				layers.remove(layers.first());
			}
		}
	}
	
	public void start() {
		thread.start();
	}
	
	public int getCode() {
		return canvasCode;
	}
	
	public int getNumLayers() {
		return layers.size();
	}
	
	public void addLayer(Map map) {
		layers.insertLast(map);
	}
	
	public void addLayer(String mapData) {
		Map map = new Map(tileWidth, tileHeight, imageMap, mapData);
		addLayer(map);
	}
	
	public Map findMap(int mapCode) {
		IIterator<Map> iterator = layers.iterator();
		Map map = iterator.next();
		while(iterator.hasNext() && map.getCode() != mapCode) {
			map = iterator.next();
		}
		return map;
	}
	
	public Map removeMap(int mapCode) {
		INode<Map> node = layers.first();
		INode<Map> n = layers.next(node);
		while(n != null && node.element().getCode() != mapCode) {
			node = n;
			n = layers.next(node);
		}
		return layers.remove(node);
	}
	
	public IIterator<Map> iterator() {
		return layers.iterator();
	}
	
	public void draw() {
		IIterator<Map> iterator = iterator();
		Map map = iterator.next();
		if(map.isPic()) {
			map.drawMap(gContext);
		} else {
			map.drawMapMain(gContext);
			while(iterator.hasNext()) {
				iterator.next().drawMapLayer(gContext);
			}
			if(setProperty)
				propertyMenu.draw(gContext);
		}
	}
	
	public void update() {
		
	}
}
