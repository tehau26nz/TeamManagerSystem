package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Player;
import models.Team;


//nz.ac.wgtn.teammanager.ui
//nz.ac.wgtn.teammanager.models
//nz.ac.wgtn.teammanager.controllers
//nz.ac.wgtn.teammanager.tests

/**
 * This class is designed to work with data.
 * Currently it is only used to load data from text file.
 * @author Selina
 * @version 1.0
 * @since 2021-11-01
 */
public class DataHelper {
	private ArrayList<Team> teams = new ArrayList<Team>();
	private ArrayList<String> teamnames = new ArrayList<String>();
	
	public DataHelper(String fileName) {
		setTeams(fileName);
		setTeamnames();
	}

	public ArrayList<Team> getTeams() {
		System.out.println(teams.size());
		return teams;
	}

	/*load teams from  the teams.txt file*/
	public void setTeams(String fileName) {
		this.loadFile(fileName);
	}
	
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

	public ArrayList<String> getTeamnames() {
		return teamnames;
	}

	public void setTeamnames() {
		for (Team t : teams) {
			teamnames.add(t.getTeamName());
		}
	}
	
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
