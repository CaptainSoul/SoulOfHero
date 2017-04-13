package UI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
	public static String mainViewID = "MainView";
	public static String mainViewRes = "MainView.fxml";
	
	public static String loginViewID = "LoginView";
	public static String loginViewRes = "LoginView.fxml";
	
	private StageController stageController;

	@Override
	public void start(Stage primaryStage) {
		stageController = new StageController();
		stageController.setPrimaryStage("primaryStage", primaryStage);
		stageController.loadStage(loginViewID, loginViewRes, StageStyle.UNDECORATED);
	//	stageController.loadStage(mainViewID, mainViewRes);
		stageController.setStage(loginViewID);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
