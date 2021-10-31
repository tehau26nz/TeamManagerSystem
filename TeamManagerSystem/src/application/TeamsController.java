package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;

public class TeamsController implements Initializable {
	@FXML private TableView<FootyTeam> teamTableView;
	@FXML private TableColumn<FootyTeam,String> teamNameCol;
	@FXML private TableColumn<FootyTeam,String> teamCoachCol;
	
	@FXML private TextField addTeamName;
	@FXML private TextField addTeamCoach;
	
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
