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
import utils.BGM;

public class GamePanel extends Parent {
    public static SpriteUI spriteUI;
    public static SpriteUI[] npcUI;
    public static MainCanvas canvas;
    
    public static int panelIndex = 0;
    
    public Archive[] archive;
    public static Sprite sprite = new Sprite("Dec");

	private MenuBar menuBar;
	private static boolean firCheck = true;
	public static boolean canComm = true;
	public static boolean canMove = true;
    public static final int SPRITE_WIDTH = 32;
	public static final int SPRITE_HEIGHT = 48;
	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 928;
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
        npcUI[1] = new SpriteUI(1600, 900, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar40.png");
        npcUI[2] = new SpriteUI(1600, 900, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar2.png");
        npcUI[3] = new SpriteUI(1600, 900, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar9.png");
        npcUI[4] = new SpriteUI(1600, 900, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar1.png");
        getChildren().add(spriteUI);
        getChildren().add(npcUI[0]);
        getChildren().add(npcUI[1]);
        getChildren().add(npcUI[2]);
        getChildren().add(npcUI[3]);
        getChildren().add(npcUI[4]);
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
		canvas.loadLayerRoom();
		spriteUI.setX(1125);
		spriteUI.setY(259);
		if(MainApp.firLoadRoom) {
	        TaskController.setProgress(4);
		}
		for(int i = 0; i < npcUI.length; i++) {
			if((i != 1) && npcUI[i] != null) {
				npcUI[i].setX(1600);
				npcUI[i].setY(900);
			}
		}
		npcUI[1].setX(1015);
		npcUI[1].setY(340);
		panelIndex = 2;
        canComm = true;
    	firCheck = true;
    	TaskController.setFind(false);
        TaskController.Check();
	}
	
	public static void loadHeaven() {
		canvas.loadLayerHeaven();
		if(MainApp.firLoadHeaven) {

		}
		for(int i = 0; i < npcUI.length; i++) {
			if((i != 2 || i != 3 || i != 4) && npcUI[i] != null) {
				npcUI[i].setX(1600);
				npcUI[i].setY(900);
			}
		}
		spriteUI.setX(735);
		spriteUI.setY(136);
		npcUI[2].setX(91);
		npcUI[2].setY(361);
		npcUI[3].setX(630);
		npcUI[3].setY(150);
		npcUI[4].setX(453);
		npcUI[4].setY(516);
		npcUI[4].moveUp(canvas.iterator());
		panelIndex = 3;
	}
	
	public static void loadCave() {
		canvas.loadLayerCave();
		spriteUI.setX(1353);
		spriteUI.setY(780);
		for(int i = 0; i < npcUI.length; i++) {
			if(npcUI[i] != null) {
				npcUI[i].setX(1600);
				npcUI[i].setY(900);
			}
		}
		panelIndex = 4;
		BGM.bgmNervous = true;
	}
	
	public static void loadChurch() {
		canvas.loadLayerChurch();
		spriteUI.setX(768);
		spriteUI.setY(733);
		for(int i = 0; i < npcUI.length; i++) {
			if((i != 1) && npcUI[i] != null) {
				npcUI[i].setX(1600);
				npcUI[i].setY(900);
			}
		}
		npcUI[1].setX(709);
		npcUI[1].setY(261);
		npcUI[1].moveRight(canvas.iterator());
		panelIndex = 5;
		BGM.bgmNervous2 = true;
	}
	
	public static void loadFort() {
		canvas.loadLayerFort();
		spriteUI.setX(500);
		spriteUI.setY(60);
		for(int i = 0; i < npcUI.length; i++) {
			if((i != 1) && npcUI[i] != null) {
				npcUI[i].setX(1600);
				npcUI[i].setY(900);
			}
		}
		panelIndex = 6;
		BGM.bgmStart = true;
	}
	
	public static void loadTown() {
		canvas.loadLayerTown();
		spriteUI.setX(31);
		spriteUI.setY(420);
		spriteUI.moveLeft(canvas.iterator());
		for(int i = 0; i < npcUI.length; i++) {
			if((i != 1) && npcUI[i] != null) {
				npcUI[i].setX(1600);
				npcUI[i].setY(900);
			}
		}
		panelIndex = 7;
		BGM.bgmStart = true;
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
		if(canMove) {
			if(event.getCode() == KeyCode.LEFT){
				spriteUI.moveLeft(canvas.iterator());
			}else if(event.getCode() == KeyCode.RIGHT){
				spriteUI.moveRight(canvas.iterator());
			}else if(event.getCode() == KeyCode.UP){
				spriteUI.moveUp(canvas.iterator());
			}else if(event.getCode() == KeyCode.DOWN){
				spriteUI.moveDown(canvas.iterator());
			}
		}
		if(event.getCode() == KeyCode.ENTER) {
			MainApp.fightView = true;
		}else if(event.getCode() == KeyCode.O) {
			if(canvas.setProperty == false)
				canvas.setProperty = true;
			else
				canvas.setProperty = false;
		} else if(event.getCode() == KeyCode.SPACE && canComm) {
			TaskController.Check();
		} else if(event.getCode() == KeyCode.ESCAPE) {
			menuBar.updateSprite(sprite);
			menuBar.main();
		}
		if(panelIndex == 1) {
			if(TaskController.getFind() == false && canComm) {
				if(spriteUI.getX() >= 221 && spriteUI.getX() <= 290
					&& spriteUI.getY() >= 356 && TaskController.getProgress() == 2) {
					canComm = false;
					TaskController.setFind(true);
					TaskController.Check();
					canComm = true;
				}
			}
			if(spriteUI.getX() <= 60 && TaskController.getProgress() == 1 && canComm) {
				canComm = false;
				TaskController.Check();
				canComm = true;
			}
			if(spriteUI.getY() <= 46) {
				clearEventHandler();
				MainApp.fightView = true;
				canComm = true;
			}
		} else if(panelIndex == 2) {
			if(spriteUI.getY() >= 339 && TaskController.getProgress() == 4 && canComm && firCheck) {
				canComm = false;
				TaskController.setFind(true);
				TaskController.Check();
			} else if(spriteUI.getX() >= 600 && spriteUI.getX() <= 632 
					&& spriteUI.getY() >= 680) {
				GamePanel.loadHeaven();
				TaskController.Check();
			}
		} else if(panelIndex == 3) {
			if(spriteUI.getX() >= 700 && spriteUI.getX() <= 760 
					&& spriteUI.getY() >= 130 && spriteUI.getY() <= 200
					&& TaskController.getProgress() == 6) {
				TaskController.Check();
			} else if(spriteUI.getX() >= 384 && spriteUI.getX() <= 547 
					&& spriteUI.getY() >= 472 && spriteUI.getY() <= 584
					&& TaskController.getProgress() == 7) {
				TaskController.Check();
			}	
			if(spriteUI.getX() >= 1435 && spriteUI.getX() <= 1472
					&& spriteUI.getY() <= 128) {
				canComm = false;
				GamePanel.loadCave();
				spriteUI.moveUp(canvas.iterator());
			} else if(spriteUI.getX() >= 456 && spriteUI.getX() <= 503 
					&& spriteUI.getY() <= 58) {
				loadChurch();
				spriteUI.moveUp(canvas.iterator());
			} else if(spriteUI.getX() >= 433 && spriteUI.getX() <= 491 
					&& spriteUI.getY() >= 750) {
				canComm = false;
				GamePanel.loadFort();
			}
		} else if(panelIndex == 4) {
			if(spriteUI.getY() >= 840) {
				canComm = false;
				GamePanel.loadHeaven();
				BGM.bgmChurch = true;
				spriteUI.setX(1415);
				spriteUI.setY(192);
			}
		} else if(panelIndex == 5) {
			if(spriteUI.getX() >= 640 && spriteUI.getX() <= 926 
					&& spriteUI.getY() >= 318 && spriteUI.getY() <= 414
					&& TaskController.getProgress() == 8) {
				TaskController.Check();
			}
			if(spriteUI.getY() >= 824) {
				canComm = false;
				GamePanel.loadHeaven();
				spriteUI.setX(450);
				spriteUI.setY(97);
			}
		} else if(panelIndex == 6) {
			if(spriteUI.getX() >= 414 && spriteUI.getX() <= 671 
					&& spriteUI.getY() <= 16) {
				canComm = false;
				loadHeaven();
				BGM.bgmChurch = true;
				spriteUI.setX(450);
				spriteUI.setY(700);
			} else if(spriteUI.getY() >= 275 && spriteUI.getY() <= 382 
					&& spriteUI.getX() >= 1540) {
				canComm = false;
				loadTown();
			}
		} else if(panelIndex == 7) {
			if(spriteUI.getY() >= 317 && spriteUI.getY() <= 604 
					&& spriteUI.getX() <= 7) {
				canComm = false;
				loadFort();
				spriteUI.setX(1500);
				spriteUI.setY(320);
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