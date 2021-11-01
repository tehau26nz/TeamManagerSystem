package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SceneController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	private Button btnStatistics;
	@FXML private ImageView imvdashboardEvent;
	@FXML private ImageView imvDashboardStatistics;
	@FXML private ImageView imvdashboardteams;
	@FXML private ImageView imvDashboardPlayers;

	public void switchToIntro(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/Intro.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToLoginSelection(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/LoginSelection.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToTeamManagerLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/TeamManagerLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToLeagueManagerLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/LeagueManagerLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToDashboard(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/Dashboard.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToTeamManagerDashboard(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/TeamManagerDashboard.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void switchToEvents(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/Events.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToTeams(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/Teams.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToStatistics(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/Club.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToPlayers(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/Players.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML public void handleDashboardImageViewAction(Event e) throws IOException {
		if(e.getSource() == imvdashboardEvent) {
			loadStages("/layouts/Events.fxml");
		}else if(e.getSource() == imvDashboardStatistics){
			loadStages("/layouts/Club.fxml");
		}else if(e.getSource() == imvdashboardteams){
			loadStages("/layouts/Teams.fxml");
		}else if(e.getSource() == imvDashboardPlayers){
			loadStages("/layouts/Players.fxml");
		}
	}
	
	private void loadStages(String fxml) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
