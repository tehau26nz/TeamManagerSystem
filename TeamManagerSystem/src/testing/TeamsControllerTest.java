package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import application.TeamsController;
import javafx.collections.ObservableList;
import models.Team;

class TeamsControllerTest {
	
	@Test
	public void addTeamTest() {
		TeamsController teamsController = new TeamsController();
		ObservableList<Team> footyTeams = teamsController.getFootyTeams();
		teamsController.addNewTeam("Brighton and Hove Albion","Graham Potter");
		assertEquals(footyTeams.size(), 1);
	}
	
	@Test
	public void getTeamsTest() {
		TeamsController teamsController = new TeamsController();
		Team brighton = new Team("Brighton and Hove Albion","Graham Potter");
		Team leeds = new Team("Leeds United","Marcelo Bielsa");
		List<Team>teams = new ArrayList<>();
		teams.add(brighton);
		teams.add(leeds);
		ObservableList<Team> footyTeams = teamsController.getFootyTeams();
		teamsController.getTeams(teams);
		assertEquals(footyTeams.size(),2);
	}
}
