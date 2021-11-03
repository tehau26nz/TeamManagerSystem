package person;

import java.util.HashSet;
import java.util.Set;

import utils.Team;

public class Owner extends Person{

	private Team teamOwned;
	private TeamManager managerHired;
	

	/**
	 * 
	 * @param team
	 */
	public Owner(Team team) {
		super();
		this.teamOwned = team;
	}

	public Team getTeamOwned() {
		return teamOwned;
	}

	public void setTeamOwned(Team teamOwned) {
		this.teamOwned = teamOwned;
	}

	public TeamManager getManagerHired() {
		return managerHired;
	}

	public void setManagerHired(TeamManager managerHired) {
		this.managerHired = managerHired;
	}

	public void makePayment() {
		
	}

}