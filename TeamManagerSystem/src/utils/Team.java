package utils;

import java.util.ArrayList;
import java.util.List;

import person.Coach;
import person.Footballer;
import person.Owner;
import person.Sponsor;
import person.TeamManager;

public class Team {

	private Owner owner;
	private TeamManager manager;
	private List<Footballer>footballers = new ArrayList<>();
	private List<Coach>coaches = new ArrayList<>();
	private List<Sponsor>sponsors = new ArrayList<>();
	private boolean isValidLineUp;
	
	public Team(Owner owner) {
		this.owner = owner;
		this.manager = this.owner.getManagerHired();
		this.footballers = this.manager.getPlayers();
		this.coaches = this.manager.getCoaches();
	}
	
	public void addSponsor(Sponsor s) {
		sponsors.add(s);
	}
	

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public TeamManager getManager() {
		return manager;
	}

	public void setManager(TeamManager manager) {
		this.manager = manager;
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

	public List<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public void setValidLineUp(boolean isValidLineUp) {
		this.isValidLineUp = isValidLineUp;
	}

	public boolean getIsValidLineUp() {
		return this.isValidLineUp;
	}

	/**
	 * 
	 * @param isValidLineUp
	 */
	public void setIsValidLineUp(boolean isValidLineUp) {
		this.isValidLineUp = isValidLineUp;
	}

}