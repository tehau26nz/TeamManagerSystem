package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class TeamsController implements Initializable {
	@FXML private TableView<FootyTeam> teamTableView;
	@FXML private TableColumn<FootyTeam,String> teamNameCol;
	@FXML private TableColumn<FootyTeam,String> teamCoachCol;
	
	@FXML private TextField addTeamName;
	@FXML private TextField addTeamCoach;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private ObservableList<FootyTeam> footyTeams = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		teamNameCol.setCellValueFactory(new PropertyValueFactory<FootyTeam,String>("footyTeamName"));
		teamCoachCol.setCellValueFactory(new PropertyValueFactory<FootyTeam,String>("footyTeamCoach"));
		footyTeams.add(new FootyTeam("Pheonix","Selina Yu"));
		
		List<Team> teams = new DataHelper().getTeams();
		for (Team t : teams) {
			footyTeams.add(new FootyTeam(t.getTeamName(), t.getCoachName()));
		}
		
		teamTableView.setItems(footyTeams);
	}
	
	@FXML public void handleButtonAction(Event e) {
		    footyTeams.add(new FootyTeam(addTeamName.getText(),addTeamCoach.getText()));
			
		    addTeamName.clear();
		    addTeamCoach.clear();
	}
	
	@FXML public void deleteRowFromTableViewAction(Event e) {
		teamTableView.getItems().removeAll(teamTableView.getSelectionModel().getSelectedItems());
	}
	
	/**
	 * Allow users to delete the selected event
	 * 
	 * @param e
	 */
	@FXML
	public void switchToDashboard(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public static class FootyTeam {
		private SimpleStringProperty footyTeamName,footyTeamCoach;
		
		public FootyTeam(String name,String coach) {
			this.setFootyTeamName(new SimpleStringProperty(name));
			this.setFootyTeamCoach(new SimpleStringProperty(coach));
		}

		public String getFootyTeamCoach() {
			return footyTeamCoach.get();
		}

		public void setFootyTeamCoach(SimpleStringProperty footyTeamCoach) {
			this.footyTeamCoach = footyTeamCoach;
		}

		public String getFootyTeamName() {
			return footyTeamName.get();
		}

		public void setFootyTeamName(SimpleStringProperty footyTeamName) {
			this.footyTeamName = footyTeamName;
		}
	}
}
