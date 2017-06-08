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
	private String mapData1 = "./resource/data/map/map1.txt";
	private String mapData2 = "./resource/data/map/map2.txt";
	private String mapData3 = "./resource/data/map/map3.txt";
	private String mapData4 = "./resource/data/map/map4.txt";
	private String mapData5 = "./resource/data/map/map5.txt";
	private String mapRes1 = "/pic/map/043-Cave01.png";
	private String mapRes2 = "/pic/map/014-PostTown02.png";
	
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
		imageMap = new Image(getClass().getResourceAsStream(mapRes1));
		gContext = getGraphicsContext2D();
		layers = new SLinkedList<>();
		addLayer(mapData1);
		addLayer(mapData3);
		propertyMenu = new PropertyMenu(120, 215);
		propertyMenu.initPlayer(sprite);
		thread.start();
	}
	
	public int getCode() {
		return canvasCode;
	}
	
	public void changeCanvasOne() {
		canvasCode = 1;
		imageMap = new Image(getClass().getResourceAsStream(mapRes1));
		layers = new SLinkedList<>();
		addLayer(mapData1);
		addLayer(mapData3);
	}
	
	public void changeCanvasTwo() {
		canvasCode = 2;
		imageMap = new Image(getClass().getResourceAsStream(mapRes2));
		layers = new SLinkedList<>();
		addLayer(mapData4);
		addLayer(mapData5);
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
