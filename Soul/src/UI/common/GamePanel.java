package UI.common;

import UI.MainApp;
import character.Sprite;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GamePanel extends Parent {
    private SpriteUI spriteUI;
    private Sprite sprite = new Sprite("Hero");
    public static final int SPRITE_WIDTH = 32;
	public static final int SPRITE_HEIGHT = 48;
	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 900;
    
	public GamePanel() {
	}

	public void load(){
		MainCanvas canvas = new MainCanvas(SCENE_WIDTH, SCENE_HEIGHT, sprite, spriteUI);
		getChildren().add(canvas);
        spriteUI = new SpriteUI(600, 180, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar51.png");
        getChildren().add(spriteUI);
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
	}
	
	public void onMouseClicked(MouseEvent event) {
		System.out.println("X: " + event.getX());
		System.out.println("Y: " + event.getY());
	}
	
	public void onKeyPressed(KeyEvent event){
		if(event.getCode() == KeyCode.LEFT){
			spriteUI.moveLeft();
		}else if(event.getCode() == KeyCode.RIGHT){
			spriteUI.moveRight();
		}else if(event.getCode() == KeyCode.UP){
			spriteUI.moveUp();
		}else if(event.getCode() == KeyCode.DOWN){
			spriteUI.moveDown();
		}else if(event.getCode() == KeyCode.ENTER) {
			MainApp.fightView = true;
		}
		System.out.println("Sprite X: " + spriteUI.getX());
		System.out.println("Sprite Y: " + spriteUI.getY());
		if(spriteUI.getX() <= 50.0  && spriteUI.getY() >= 550.0) {
			MainApp.fightView = true;
			System.out.println("exchange");
		}
	}
	
	
	public void update(){
		if(spriteUI.getX() <= 50  && spriteUI.getY() >= 550) {
			MainApp.fightView = true;
			System.out.println("exchange");
		}
	}
	
	public static Stage MainStage() {
		Stage stage = new Stage();
		GamePanel gamePanel = new GamePanel();
		Scene scene = new Scene(gamePanel, SCENE_WIDTH, SCENE_HEIGHT);
		gamePanel.load();
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("SoulOfHero");
		return stage;
	}

}