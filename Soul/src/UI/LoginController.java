package UI;

import com.sun.glass.ui.Window;

import archive.UserManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LoginController {
	@FXML private GridPane loginPane;
	@FXML private Text actiontarget;
	@FXML private TextField userNameField;
	@FXML private PasswordField passwordField;
	
	@FXML
	protected void handleSignInAction(ActionEvent evne) {
		String user = userNameField.getText();
		String password = passwordField.getText();
		if(UserManagement.checkPassword(user, password)) {
			
		}
		
	}
}
