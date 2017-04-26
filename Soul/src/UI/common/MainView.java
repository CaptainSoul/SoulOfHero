package UI.common;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainView extends Application {
	//test sprite
	@Override
	public void start(Stage stage) throws Exception {
		GamePanel mPanel = new GamePanel();
		final Scene scene = new Scene(mPanel, 800, 600);
		mPanel.load();
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("YCaptain");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(MainView.class, args);
	}

}
