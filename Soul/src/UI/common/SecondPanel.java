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

public class SecondPanel extends Parent {
    private SpriteUI spriteUI;
    private SpriteUI[] npcUI;
    private SecondCanvas canvas;
    
    public Archive[] archive;
    public Sprite sprite = new Sprite("Dec");

	private MenuBar menuBar;
	private boolean firCheck = true;
	public static boolean canComm = true;
    public static final int SPRITE_WIDTH = 32;
	public static final int SPRITE_HEIGHT = 48;
	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 896;
    
	public SecondPanel() {
	}

	public void loadFirst(){
		canvas = new SecondCanvas(SCENE_WIDTH, SCENE_HEIGHT, sprite, spriteUI);
		getChildren().add(canvas);
        spriteUI = new SpriteUI(1125, 259, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar51.png");
        npcUI = new SpriteUI[10];
        npcUI[0] = new SpriteUI(1024, 340, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar40.png");
        getChildren().add(spriteUI);
        getChildren().add(npcUI[0]);

        if(firCheck && canComm) {
        	canComm = false;
        	firCheck = false;
        	TaskController.setProgress(3);
        	TaskController.Check();
        }
        menuBar = new MenuBar(sprite);
        getScene().setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				onMouseClicked(event);
			}
        });
        getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
 			@Override
 			public void handle(KeyEvent event) {
 				onKeyPressed(event);
 			}
 		});
        if(firCheck && canComm) {
        	canComm = false;
        	firCheck = false;
        	TaskController.Check();
        }
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
		if(spriteUI.getY() >= 300) {
			TaskController.setFind(true);
		}
	}
	
	
	public void update(){

	}
	
	public static Stage MainStage() {
		Stage stage = new Stage();
		SecondPanel gamePanel = new SecondPanel();
		Scene scene = new Scene(gamePanel, SCENE_WIDTH, SCENE_HEIGHT);
		gamePanel.loadFirst();
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
