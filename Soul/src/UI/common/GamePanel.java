package UI.common;

import UI.MainApp;
import archive.Archive;
import character.Sprite;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import scenarioG.TaskController;

public class GamePanel extends Parent {
    public static SpriteUI spriteUI;
    public static SpriteUI[] npcUI;
    public static MainCanvas canvas;
    
    public static int panelIndex = 0;
    
    public Archive[] archive;
    public Sprite sprite = new Sprite("Dec");

	private MenuBar menuBar;
	private static boolean firCheck = true;
	public static boolean canComm = true;
    public static final int SPRITE_WIDTH = 32;
	public static final int SPRITE_HEIGHT = 48;
	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 896;
	public static EventHandler<MouseEvent> ehm;
	public static EventHandler<KeyEvent> ehk;
    
	public GamePanel() {
	}

	public void load(){
		canvas = new MainCanvas(SCENE_WIDTH, SCENE_HEIGHT, sprite, spriteUI);
		canvas.loadLayerMain();
		getChildren().add(canvas);
        spriteUI = new SpriteUI(30, 270, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar51.png");
        npcUI = new SpriteUI[10];
        npcUI[0] = new SpriteUI(420, 395, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar8.png");
        getChildren().add(spriteUI);
        getChildren().add(npcUI[0]);
        init();
        canvas.start();
        panelIndex = 1;
	}
	
	public static void loadMain() {
        if(firCheck && canComm) {
        	canComm = false;
        	firCheck = false;
        	TaskController.Check();
        }
	}
	
	public static void loadRoom() {
        if(firCheck && canComm) {
        	canComm = false;
        	firCheck = false;
        	TaskController.Check();
        }
		canvas.loadLayerRoom();
		spriteUI.setX(1125);
		spriteUI.setY(259);
		npcUI[0].setIcon("xpchar40.png");
		npcUI[0].setX(1015);
		npcUI[0].setY(340);
		panelIndex = 2;
        TaskController.setProgress(4);
        TaskController.Check();
	}
	
	public static void loadHeaven() {
		canvas.loadLayerHeaven();
		panelIndex = 3;
	}
	
	public static void loadCave() {
		
	}
	
	public void init() {
        menuBar = new MenuBar(sprite);
        ehm = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				onMouseClicked(event);
			}
        };
        getScene().setOnMouseClicked(ehm);
        ehk = new EventHandler<KeyEvent>() {
 			@Override
 			public void handle(KeyEvent event) {
 				onKeyPressed(event);
 			}
 		};
        getScene().setOnKeyPressed(ehk);
	}
	
	public void clearEventHandler() {
		getScene().removeEventHandler(MouseEvent.MOUSE_CLICKED, ehm);
		getScene().removeEventHandler(KeyEvent.KEY_PRESSED, ehk);
	}
	
	public void onMouseClicked(MouseEvent event) {
		System.out.println("X: " + event.getX());
		System.out.println("Y: " + event.getY());
	}
	
	public void onKeyPressed(KeyEvent event){
		if(event.getCode() == KeyCode.LEFT){
			spriteUI.moveLeft(canvas.iterator());
		}else if(event.getCode() == KeyCode.RIGHT){
			spriteUI.moveRight(canvas.iterator());
		}else if(event.getCode() == KeyCode.UP){
			spriteUI.moveUp(canvas.iterator());
		}else if(event.getCode() == KeyCode.DOWN){
			spriteUI.moveDown(canvas.iterator());
		}else if(event.getCode() == KeyCode.ENTER) {
			MainApp.fightView = true;
		}else if(event.getCode() == KeyCode.O) {
			if(canvas.setProperty == false)
				canvas.setProperty = true;
			else
				canvas.setProperty = false;
		} else if(event.getCode() == KeyCode.SPACE && canComm) {
			canComm = false;
			TaskController.Check();
		} else if(event.getCode() == KeyCode.ESCAPE) {
			menuBar.updateSprite(sprite);
			menuBar.main();
		}
		if(panelIndex == 1) {
			if(TaskController.getFind() == false) {
				if(spriteUI.getX() >= 221 && spriteUI.getX() <= 290
					&& spriteUI.getY() >= 356) {
					canComm = false;
					TaskController.setFind(true);
					TaskController.Check();
				}
			}
			if(spriteUI.getY() <= 46) {
				clearEventHandler();
				MainApp.fightView = true;
			}
		} else if(panelIndex == 2) {
			if(spriteUI.getY() >= 339) {
				GamePanel.canComm = true;
				TaskController.setFind(true);
				TaskController.Check();
			}
		}
	}
	
	
	public void update(){

	}
	
	public static Stage MainStage() {
		Stage stage = new Stage();
		GamePanel gamePanel = new GamePanel();
		Scene scene = new Scene(gamePanel, SCENE_WIDTH, SCENE_HEIGHT);
		gamePanel.load();
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("SoulOfHero");
		stage.initStyle(StageStyle.DECORATED);
		stage.setWidth(SCENE_WIDTH);
		stage.setHeight(SCENE_HEIGHT);
		stage.setResizable(false);
		return stage;
	}

}