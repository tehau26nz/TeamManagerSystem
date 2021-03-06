package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Player;
import models.Team;
/**
 * This controller is binded to Players.fxml
 * * This controller reacts to show player info by using table view and combo box.
 * 1. team manager allow to manage their club players such as adding/deleting players 
 * 2. league manager only allow to view players but they allow to see any teams' players.
 * @author Selina Yu
 * @since 2021-11-01
 */
public class PlayersController  implements Initializable {
	@FXML private TableView<Player> playerTableView;
	@FXML private TableColumn<Player,String> playerNameCol;
	@FXML private TableColumn<Player,String> playerBirthplaceCol;
	@FXML private TableColumn<Player,Integer> playerHeightCol;
	@FXML private TableColumn<Player,String> playerAllPositionsCol;
	@FXML private TextField addPlayerName;
	@FXML private TextField addPlayerBirthplace;
	@FXML private TextField addPlayerHeight;
	@FXML private TextField addPlayerAllPositions;
	@FXML private Button btnAddPlayer;
	@FXML private Button btnDeletePlayer;
	@FXML private ImageView ivPlayerPrevious;
	@FXML private ComboBox<String> cbbTeams;
	
	private ObservableList<Player> players = FXCollections.observableArrayList();
	private ObservableList<String> teamnames = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		playerNameCol.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		playerBirthplaceCol.setCellValueFactory(new PropertyValueFactory<Player,String>("birthplace"));
		playerHeightCol.setCellValueFactory(new PropertyValueFactory<Player,Integer>("height"));
		playerAllPositionsCol.setCellValueFactory(new PropertyValueFactory<Player,String>("allPositions"));
		
		//Team ComboBox
		teamnames.addAll(new DataHelper("teams.txt").getTeamnames());
		cbbTeams.setItems(teamnames);
		cbbTeams.getSelectionModel().select(2);
		handleSection();
		
		//Player TableViews
		Team team = new DataHelper("teams.txt").getTeambyName(cbbTeams.getSelectionModel().getSelectedItem());
		players.addAll(team.getTeamPlayers());
		playerTableView.setItems(players);
		
		//League manager only allows to view players
		if(LoginSelectionController.managerAccessLevel.equals("leagueManager")) {
			btnAddPlayer.setVisible(false);
			btnDeletePlayer.setVisible(false);
			addPlayerName.setVisible(false);
			addPlayerBirthplace.setVisible(false);
			addPlayerHeight.setVisible(false);
			addPlayerAllPositions.setVisible(false);
			cbbTeams.setVisible(true);
		}else {
			btnAddPlayer.setVisible(true);
			btnDeletePlayer.setVisible(true);
			addPlayerName.setVisible(true);
			addPlayerBirthplace.setVisible(true);
			addPlayerHeight.setVisible(true);
			addPlayerAllPositions.setVisible(true);
			cbbTeams.setVisible(false);
		}
	}
	/**
	 * This method handles Delete Player Event
	 * @param e
	 */
	@FXML public void deleteRowFromTableViewAction(Event e) {
		playerTableView.getItems().removeAll(playerTableView.getSelectionModel().getSelectedItems());
	}
	/**
	 * This method handles Add Player Event
	 * @param e
	 */
	@FXML public void handleButtonAction(Event e) {
//		players.add(new Player(addPlayerName.getText(), Integer.parseInt(addPlayerHeight.getText()),addPlayerBirthplace.getText(),addPlayerAllPositions.getText()));
		addNewPlayer(addPlayerName.getText(), Integer.parseInt(addPlayerHeight.getText()),addPlayerBirthplace.getText(),addPlayerAllPositions.getText());	
		addPlayerName.clear();
		addPlayerBirthplace.clear();
		addPlayerHeight.clear();
		addPlayerAllPositions.clear();
	}
	
	public Player createNewPlayer(String name,int height, String birthplace, String allpositions) {
		return new Player(name, height, birthplace, allpositions);
	}
	
	public void addNewPlayer(String name,int height, String birthplace, String allpositions) {
		players.add(createNewPlayer(name, height, birthplace, allpositions));
	}
	/**
	 * This method handles team selection Event 
	 * @param e
	 */
	public void handleSection() {
		cbbTeams.setOnAction(event ->{
			Team team = new DataHelper("teams.txt").getTeambyName(cbbTeams.getSelectionModel().getSelectedItem());
			players.clear();
			players.addAll(team.getTeamPlayers());
		});
	}
	
	@FXML public void handleImageViewAction(Event e) throws IOException {
		Parent root;
		if(LoginSelectionController.managerAccessLevel.equals("teamManager")) {
			 root = FXMLLoader.load(getClass().getResource("/layouts/TeamManagerDashboard.fxml"));
		}else {
			root = FXMLLoader.load(getClass().getResource("/layouts/Dashboard.fxml"));
		}
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public ObservableList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ObservableList<Player> players) {
		this.players = players;
	}
	
}
