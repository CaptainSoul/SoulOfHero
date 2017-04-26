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
	private enum Status {
		NONE, SHOW_MENU;
	}
	private Status nowStatus = Status.NONE;
	private Map map;
	private GraphicsContext gContext;
	private Image imageMap;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	private boolean isRunning = true;
	private long sleep = 100;

	private PropertyMenu propertyMenu;
	private SpriteUI sprite;
	private Sprite player;
	
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
	
	public MainCanvas(double width, double height) {
		super(width, height);
		imageMap = new Image(getClass().getResourceAsStream("map2.bmp"));
		gContext = getGraphicsContext2D();
		map = new Map(tileWidth, tileHeight, imageMap);
		propertyMenu = new PropertyMenu(120, 215);
//		propertyMenu.initPlayer(players.get(0));
		thread.start();
	}
	public void setPlayer(Sprite player) {
		this.player = player;
	}
	
	public void setPlayerUI(SpriteUI sprite) {
		this.sprite = sprite;
	}
	
	public static Stage mapStage() {
		Stage stage = new Stage();
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 800, 600);
		MainCanvas mainCanvas = new MainCanvas(800, 600);
		root.getChildren().add(mainCanvas);
		stage.setScene(scene);
		return stage;
	}
	
	public void draw() {
		map.drawMap(gContext);
	}
	
	public void update() {
		
	}
}
