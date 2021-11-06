package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import models.Player;
import models.Team;
/**
 * This class is designed to work with data.
 * Currently it is only used to load data into model from text file.
 * In the future it could be used to connect to database.
 * @author Selina Yu
 * @since 2021-11-01
 */
public class DataHelper {
	/**
	 * List of team objects
	 */
	private ArrayList<Team> teams = new ArrayList<Team>();
	/**
	 * List of team names
	 */
	private ArrayList<String> teamnames = new ArrayList<String>();
	/**
	 * Constructor - create a new DataHelper object with given data source file
	 * @param fileName
	 */
	public DataHelper(String fileName) {
		setTeams(fileName);
		setTeamnames();
	}
	/**
     * Accessor - method to get list of teams
     * @return list of teams
     */
	public ArrayList<Team> getTeams() {
		return teams;
	}
	/**
	 * Mutator - method to set list of teams with loading team data from text file
	 * @param file name
	 */
	public void setTeams(String fileName) {
		this.loadFile(fileName);
	}
	/**
	 * load team and player data from  the teams.txt file
	 * @param fileName
	 */
	public void loadFile(String filename) {
		try {
			Scanner scan = new Scanner(new File(filename));
			while (scan.hasNext()) {
				String teamName = scan.nextLine().trim();
				String coachName = scan.nextLine().trim();
				Team t = new Team(teamName, coachName);
				teams.add(t);

				int numOfPlayers = scan.nextInt();
				scan.nextLine();

				for (int i = 0; i < numOfPlayers; i++) {
					String positions = scan.next();
					String[] pos = positions.split(",");

					String name = scan.nextLine().substring(1);

					int height = scan.nextInt();
					scan.nextLine();

					String birthplace = scan.nextLine();
					Player p = new Player(name, height, birthplace, pos);
					t.addPlayer(p);
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
     * Accessor - method to get list of team names
     * @return list of team names
     */
	public ArrayList<String> getTeamnames() {
		return teamnames;
	}
	/**
	 * Mutator - method to set list of teams names
	 * @param list of team names
	 */
	public void setTeamnames() {
		for (Team t : teams) {
			teamnames.add(t.getTeamName());
		}
	}
	/**
	 * method to get team object by given team name string
	 * @param teamname
	 * @return team object
	 */
	public Team getTeambyName(String teamname) {
		for (Team t : teams) {
			if(t.getTeamName().equals(teamname)) {
				return t;
			}
		}
		return null;
	}

	public DataHelper(ArrayList<Team> teams, ArrayList<String> teamnames) {
		super();
		this.teams = teams;
		this.teamnames = teamnames;
	}
	
}
