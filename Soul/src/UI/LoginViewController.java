package UI;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import archive.UserManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController extends ControlledStage implements Initializable {
	@FXML private TextField userNameField;
	@FXML private PasswordField passwordField;
	
	@FXML
	protected void handleSignInAction(ActionEvent event) {
		String user = userNameField.getText();
		String password = passwordField.getText();
		UserManagement.addUser(user, password);
		if(UserManagement.checkPassword(user, password)) {	
			JOptionPane.showMessageDialog(null, "Log In");
			MainApp.mainView = true;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
