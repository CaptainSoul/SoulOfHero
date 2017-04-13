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

public class LoginViewController implements ControlledStage, Initializable {
	private StageController myController;
	@FXML private TextField userNameField;
	@FXML private PasswordField passwordField;
	
	@FXML
	protected void handleSignInAction(ActionEvent event) {
		String user = userNameField.getText();
		String password = passwordField.getText();
		UserManagement.addUser(user, password);
		if(UserManagement.checkPassword(user, password)) {	
			JOptionPane.showMessageDialog(null, "Log In");
	//		myController.setStage(MainApp.mainViewID, MainApp.loginViewID);
			myController.getStage(MainApp.loginViewID).close();
			myController.unloadStage(MainApp.loginViewID);
		}
	}
	@Override
	public void setStageController(StageController stageController) {
		this.myController = stageController;
	}
	
	public void goToMain() {
		myController.setStage(MainApp.mainViewID);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
