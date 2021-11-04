package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import application.PlayersController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Player;
import models.TeamEvent;

class PlayersControllerTest {
	
	private static PlayersController playersController;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		playersController = new PlayersController();
	}

	@ParameterizedTest
	@MethodSource("createPlayerDataProvider")
	public void createPlayerTest(String name, int height, String birthplace, String allpositions) {
		Player p = playersController.createNewPlayer(name, height, birthplace, allpositions);
		assertNotNull(p);
		assertEquals(p.getName(), name);
		assertEquals(p.getHeight(), height);
		assertEquals(p.getBirthplace(), birthplace);
		assertEquals(p.getAllPositions(), allpositions);
	}
	
	public static Stream<Arguments>createPlayerDataProvider(){
		return Stream.of(
					Arguments.of("Ferren Torres",184,"Spain","M,F"),
					Arguments.of("Ilkay Gündogan",180,"Germany","M")
				);
	}
	
	@ParameterizedTest
	@MethodSource("addPlayerDataProvider")
	public void addPlayerTest(String name, int height, String birthplace, String allpositions) {
		playersController.addNewPlayer(name, height, birthplace, allpositions);
		ObservableList<Player>players = playersController.getPlayers();
		assertNotNull(players);
		assertEquals(players.size(),1);
	}
	
	public static Stream<Arguments>addPlayerDataProvider(){
		return Stream.of(
					Arguments.of("Declan Rice",185,"England","DM")
				);
	}

}
