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
public class DataHelper {
	private List<Team> teams = new ArrayList<Team>();
	
//	public DataHelper() {
//		setTeams();
//	}

	public List<Team> getTeams() {
		return teams;
	}

	/*Needs a teams.txt file in the project before uncommenting*/
//	public void setTeams() {
//		this.loadFile();
//	}
	
//	public void loadFile() {
//		try {
//			Scanner scan = new Scanner(new File("teams.txt"));
//			while (scan.hasNext()) {
//				String teamName = scan.nextLine().trim();
//				String coachName = scan.nextLine().trim();
//				Team t = new Team(teamName, coachName);
//				teams.add(t);
//
//				int numOfPlayers = scan.nextInt();
//				scan.nextLine();
//
//				for (int i = 0; i < numOfPlayers; i++) {
//					String positions = scan.next();
//					String[] pos = positions.split(",");
//
//					String name = scan.nextLine().substring(1);
//
//					int height = scan.nextInt();
//					scan.nextLine();
//
//					String birthplace = scan.nextLine();
//					Player p = new Player(name, height, birthplace, pos);
//					t.addPlayer(p);
//				}
//			}
//			scan.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
}
