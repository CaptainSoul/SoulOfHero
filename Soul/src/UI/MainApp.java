package UI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import map.MapCanvas;

public class MainApp extends Application {
	public static String mainViewID = "MainView";
	public static String mainViewRes = "MainView.fxml";
	
	public static String loginViewID = "LoginView";
	public static String loginViewRes = "LoginView.fxml";
	
	public static String mapViewID = "MapView";
	
	private StageController stageController;

	@Override
	public void start(Stage primaryStage) {
		try {
			stageController = new StageController();
			stageController.setPrimaryStage("primaryStage", primaryStage);
			stageController.loadStage(loginViewID, loginViewRes, StageStyle.UNDECORATED);
			stageController.addStage(mapViewID, MapCanvas.mapStage());
	//		stageController.loadStage(mainViewID, mainViewRes);
			System.out.println(1);
			stageController.setStage(loginViewID);
			System.out.println(2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
