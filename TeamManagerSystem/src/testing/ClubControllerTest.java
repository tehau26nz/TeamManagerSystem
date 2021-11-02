package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import application.ClubController;
import models.Stats;
import models.TeamEvent;

class ClubControllerTest {
	
	private static ClubController clubController;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		clubController = new ClubController();
	}

	@ParameterizedTest
	@MethodSource("testing.ClubControllerTestDataProvider#createClubStatsProvider")
	public void createClubStatsTest(int rank,String club,int won,int drawn,int lost,int points) {
		Stats stats = clubController.createNewStats(rank,club,won,drawn,lost,points);
		
		assertNotNull(stats);
		assertEquals(stats.getRank(), rank);
		assertEquals(stats.getClub(),club);
		assertEquals(stats.getWon(),won);
		assertEquals(stats.getDrawn(),drawn);
		assertEquals(stats.getLost(),lost);
		assertEquals(stats.getPoints(),points);
		
	}

}
