package UI;

import UI.common.GamePanel;
import UI.fight.FightCanvas;
import javafx.application.Application;
import javafx.application.Platform;
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
	
	private BGM bgm;
	
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
			BGM.bgmStart = true;
			stageController.loadStage(loginViewID, loginViewRes, StageStyle.DECORATED);
			stageController.setStage(loginViewID);
			loginView = false;
		}else if(signUpView) {
			stageController.loadStage(signUpViewID, signUpViewRes, StageStyle.DECORATED);
			stageController.setStage(signUpViewID);
			signUpView = false;
		} else if(startView) {
			BGM.bgmStart = true;
			startFrame = new StartFrame();
			startFrame.main();
			startView = false;
		}  else if(mainView) {
			BGM.bgmNervous = true;
			stageController.addStage(mainViewID, GamePanel.MainStage());
			stageController.setStage(mainViewID);
			mainView = false;
		} else if(fightView) {
			BGM.bgmBattleBoss = true;
			stageController.addStage(fightViewID, FightCanvas.fightStage());
			stageController.setStage(fightViewID);
			fightView = false;
		}
		bgm.checkBgm();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stageController = new StageController();
			stageController.setPrimaryStage("primaryStage", primaryStage);
			bgm = BGM.getBGM();
			loginView = true; 

			thread.start();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
