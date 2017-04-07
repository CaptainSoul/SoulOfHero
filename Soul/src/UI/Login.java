package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage.setTitle("Soul of Hero: Welcome");
		stage.setScene(new Scene(root, 600, 400));
		stage.show();
	}
	
	public static void main(String[] args) {
        launch(args);
    }
	
	
}
