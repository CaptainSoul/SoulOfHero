package UI;

import java.awt.EventQueue;

import UI.common.GamePanel;
import UI.fight.FightCanvas;
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
	public StartFrame startFrame;
	
	public static String fightViewID = "fightView";
	public static boolean fightView = false;
	
	private String bgmStartURL = "/bgm/MainTitle.mp3";
	private String bgmMainURL = "/bgm/Theme1.mp3";
	private String bgmNervousURL = "/bgm/Illusions.mp3";
	private String bgmEpicURL = "/bgm/GameOfThrones.mp3";
	private String bgmSoulURL = "/bgm/LastReunion.mp3";
	private String bgmBattleURL = "/bgm/Battle.mp3";
	private String bgmBattleBossURL = "/bgm/BattleBoss.mp3";
	private String bgmBazaarURL = "/bgm/NassauShores.mp3";
	
	public static boolean bgmStart = false;
	public static boolean bgmMain = false;
	public static boolean bgmNervous = false;
	public static boolean bgmBattleBoss = false;
	
	private String url;
	private Media media;
	public MediaPlayer player;
	
	private StageController stageController;
	private boolean isRunning = true;
	private long sleep = 100;
	
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
			bgmStart = true;
			stageController.loadStage(loginViewID, loginViewRes, StageStyle.DECORATED);
			stageController.setStage(loginViewID);
			loginView = false;
		}else if(signUpView) {
			stageController.loadStage(signUpViewID, signUpViewRes, StageStyle.DECORATED);
			stageController.setStage(signUpViewID);
			signUpView = false;
		} else if(startView) {
			bgmStart = true;
			checkBgm();
			startFrame = new StartFrame();
			startFrame.main();
			startView = false;
		}  else if(mainView) {
			bgmNervous = true;
			stageController.addStage(mainViewID, GamePanel.MainStage());
			stageController.setStage(mainViewID);
			mainView = false;
		} else if(fightView) {
			bgmBattleBoss = true;
			stageController.addStage(fightViewID, FightCanvas.fightStage());
			stageController.setStage(fightViewID);
			fightView = false;
		}
		checkBgm();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stageController = new StageController();
			stageController.setPrimaryStage("primaryStage", primaryStage);
			loginView = true;

			thread.start();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkBgm() {
		if(bgmStart) {
			loadBgmStart();
			bgmStart = false;
		} else if(bgmNervous) {
			loadBgmNervous();
			bgmNervous = false;
		} else if(bgmBattleBoss) {
			loadBgmBattle();
			bgmBattleBoss = false;
		} else if(bgmMain) {
			loadBgmMain();
			bgmMain = false;
		}
	}
	
	public void loadBgmStart() {
		loadMusic(bgmStartURL);
	}
	
	public void loadBgmMain() {
		loadMusic(bgmMainURL);
	}
	
	public void loadBgmNervous() {
		loadMusic(bgmNervousURL);
	}
	
	public void loadBgmEpic() {
		loadMusic(bgmEpicURL);
	}
	
	public void loadBgmBattle() {
		loadMusic(bgmBattleURL);
	}
	
	public void loadBgmBazaar() {
		loadMusic(bgmBazaarURL);
	}
	
	public void loadBgmSoul() {
		loadMusic(bgmSoulURL);
	}
	
	public void loadBgmBattleBoss() {
		loadMusic(bgmBattleBossURL);
	}
	
	private void loadMusic(String name) {
		if(player != null)
			player.stop();
		url = getClass().getResource(name).toString();
		media = new Media(url);
		player = new MediaPlayer(media);
		setAutoPlay();
	}
	
	public void setAutoPlay() {
		player.setAutoPlay(true);
		player.setCycleCount(20);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
