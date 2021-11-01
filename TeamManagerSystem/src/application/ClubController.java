package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Stats;

public class ClubController implements Initializable {
	@FXML PieChart pieChart;
	@FXML private TableView<Stats> tableStats;
	@FXML private TableColumn<Stats, Integer> rankCol;
	@FXML private TableColumn<Stats, String> clubCol;
	@FXML private TableColumn<Stats, Integer> wCol;
	@FXML private TableColumn<Stats, Integer> dCol;
	@FXML private TableColumn<Stats, Integer> lCol;
	@FXML private TableColumn<Stats, Integer> pointsCol;
	private ObservableList<Stats> clubStats = FXCollections.observableArrayList();
	@FXML private ImageView ivClubPrevious;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
		new PieChart.Data("Wins 38.6%", 38.6),
		new PieChart.Data("Draws 30.7%", 30.7),
		new PieChart.Data("Losses 30.7%", 30.7)
		);
		
		pieChart.setData(pieChartData);
		pieChart.autosize();
		
		rankCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("rank"));
		clubCol.setCellValueFactory(new PropertyValueFactory<Stats,String>("club"));
		wCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("win"));
		dCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("draw"));
		lCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("loss"));
		pointsCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("points"));
	
		tableStats.setItems(clubStats);
		clubStats.add(new Stats(1,"Mel FC",15,4,7,49));
		clubStats.add(new Stats(2,"Sydney FC",13,8,5,47));
		clubStats.add(new Stats(3,"Central Coast",12,6,8,42));
		clubStats.add(new Stats(4,"Brisbane FC",11,7,8,40));
		clubStats.add(new Stats(5,"Adelaide",11,6,9,39));
		clubStats.add(new Stats(6,"Macarthur FC",11,6,9,39));
		clubStats.add(new Stats(7,"Pheonix",10,8,8,38));
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
}
