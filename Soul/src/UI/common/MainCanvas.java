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
	private Map map;
	private GraphicsContext gContext;
	private Image imageMap;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	public boolean setProperty = false;
	
	private boolean isRunning = true;
	private long sleep = 100;

	private PropertyMenu propertyMenu;
	private SpriteUI spriteUI;
	private Sprite sprite;
	private String mapData1 = "./resource/data/map/map1.txt";
	private String mapData2 = "./resource/data/map/map3.txt";
	
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
		imageMap = new Image(getClass().getResourceAsStream("043-Cave01.png"));
		gContext = getGraphicsContext2D();
		layers = new SLinkedList<>();
		addLayer(mapData1);
		addLayer(mapData2);
		this.sprite = sprite;
		this.spriteUI = spriteUI;
		propertyMenu = new PropertyMenu(120, 215);
		propertyMenu.initPlayer(sprite);
		thread.start();
	}
	public void setPlayer(Sprite player) {
		this.sprite = player;
	}
	
	public void setPlayerUI(SpriteUI spriteUI) {
		this.spriteUI = spriteUI;
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
