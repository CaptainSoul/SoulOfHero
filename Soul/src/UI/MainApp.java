package UI;

import UI.common.GamePanel;
import UI.fight.FightCanvas;
import archive.UserManagement;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
	public static String mainViewID = "MainView";
	public static String mainViewRes = "MainView.fxml";
	public static boolean mainView = false;
	
	public static String loginViewID = "LoginView";
	public static String loginViewRes = "LoginView.fxml";
	public static boolean loginView = false;
	
	public static String signUpViewID = "SignUpView";
	public static String signUpViewRes = "SignUpView.fxml";
	public static boolean signUpView = false;
	
	public static String startViewID = "startView";
	public static boolean startView = false;
	
	public static String fightViewID = "fightView";
	public static boolean fightView = false;
	
	private StageController stageController;
	private boolean isRunning = true;
	private long sleep = 100;
	private String url = getClass().getResource("¡÷”—…˘ - –°µ∂ª·–Ú«˙.mp3").toString();
	private Media media = new Media(url);
	private MediaPlayer player = new MediaPlayer(media);
	
	private Thread thread = new Thread(new Runnable() {

		@Override
		public void run() {
			while(isRunning) {
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						update();
					}
					
				});
				try {
					Thread.sleep(sleep);
				} catch(InterruptedException e) {
					e.getLocalizedMessage();
				}
			}
		}
		
	});
	
	public void update() {
		if(loginView) {
			player.play();
			stageController.loadStage(loginViewID, loginViewRes, StageStyle.UTILITY);
			stageController.setStage(loginViewID);
			loginView = false;
		} else if(signUpView) {
			stageController.loadStage(signUpViewID, signUpViewRes, StageStyle.UTILITY);
			stageController.setStage(signUpViewID);
			signUpView = false;
		} else if(startView) {
			StartFrame.main(null);
			startView = false;
		} else if(mainView) {
			loadMusic("Can't Take My Eyes Off You.mp3");
			stageController.addStage(mainViewID, GamePanel.MainStage());
			stageController.setStage(mainViewID);
			mainView = false;
		} else if(fightView) {
			loadMusic("The General's Order.mp3");
			stageController.addStage(fightViewID, FightCanvas.fightStage());
			stageController.setStage(fightViewID);
			fightView = false;
		}
	}
	
	public void loadMusic(String name) {
		player.stop();
		url = getClass().getResource(name).toString();
		media = new Media(url);
		player = new MediaPlayer(media);
		player.play();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			UserManagement.addUser("Hero", "123");
			stageController = new StageController();
			stageController.setPrimaryStage("primaryStage", primaryStage);
			loginView = true;

			player.setAutoPlay(true);
			player.setCycleCount(20);
			thread.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
