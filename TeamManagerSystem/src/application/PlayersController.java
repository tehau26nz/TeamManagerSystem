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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Player;
import models.Team;

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
	
	private ObservableList<Player> players = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		playerNameCol.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		playerBirthplaceCol.setCellValueFactory(new PropertyValueFactory<Player,String>("birthplace"));
		playerHeightCol.setCellValueFactory(new PropertyValueFactory<Player,Integer>("height"));
		playerAllPositionsCol.setCellValueFactory(new PropertyValueFactory<Player,String>("allPositions"));
		
		Team team = new DataHelper().getTeams().get(2);
		players.addAll(team.getTeamPlayers());
		playerTableView.setItems(players);
	}
	
	@FXML public void handleButtonAction(Event e) {
		players.add(new Player(addPlayerName.getText(), Integer.parseInt(addPlayerHeight.getText()),addPlayerBirthplace.getText(),addPlayerAllPositions.getText()));
			
		addPlayerName.clear();
		addPlayerBirthplace.clear();
		addPlayerHeight.clear();
		addPlayerAllPositions.clear();
	}
	
	@FXML public void handleImageViewAction(Event e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/Dashboard.fxml"));
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML public void deleteRowFromTableViewAction(Event e) {
		playerTableView.getItems().removeAll(playerTableView.getSelectionModel().getSelectedItems());
	}
}