package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import application.ClubController;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import models.PieChartEntry;
import models.Stats;

class ClubControllerTest {

	private static ClubController clubController;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		clubController = new ClubController();
	}

	@ParameterizedTest
	@MethodSource("testing.ClubControllerTestDataProvider#createClubStatsProvider")
	public void createClubStatsTest(int rank, String club, int won, int drawn, int lost, int points) {
		Stats stats = clubController.createNewStats(rank, club, won, drawn, lost, points);

		
		assertEquals(stats.getRank(), rank);
		assertEquals(stats.getClub(), club);
		assertEquals(stats.getWon(), won);
		assertEquals(stats.getDrawn(), drawn);
		assertEquals(stats.getLost(), lost);
		assertEquals(stats.getPoints(), points);

	}

	@ParameterizedTest
	@MethodSource("testing.ClubControllerTestDataProvider#createClubPieChartProvider")
	public void createClubPieChartTest(ArrayList<PieChartEntry> data) {
		ObservableList<PieChart.Data> pieChartData = clubController.setUpDataForPieChart(data);
		assertEquals(pieChartData.size(), 3);
		for (int i = 0; i < data.size(); i++) {
			assertEquals(pieChartData.get(i).getName(), data.get(i).getKey());
			assertEquals(pieChartData.get(i).getPieValue(), data.get(i).getValue());
		}
	}
	
	@ParameterizedTest(name = "{index}:createClubStatsTest1(0,1,2,3,4,5)")
	@MethodSource("testing.ClubControllerTestDataProvider#createClubStatsDataProvider")
	public void createClubStatsTest1(int rank, String club, int won, int drawn, int lost, int points) {
		Stats stats = clubController.createNewStats(rank, club, won, drawn, lost, points);

		assertNotNull(stats);
		assertEquals(stats.getRank(), rank);
		assertEquals(stats.getClub(), club);
		assertEquals(stats.getWon(), won);
		assertEquals(stats.getDrawn(), drawn);
		assertEquals(stats.getLost(), lost);
		assertEquals(stats.getPoints(), points);

	}

}
