package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
	@MethodSource("createClubStatsProvider")
	public void createClubStatsTest(int rank, String club, int won, int drawn, int lost, int points) {
		Stats stats = clubController.createNewStats(rank, club, won, drawn, lost, points);
		assertEquals(stats.getRank(), rank);
		assertEquals(stats.getClub(), club);
		assertEquals(stats.getWon(), won);
		assertEquals(stats.getDrawn(), drawn);
		assertEquals(stats.getLost(), lost);
		assertEquals(stats.getPoints(), points);

	}
	
	public static Stream<Arguments> createClubStatsProvider() {
		return Stream.of(
				Arguments.of(7,"Wolverhampton Wanderers",5,1,4,16),
				Arguments.of(8,"Everton",4,2,4,14)
		);
	}
	
	@ParameterizedTest(name = "{index}:createClubStatsTest1(0,1,2,3,4,5)")
	@MethodSource("createClubStatsDataProvider")
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
	
	public static Collection createClubStatsDataProvider() {
		return Arrays.asList(new Object[][] {
			{9,"West Ham United",6,2,2,20},
			{10,"Newcastle United",0,4,6,4}
			}
		);
	}

	@ParameterizedTest
	@MethodSource("createClubPieChartProvider")
	public void createClubPieChartTest(ArrayList<PieChartEntry> data) {
		ObservableList<PieChart.Data> pieChartData = clubController.setUpDataForPieChart(data);
		assertEquals(pieChartData.size(), 3);
		for (int i = 0; i < data.size(); i++) {
			assertEquals(pieChartData.get(i).getName(), data.get(i).getKey());
			assertEquals(pieChartData.get(i).getPieValue(), data.get(i).getValue());
		}
	}
	
	public static Stream<Arguments> createClubPieChartProvider() {
		ArrayList<PieChartEntry> data1 = new ArrayList<>();
		data1.add(new PieChartEntry("Won 70%", 70.0));
		data1.add(new PieChartEntry("Drawn 15%", 15.0));
		data1.add(new PieChartEntry("Lost 15%", 15.0));
		
		ArrayList<PieChartEntry> data2 = new ArrayList<>();
		data2.add(new PieChartEntry("Won 30%", 30.0));
		data2.add(new PieChartEntry("Drawn 40%", 40.0));
		data2.add(new PieChartEntry("Lost 30%", 30.0));
		
		return Stream.of(
				Arguments.of(data1),
				Arguments.of(data2)
		);
	}

}
