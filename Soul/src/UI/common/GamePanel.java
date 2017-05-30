package UI.common;

import UI.MainApp;
import UI.scenario.Dialog;
import character.Sprite;
import dsa.iface.IIterator;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import map.Map;

public class GamePanel extends Parent {
	private Dialog dialog;
    private SpriteUI spriteUI;
    private Sprite sprite = new Sprite("Hero");
    private SpriteUI[] npcUI;
    private MainCanvas canvas;
    private int numNpc;
    private boolean canMoveUp = true;
    private boolean canMoveDown = true;
    private boolean canMoveLeft = true;
    private boolean canMoveRight = true;
    private IIterator<Map> layersIterator;
    public static final int SPRITE_WIDTH = 32;
	public static final int SPRITE_HEIGHT = 48;
	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 896;
    
	public GamePanel() {
	}

	public void loadFirst(){
		canvas = new MainCanvas(SCENE_WIDTH, SCENE_HEIGHT, sprite, spriteUI);
		getChildren().add(canvas);
        spriteUI = new SpriteUI(814, 392, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar51.png");
        npcUI = new SpriteUI[10];
        npcUI[0] = new SpriteUI(525, 450, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar8.png");
        numNpc = 1;
        getChildren().add(spriteUI);
        getChildren().add(npcUI[0]);
        layersIterator = canvas.iterator();
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
		if(event.getCode() == KeyCode.SPACE) {
			dialog = new Dialog();
			dialog.setVisible(true);
			dialog.setAlwaysOnTop(true);
			dialog.setAutoRequestFocus(true);
		}
		for(int i = 0; i < numNpc; i++) {
			if(spriteUI.getX() + spriteUI.getWidth() > npcUI[i].getX() && spriteUI.getX() < npcUI[i].getX() + npcUI[i].getWidth()
			&& spriteUI.getY() > npcUI[i].getY() + npcUI[i].getHeight() && spriteUI.getY() < npcUI[i].getY() + 2*npcUI[i].getHeight()) {
				System.out.println("move");
				canMoveUp = false;
			}
		}
		if(event.getCode() == KeyCode.LEFT){
			spriteUI.moveLeft(canvas.iterator());
		}else if(event.getCode() == KeyCode.RIGHT){
			spriteUI.moveRight(canvas.iterator());
		}else if(event.getCode() == KeyCode.UP && canMoveUp){
			spriteUI.moveUp(canvas.iterator());
		}else if(event.getCode() == KeyCode.DOWN){
			spriteUI.moveDown(canvas.iterator());
		}else if(event.getCode() == KeyCode.ENTER) {
			MainApp.fightView = true;
		}else if(event.getCode() == KeyCode.I){
			new InventoryUI();
		}else if(event.getCode() == KeyCode.S){
			new SkillBaseUI();
		}
		System.out.println("Sprite X: " + spriteUI.getX());
		System.out.println("Sprite Y: " + spriteUI.getY());
		if(spriteUI.getY() <= 120) {
			MainApp.fightView = true;
			System.out.println("exchange");
		}
	    canMoveUp = true;
	    canMoveDown = true;
	    canMoveLeft = true;
	    canMoveRight = true;
	}
	
	
	public void update(){
		if(spriteUI.getY() <= 120) {
			MainApp.fightView = true;
			System.out.println("exchange");
		}
	}
	
	public static Stage MainStage() {
		Stage stage = new Stage();
		GamePanel gamePanel = new GamePanel();
		Scene scene = new Scene(gamePanel, SCENE_WIDTH, SCENE_HEIGHT);
		gamePanel.loadFirst();
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("SoulOfHero");
		stage.initStyle(StageStyle.UTILITY);

		return stage;
	}

}