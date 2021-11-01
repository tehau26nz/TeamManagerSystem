package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
		new PieChart.Data("Wins 38.6%", 38.6),
		new PieChart.Data("Draws 30.7%", 30.7),
		new PieChart.Data("Losses 30.7", 30.7)
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

	public static class Stats{
		private Integer rank;
		private SimpleStringProperty club;
		private Integer win, draw,loss,points;
		
		public Stats(int rank, String club,int win,int draw,int loss,int points) {
			this.rank =rank;
			this.club =new SimpleStringProperty(club);
			this.draw =draw;
			this.win =win;
			this.loss =loss;
			this.points =points;
		}
		public Integer getRank() {
			return rank;
		}
		public void setRank(Integer rank) {
			this.rank = rank;
		}
		public String getClub() {
			return club.get();
		}
		public void setClub(SimpleStringProperty club) {
			this.club = club;
		}
		public Integer getDraw() {
			return draw;
		}
		public void setDraw(Integer draw) {
			this.draw = draw;
		}
		public Integer getLoss() {
			return loss;
		}
		public void setLoss(Integer loss) {
			this.loss = loss;
		}
		public Integer getPoints() {
			return points;
		}
		public void setPoints(Integer points) {
			this.points = points;
		}
		public Integer getWin() {
			return win;
		}
		public void setWin(Integer win) {
			this.win = win;
		}
	}
}
