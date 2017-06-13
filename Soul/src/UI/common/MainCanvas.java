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
	
	private String mapResCave1 = "/pic/map/043-Cave01.png";
	private String mapResTown1 = "/pic/map/014-PostTown02.png";
	private String mapResHeaven1 = "/pic/map/032-Heaven01.png";
	private String mapResChurch = "/pic/map/029-Church02.png";
	private String mapResFort = "/pic/map/037-Fort01.png";
	private String mapResTown = "/pic/map/015-ForestTown01.png";
	
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
		imageMap = new Image(getClass().getResourceAsStream(mapResCave1));
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
		imageMap = new Image(getClass().getResourceAsStream(mapResCave1));
		addLayer(mapEmpty);
		addLayer(mapCave1);
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
	
	public void clearLayer() {
		if(layers == null)
			layers = new SLinkedList<>();
		else {
			while(layers.first() != null) {
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
		if(layers.first() == null)
			layers.insertLast(map);
		else
			layers.insertAfter(layers.last(), map);
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
		iterator.next().drawMapMain(gContext);
		while(iterator.hasNext()) {
			iterator.next().drawMapLayer(gContext);
		}
		if(setProperty)
			propertyMenu.draw(gContext);
	}
	
	public void update() {
		
	}
}
