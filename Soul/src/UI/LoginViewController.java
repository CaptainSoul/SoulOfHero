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
		String userName = userNameField.getText();
		String password = passwordField.getText();
		if(userName.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter your ID and password");
		} else if(!UserManagement.isDuplication(userName)) {
			JOptionPane.showMessageDialog(null, "There is no this ID in database");
		} else if(UserManagement.checkPassword(userName, password)) {	
			JOptionPane.showMessageDialog(null, "Login success");
			MainApp.startView = true;
		} else if(!UserManagement.checkPassword(userName, password)) {
			JOptionPane.showMessageDialog(null, "Please check your password");
		}
	}
	
	@FXML
	protected void handleToSignUpAction(ActionEvent event) {
		MainApp.signUpView = true;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
