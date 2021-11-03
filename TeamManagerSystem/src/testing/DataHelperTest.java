package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import application.DataHelper;
import models.Team;

class DataHelperTest {

	private static ArrayList<Team> teams;
	private static ArrayList<String> teamnames;
	private static DataHelper helper;

	@ParameterizedTest
	@MethodSource("loadFileTestDataProvider")
	public void loadFileTest(String filename) {
		DataHelper helper = new DataHelper(filename);
		ArrayList<Team> teams = helper.getTeams();
		assertNotNull(teams);
		assertEquals(teams.size(), 6);
	}

	public static Stream<Arguments> loadFileTestDataProvider() {
		return Stream.of(Arguments.of("teamsTesting.txt"));
	}

	@ParameterizedTest
	@MethodSource("loadFileTestDataProvider")
	public void getTeamnamesTest(String fileName) {
		DataHelper helper = new DataHelper(fileName);
		ArrayList<String> teamnames = helper.getTeamnames();
		assertNotNull(teamnames);
		assertEquals(teamnames.size(), 6);
		assertEquals(teamnames.get(0),"Chelsea");
		assertEquals(teamnames.get(1),"Arsenal");
		assertEquals(teamnames.get(2),"Manchester City");
		assertEquals(teamnames.get(3),"Liverpool");
		assertEquals(teamnames.get(4),"Tottenham Hotspur");
		assertEquals(teamnames.get(5),"Manchester United");
	}

}
