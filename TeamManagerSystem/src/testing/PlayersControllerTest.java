package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import application.PlayersController;
import models.Player;
import models.TeamEvent;

class PlayersControllerTest {
	
	private static PlayersController playersController;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		playersController = new PlayersController();
	}

	@ParameterizedTest
	@MethodSource("testing.PlayersControllerTestDataProvider#createPlayerDataProvider")
	public void createPlayerTest(String name,int height, String birthplace, String allpositions) {
		Player p = playersController.createNewPlayer(name, height, birthplace, allpositions);
		assertNotNull(p);
		assertEquals(p.getName(), name);
		assertEquals(p.getHeight(), height);
		assertEquals(p.getBirthplace(), birthplace);
		assertEquals(p.getAllPositions(), allpositions);
	}

}
