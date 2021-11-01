package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Team;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class TeamsController implements Initializable {
	@FXML private TableView<Team> teamTableView;
	@FXML private TableColumn<Team,String> teamNameCol;
	@FXML private TableColumn<Team,String> teamCoachCol;
	
	@FXML private TextField addTeamName;
	@FXML private TextField addTeamCoach;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML private Button btnAddTeam;
	@FXML private Button btnDeleteTeam;
	
	private ObservableList<Team> footyTeams = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		teamNameCol.setCellValueFactory(new PropertyValueFactory<Team,String>("teamName"));
		teamCoachCol.setCellValueFactory(new PropertyValueFactory<Team,String>("coachName"));
		//footyTeams.add(new FootyTeam("Pheonix","Selina Yu"));
		
		List<Team> teams = new DataHelper().getTeams();
		for (Team t : teams) {
			footyTeams.add(new Team(t.getTeamName(), t.getCoachName()));
		}
		
		teamTableView.setItems(footyTeams);
		
		//Team manager only allows to view teams
		if(LoginSelectionController.managerAccessLevel.equals("teamManager")) {
			btnAddTeam.setVisible(false);
			btnDeleteTeam.setVisible(false);
			addTeamName.setVisible(false);
			addTeamCoach.setVisible(false);
		}else {
			btnAddTeam.setVisible(true);
			btnDeleteTeam.setVisible(true);
			addTeamName.setVisible(true);
			addTeamCoach.setVisible(true);
		}
	}
	@FXML
	public void switchToPrevious(Event e) throws IOException {
		Parent root;
		if(LoginSelectionController.managerAccessLevel.equals("teamManager")) {
			 root = FXMLLoader.load(getClass().getResource("/layouts/TeamManagerDashboard.fxml"));
		}else {
			root = FXMLLoader.load(getClass().getResource("/layouts/Dashboard.fxml"));
		}
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML public void handleButtonAction(Event e) {
		    footyTeams.add(new Team(addTeamName.getText(),addTeamCoach.getText()));
			
		    addTeamName.clear();
		    addTeamCoach.clear();
	}
	
	@FXML public void deleteRowFromTableViewAction(Event e) {
		teamTableView.getItems().removeAll(teamTableView.getSelectionModel().getSelectedItems());
	}
}
