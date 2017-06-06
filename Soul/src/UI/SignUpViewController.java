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

public class SignUpViewController extends ControlledStage implements Initializable {
	private UserManagement userManagement = UserManagement.getUserManagement();
	@FXML private TextField userNameField;
	@FXML private PasswordField passwordField;
	@FXML private PasswordField checkPasswordField;
	
	@FXML
	protected void handleSignUpAction(ActionEvent event) {
		String user = userNameField.getText();
		String password = passwordField.getText();
		String passwordC = checkPasswordField.getText();
		if(user.equals("") || password.equals("") || passwordC.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter ID and password");
		} else if(userManagement.isDuplication(user)) {
			JOptionPane.showMessageDialog(null, "Duplicative ID");
		} else if(!password.equals(passwordC)) {
			JOptionPane.showMessageDialog(null, "Please check your password");
		} else {
			userManagement.addUser(user, password);
			MainApp.loginView = true;
		}
	}
	
	@FXML
	protected void handleToSignInAction(ActionEvent event) {
		MainApp.loginView = true;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
