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
	private ObservableList<PieChart.Data> pieChartData;
	@FXML private ImageView ivClubPrevious;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		setUpRankTableView();
		setUpPieChart();
		tableStats.setItems(clubStats);
		addStats();

	}
	
	public Stats createNewStats(int rank, String club,int won,int drawn,int lost,int points) {
		return new Stats(rank,club,won,drawn,lost,points);
	}
	
	public void createNewStatsAndAdd(int rank, String club,int won,int drawn,int lost,int points) {
		clubStats.add(new Stats(rank,club,won,drawn,lost,points));
	}
	
	public void addStats() {
		
		createNewStatsAndAdd(1,"Chelsea",8,1,1,25);
		createNewStatsAndAdd(2,"Liverpool",6,4,0,22);
		createNewStatsAndAdd(3,"Manchester City",6,2,2,20);
		createNewStatsAndAdd(4,"Manchester United",5,2,3,17);
		createNewStatsAndAdd(5,"Arsenal",5,2,3,17);
		createNewStatsAndAdd(6,"Tottenham HotSpur",5,0,5,15);
		
	}
	
	public void setUpPieChart() {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Won 60%", 60),
				new PieChart.Data("Drawn 20%", 20),
				new PieChart.Data("Lost 20%", 20)
				);
				
				pieChart.setData(pieChartData);
				pieChart.autosize();
	}
	
	public void setUpRankTableView() {
		rankCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("rank"));
		clubCol.setCellValueFactory(new PropertyValueFactory<Stats,String>("club"));
		wCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("won"));
		dCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("drawn"));
		lCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("lost"));
		pointsCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("points"));
	
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
