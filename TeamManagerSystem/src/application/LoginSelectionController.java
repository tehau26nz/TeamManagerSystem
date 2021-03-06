package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * This controller is binded to LoginSelection.fxml.
 * This controller reacts to user role selection on their access level.
 * @author Selina Yu
 * @since 2021-11-01
 */
public class LoginSelectionController implements Initializable {
	/**
	 * managerAccessLevel is used by other controllers to enable/disable features due to different manager roles.
	 */
    public static String managerAccessLevel;
	@FXML private Button teamManagerBtn;
	@FXML private Button leagueManagerBtn;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This methods provides below two actions - 
	 * 1. Set manager access level when user selecting their access level
	 * 2. redirect to manager dashboard
	 * @param e
	 * @throws IOException
	 */
	@FXML public void loginSelectionHandleButtonAction(Event e) throws IOException {
		if(e.getSource() == teamManagerBtn) {
			managerAccessLevel = "teamManager";
			Parent root = FXMLLoader.load(getClass().getResource("/layouts/TeamManagerLogin.fxml"));
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}else if(e.getSource() == leagueManagerBtn){
			managerAccessLevel = "leagueManager";
			Parent root = FXMLLoader.load(getClass().getResource("/layouts/LeagueManagerLogin.fxml"));
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

}
