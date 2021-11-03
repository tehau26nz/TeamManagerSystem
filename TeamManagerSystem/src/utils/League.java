package utils;

import java.util.ArrayList;

import person.LeagueManager;

public class League {

	private LeagueManager leagueManager;
	private ArrayList<Team> teams;
	
	public League(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	public League(LeagueManager leagueManager) {
		super();
		this.leagueManager = leagueManager;
	}



	public LeagueManager getLeagueManager() {
		return leagueManager;
	}

	public void setLeagueManager(LeagueManager leagueManager) {
		this.leagueManager = leagueManager;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
}
