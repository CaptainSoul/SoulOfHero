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
	private boolean mainOn = false;
	
	public static String loginViewID = "LoginView";
	public static String loginViewRes = "LoginView.fxml";
	public static boolean loginView = false;
	private boolean loginOn = false;
	
	public static String signUpViewID = "SignUpView";
	public static String signUpViewRes = "SignUpView.fxml";
	public static boolean signUpView = false;
	private boolean signUpOn = false;
	
	public static String startViewID = "startView";
	public static boolean startView = false;
	private boolean startOn = false;
	
	public static String fightViewID = "fightView";
	public static boolean fightView = false;
	private boolean fightOn = false;
	
	private StageController stageController;
	public BGM bgm = BGM.getBGM();
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
			stageController.loadStage(loginViewID, loginViewRes, StageStyle.DECORATED);
			stageController.setStage(loginViewID);
			loginView = false;
		} else if(signUpView) {
			stageController.loadStage(signUpViewID, signUpViewRes, StageStyle.UTILITY);
			stageController.setStage(signUpViewID);
			signUpView = false;
		} else if(startView) {
			bgm.loadBgmStart();
			StartFrame.main(null);
			startView = false;
		} else if(mainView) {
			bgm.bgmTerror = true;
			stageController.addStage(mainViewID, GamePanel.MainStage());
			stageController.setStage(mainViewID);
			mainView = false;
		} else if(fightView) {
			bgm.bgmBattleBoss = true;
			stageController.addStage(fightViewID, FightCanvas.fightStage());
			stageController.setStage(fightViewID);
			fightView = false;
		}
		if(bgm.bgmStart) {
			bgm.loadBgmStart();
			bgm.bgmStart = false;
		} else if(bgm.bgmTerror) {
			bgm.loadBgmTerro();
			bgm.bgmTerror = false;
		} else if(bgm.bgmBattleBoss) {
			bgm.loadBgmBattle();
			bgm.bgmBattleBoss = false;
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			UserManagement.addUser("Hero", "123");
			stageController = new StageController();
			stageController.setPrimaryStage("primaryStage", primaryStage);
			loginView = true;

			bgm.setAutoPlay();
			thread.start();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
