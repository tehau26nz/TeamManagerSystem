package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import models.PieChartEntry;
import models.Stats;
/**
 * This controller is binded to Club.fxml.
 * This controller reacts to show club statistics by using pie chart, table view and image view.
 * 
 * @author Selina Yu
 *
 */
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
	private ArrayList<PieChartEntry> entryData = new ArrayList<>();
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
	/**
	 * Add dummy statistic data 
	 */
	public void addStats() {
		
		createNewStatsAndAdd(1,"Chelsea",8,1,1,25);
		createNewStatsAndAdd(2,"Liverpool",6,4,0,22);
		createNewStatsAndAdd(3,"Manchester City",6,2,2,20);
		createNewStatsAndAdd(4,"Manchester United",5,2,3,17);
		createNewStatsAndAdd(5,"Arsenal",5,2,3,17);
		createNewStatsAndAdd(6,"Tottenham HotSpur",5,0,5,15);
		
	}
	
	/**
	 * Bind pie chart to dummy data
	 * Future works - bind pie chart to data from data source such as database
	 */
	public void setUpPieChart() {
		ArrayList<PieChartEntry> data = new ArrayList<>();
		data.add(new PieChartEntry("Won 60%", 60.0));
		data.add(new PieChartEntry("Drawn 20%", 20.0));
		data.add(new PieChartEntry("Lost 20%", 20.0));
		
		pieChartData = setUpDataForPieChart(data);
		pieChart.setData(pieChartData);
		pieChart.autosize();
	}
	
	public ObservableList<PieChart.Data> setUpDataForPieChart(ArrayList<PieChartEntry> entries) {
		pieChartData = FXCollections.observableArrayList();
		
		for(PieChartEntry entry:entries) {
			pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
		}
		
		return pieChartData;
	}
	/**
	 * Bind table view to Statistic Model	
	 */
	public void setUpRankTableView() {
		rankCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("rank"));
		clubCol.setCellValueFactory(new PropertyValueFactory<Stats,String>("club"));
		wCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("won"));
		dCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("drawn"));
		lCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("lost"));
		pointsCol.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("points"));
	
	}
	/**
	 * this methods handle back image view click event 
	 * @param e
	 * @throws IOException
	 */
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

	public ObservableList<PieChart.Data> getPieChartData() {
		return pieChartData;
	}

	public void setPieChartData(ObservableList<PieChart.Data> pieChartData) {
		this.pieChartData = pieChartData;
	}

	public ArrayList<PieChartEntry> getEntryData() {
		return entryData;
	}

	public void setEntryData(ArrayList<PieChartEntry> entryData) {
		this.entryData = entryData;
	}
	
}
