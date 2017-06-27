package UI;

import UI.common.GamePanel;
import UI.fight.FightCanvas;
import archive.Archive;
import archive.User;
import databaseService.ArmorService;
import databaseService.InventoryService;
import databaseService.SkillBaseService;
import databaseService.WeaponService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import scenarioG.FightEnd;
import scenarioG.TaskController;
import utils.BGM;

public class MainApp extends Application {
	public static String mainViewID = "MainView";
	public static boolean mainView = false;
	public static boolean loadMain = false;
	public static boolean loadRoom = false;
	public static boolean loadHeaven = false;
	public static boolean loadCave = false;
	public static boolean loadChurch = false;
	public static boolean loadFort = false;
	public static boolean loadTown = false;
	public static boolean loadBeach = false;
	public static boolean loadGardon = false;
	public static boolean loadMazeFir = false;
	public static boolean loadMazeSec = false;
	public static boolean loadMazeThi = false;
	public static boolean loadFire = false;
	public static boolean loadWater = false;
	public static boolean loadWind = false;
	public static boolean loadEarth = false;
	public static boolean loadElement = false;
	public static boolean loadBoss = false;
	public static boolean firLoadRoom = true;
	public static boolean firLoadHeaven = true;

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
	public static boolean fightCave = false;
	
	public static String fightEndID = "fightEndView";
	public static boolean fightEndView = false;
	public FightEnd fightEnd;
	
	public static InventoryService inventoryService;
	public static WeaponService weaponService;
	public static ArmorService armorService;
	public static SkillBaseService skillBaseService;
	
	public static User user;
	public static Archive archive;
	
	public TaskController taskController; 
	
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
			if(stageController.getStage(mainViewID) == null)
				stageController.addStage(mainViewID, GamePanel.MainStage());
			if(loadMain) {
				BGM.bgmNervous = true;
				GamePanel.loadMain();
				loadMain = false;
			} else if(loadRoom) {
				BGM.bgmChurch = true;
				GamePanel.loadRoom();
				loadRoom = false;
				firLoadRoom = false;
			} else if(loadHeaven) {
				BGM.bgmChurch = true;
				GamePanel.loadHeaven();
				loadHeaven = false;
				firLoadHeaven = false;
			} else if(loadCave) {
				BGM.bgmNervous = true;
				GamePanel.loadCave();
				loadCave = false;
			} else if(loadChurch) {
				BGM.bgmNervous2 = true;
				GamePanel.loadChurch();
				loadChurch = false;
			} else if(loadBeach) {
				BGM.bgmNervous2 = true;
				GamePanel.loadBeach();
				loadBeach = false;
			} else if(loadGardon) {
				BGM.bgmNervous2 = true;
				GamePanel.loadGardon();
				loadGardon = false;
			} else if(loadMazeFir) {
				BGM.bgmNervous2 = true;
				GamePanel.loadMaze1();
				loadMazeFir = false;
			} else if(loadMazeSec) {
				BGM.bgmNervous2 = true;
				GamePanel.loadMaze2();
				loadMazeSec = false;
			} else if(loadMazeThi) {
				BGM.bgmNervous2 = true;
				GamePanel.loadMaze3();
				loadMazeThi = false;
			} else if(loadElement) {
				BGM.bgmNervous2 = true;
				GamePanel.loadElement();
				loadElement = false;
			} else if(loadEarth) {
				BGM.bgmNervous2 = true;
				GamePanel.loadEarth();
				loadEarth = false;
			} else if(loadFire) {
				BGM.bgmNervous2 = true;
				GamePanel.loadFire();
				loadFire = false;
			} else if(loadWater) {
				BGM.bgmNervous2 = true;
				GamePanel.loadWater();
				loadWater = false;
			} else if(loadWind) {
				BGM.bgmNervous2 = true;
				GamePanel.loadWind();
				loadWind = false;
			} else if(loadBoss) {
				BGM.bgmNervous2 = true;
				GamePanel.loadBoss();
				loadBoss = false;
			}
			stageController.setStage(mainViewID);
			mainView = false;
		} else if(fightView) {
			BGM.bgmBattleBoss = true;
			if(stageController.getStage(fightViewID) == null)
				stageController.addStage(fightViewID, FightCanvas.fightStage());
			if(fightCave) {
				BGM.bgmBattle = true;
				FightCanvas.setCaveEnemy();
			}
			stageController.setStage(fightViewID);
			fightView = false;
		} else if(fightEndView) {
			BGM.bgmNervous = true;
			fightEnd = new FightEnd();
			fightEnd.main();
			fightEndView = false;
		}
		
		bgm.checkBgm();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stageController = new StageController();
			stageController.setPrimaryStage("primaryStage", primaryStage);
			taskController = new TaskController();
			inventoryService = new InventoryService();
			weaponService = new WeaponService();
			armorService=  new ArmorService();
			skillBaseService = new SkillBaseService();
			bgm = BGM.getBGM();
			fightView = true;
			fightCave = true;

			thread.start();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
