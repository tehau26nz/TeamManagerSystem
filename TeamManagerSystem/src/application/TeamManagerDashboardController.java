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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * This controller is binded to TeamManagerDashboard.fxml
 * This controller reacts to team manager navigation selection (button/image view click) 
 * 1. team manager clicks on back image view, navigate to login selection view
 * 2. team manager clicks on view events button, redirect to events view 
 * 3. team manager clicks on view League team button, redirect to team view 
 * 4. league manager clicks on Manager players button, redirect to player view 
 * 5. league manager clicks on view Club statistics button, redirect to statistic view 
 * @author Tehaunui Shing Soi 
 * @since 2021-11-01
 */
public class TeamManagerDashboardController implements Initializable{
	@FXML private Button btnteams;
	@FXML private Button btnEvents;
	@FXML private Button btnStatistics;
	@FXML private Button btnPlayers;
	@FXML private ImageView imvTeamManagerDashboardPrevious;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
	}
	
	@FXML public void handleImageViewAction(Event e) throws IOException {
		Parent root;
	    root = FXMLLoader.load(getClass().getResource("/layouts/LoginSelection.fxml"));
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML public void handleTeamManagerDashboardButtonAction(Event e) throws IOException {
		if(e.getSource() == btnEvents) {
			loadStages("/layouts/Events.fxml",e);
		}else if(e.getSource() == btnStatistics){
			loadStages("/layouts/Club.fxml",e);
		}else if(e.getSource() == btnteams){
			loadStages("/layouts/Teams.fxml",e);
		}else if(e.getSource() == btnPlayers){
			loadStages("/layouts/Players.fxml",e);
		}
	}
	
	private void loadStages(String fxml, Event e) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
