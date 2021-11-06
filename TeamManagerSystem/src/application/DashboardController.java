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
 * This controller is binded to dashboard.fxml
 * This controller reacts to league manager navigation selection (button/image view click) 
 * 1. league manager clicks on back image view, navigate to login selection view
 * 2. league manager clicks on manage events button/image view, redirect to events view 
 * 3. league manager clicks on manage team button/image view, redirect to team view 
 * 4. league manager clicks on view players button/image view, redirect to player view 
 * 5. league manager clicks on view statistics button/image view, redirect to statistic view 
 * @author Selina Yu
 * @since 2021-11-01
 */
public class DashboardController implements Initializable{
	@FXML private ImageView imvDashboardPrevious;
	@FXML private Button btnteams;
	@FXML private Button btnEvents;
	@FXML private Button btnStatistics;
	@FXML private Button btnPlayers;
	@FXML private ImageView imvdashboardEvent;
	@FXML private ImageView imvDashboardStatistics;
	@FXML private ImageView imvdashboardteams;
	@FXML private ImageView imvDashboardPlayers;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * this methods handle image view click event for back image view
	 * @param e
	 * @throws IOException
	 */
	@FXML public void handleImageViewAction(Event e) throws IOException {
		Parent root;
		//Load the view of Login selection
	    root = FXMLLoader.load(getClass().getResource("/layouts/LoginSelection.fxml"));
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	/**
	 * this method handle button click event
	 * @param e
	 * @throws IOException
	 */
	@FXML public void handleDashboardButtonAction(Event e) throws IOException {
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
	/**
	 * this methods handle image view click event for navigation image view
	 * @param e
	 * @throws IOException
	 */
	@FXML public void handleDashboardImageViewAction(Event e) throws IOException {
		if(e.getSource() == imvdashboardEvent) {
			loadStages("/layouts/Events.fxml",e);
		}else if(e.getSource() == imvDashboardStatistics){
			loadStages("/layouts/Club.fxml",e);
		}else if(e.getSource() == imvdashboardteams){
			loadStages("/layouts/Teams.fxml",e);
		}else if(e.getSource() == imvDashboardPlayers){
			loadStages("/layouts/Players.fxml",e);
		}
	}
	/**
	 * Load new view 
	 * @param fxml
	 * @param e
	 */
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
