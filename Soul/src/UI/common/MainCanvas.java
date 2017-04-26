package UI.common;

import java.util.ArrayList;
import java.util.List;

import UI.fight.FightCanvas;
import character.Sprite;
import io.ActionMenu;
import io.PropertyMenu;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import map.Map;
import utils.InitCharacter;

public class MainCanvas extends Canvas {
	private Map map;
	private GraphicsContext gContext;
	private Image imageMap;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	
	private List<Sprite> players = new ArrayList<>();
	private List<Sprite> enemys = new ArrayList<>();
	private InitCharacter initCharacter = new InitCharacter();
	private boolean isRunning = true;
	private long sleep = 100;
	
	private ActionMenu actionMenu;
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
		initCharacter.initPlayers(players);
		initCharacter.initEnemy(enemys);
		
		actionMenu = new ActionMenu(new String[] {"move", "attack", "wait"}, 50, 100);
		actionMenu.setXY(120, 50);
		actionMenu.setOnMenuItemClickListener(index ->{
			System.out.println("you click: " + index);
		});
		
		propertyMenu = new PropertyMenu(120, 215);
		propertyMenu.initPlayer(players.get(0));
		
		setOnMousePressed(e ->{
			actionMenu.onMousePressed(e);
		});
		
		thread.start();
	}
	
	public static Stage mapStage() {
		Stage stage = new Stage();
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 640, 480);
		FightCanvas mapCanvas = new FightCanvas(640, 480);
		root.getChildren().add(mapCanvas);
		stage.setScene(scene);
		return stage;
	}
	
	public void draw() {
		map.drawMap(gContext);
		drawCharacter();
		actionMenu.draw(gContext);
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
