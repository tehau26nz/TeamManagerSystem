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

public class LoginSelectionController implements Initializable {
    public static String managerAccessLevel;
	@FXML private Button teamManagerBtn;
	@FXML private Button leagueManagerBtn;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Set manager access level when user selecting their access level
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
