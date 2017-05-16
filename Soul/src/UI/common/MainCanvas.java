package UI.common;

import character.Sprite;
import io.PropertyMenu;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import map.Map;

public class MainCanvas extends Canvas {
	private Map map;
	private GraphicsContext gContext;
	private Image imageMap;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	private boolean isRunning = true;
	private long sleep = 100;

	private PropertyMenu propertyMenu;
	private SpriteUI spriteUI;
	private Sprite sprite;
	
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
		imageMap = new Image(getClass().getResourceAsStream("map2.bmp"));
		gContext = getGraphicsContext2D();
		map = new Map(tileWidth, tileHeight, imageMap);
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
	
	public void draw() {
		map.drawMapMain(gContext);
		propertyMenu.draw(gContext);
	}
	
	public void update() {
		
	}
}
