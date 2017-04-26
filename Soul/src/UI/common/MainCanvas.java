package UI.common;

import java.util.ArrayList;
import java.util.List;

import character.Sprite;
import io.PropertyMenu;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import map.Map;

public class MainCanvas extends Canvas {
	private Map map;
	private GraphicsContext gContext;
	private Image imageMap;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	
	private List<Sprite> players = new ArrayList<>();
	private List<Sprite> enemys = new ArrayList<>();
	private boolean isRunning = true;
	private long sleep = 100;

	private PropertyMenu propertyMenu;
	
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
		imageMap = new Image(getClass().getResourceAsStream("map0.png"));
		gContext = getGraphicsContext2D();
		map = new Map(tileWidth, tileHeight, imageMap);
		propertyMenu = new PropertyMenu(120, 215);
//		propertyMenu.initPlayer(players.get(0));
		
		thread.start();
	}
	
	public static Stage mapStage() {
		Stage stage = new Stage();
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 640, 480);
		MainCanvas mainCanvas = new MainCanvas(640, 480);
		root.getChildren().add(mainCanvas);
		stage.setScene(scene);
		return stage;
	}
	
	public void draw() {
		map.drawMap(gContext);
		drawCharacter();
		propertyMenu.draw(gContext);
	}
	
	public void update() {
		
	}
	
	public void drawCharacter() {
		for(Sprite player: players) {
			player.draw(gContext);
		}
		for(Sprite enemy: enemys) {
			enemy.draw(gContext);
		}
	}
}
