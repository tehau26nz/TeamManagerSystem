package person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Team;

public class TeamManager extends Person{

	private Team managedTeam;
	private List<Footballer>footballers = new ArrayList<>();
	private List<Coach>coaches = new ArrayList<>();
	

	/**
	 * 
	 * @param team
	 */
	public TeamManager(Team team) {
		this.managedTeam = team;
	}

	public void recruitPlayer(Footballer p) {
		footballers.add(p);
	}
	
	public void hireCoach(Coach c) {
		coaches.add(c);
	}

	public void lineUpForGame() {
		
	}

	public void tradePlayer() {
		
	}

	public void evaluatePlayer() {
		
	}

	public void getManagedTeam() {
		
	}

	/**
	 * 
	 * @param managedTeam
	 */
	public void setManagedTeam(Team managedTeam) {
		this.managedTeam = managedTeam;
	}

	public List<Footballer> getPlayers() {
		return footballers;
	}

	public void setPlayers(List<Footballer> footballers) {
		this.footballers = footballers;
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Coach> coaches) {
		this.coaches = coaches;
	}

}