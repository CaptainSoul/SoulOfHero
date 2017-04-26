package UI.common;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GamePanel extends Parent {
    private SpriteUI sprite;
    public static final int SPRITE_WIDTH = 32;
	public static final int SPRITE_HEIGHT = 48;
    
	public GamePanel() {
	}

	public void load(){
		MainCanvas canvas = new MainCanvas(800, 600);
		getChildren().add(canvas);
        sprite = new SpriteUI(50, 50, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar51.png");
        getChildren().add(sprite);
        getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
 			@Override
 			public void handle(KeyEvent event) {
 				onKeyPressed(event);
 			}
 		});
	}
	
	public void onKeyPressed(KeyEvent event){
		if(event.getCode() == KeyCode.LEFT){
		  sprite.moveLeft();
	   }else if(event.getCode() == KeyCode.RIGHT){
		  sprite.moveRight();
	   }else if(event.getCode() == KeyCode.UP){
		  sprite.moveUp();
	   }else if(event.getCode() == KeyCode.DOWN){
		  sprite.moveDown();
	   }
	}
	
	
	public void update(long now){
		
	}
	
	public static Stage MainStage() {
		Stage stage = new Stage();
		GamePanel gamePanel = new GamePanel();
		Scene scene = new Scene(gamePanel, 640, 480);
		gamePanel.load();
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("SoulOfHero");
		return stage;
	}

}