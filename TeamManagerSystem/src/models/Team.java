package models;
import java.util.ArrayList;
import java.util.List;

import person.Coach;
import person.Footballer;
import person.Owner;
import person.Sponsor;
import person.TeamManager;
/**
 * This is the model of the team.
 * It holds the properties of team players, team name, coach name, owner,manager and sponsor.
 * The player class provides methods to get owner, team manager, list of coaches and sponsors. 
 * @author Selina Yu
 * @since 2021-11-06
 */
public class Team {
	// Field
	private ArrayList<Player> teamPlayers = new ArrayList<>();
	private String teamName;
	private String coachName;
	
	private Owner owner;
	private TeamManager manager;
	private List<Footballer> footballers = new ArrayList<>();
	private List<Coach>coaches = new ArrayList<>();
	private List<Sponsor>sponsors = new ArrayList<>();
	private boolean isValidLineUp;

	/**
	 * Constructor - construct a new team with the given team name and coach name
	 * @param teamName
	 * @param coachName
	 */
	public Team(String teamName, String coachName) {
		this.teamName = teamName;
		this.coachName = coachName;
	}

	/**
	 * Accessor- method to get list of team players
	 * @return the list of players for the team
	 **/
	public ArrayList<Player> getTeamPlayers() {
		return new ArrayList<Player>(teamPlayers);
	}

	/**
	 * Mutator - method to set list of team player
	 * @param the list of players for the team
	 */
	public void setTeamPlayers(ArrayList<Player> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

    /**
     * Accessor - method to get team name
     * @return team name
     */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * Mutator - method to set team name with given team name
	 * @param teamName
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	/**
	 * Accessor - method to get coach name
	 * @return coach name
	 */
	public String getCoachName() {
		return coachName;
	}
	/**
	 * Mutator - method to set coach name with given coach name
	 * @param coach name
	 */
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	/**
	 * method to add a player to the list of players
	 * @param players
	 */
	public void addPlayer(Player p) {
		teamPlayers.add(p);
	}
	/**
	 * Constructor - construct a new team with the given owner object
	 * @param teamName
	 * @param coachName
	 */
	public Team(Owner owner) {
		this.owner = owner;
		this.manager = this.owner.getManagerHired();
		this.footballers = this.manager.getPlayers();
		this.coaches = this.manager.getCoaches();
	}
	/**
	 * method to add a sponsor to the list of sponsors
	 * @param Sponsor
	 */
	public void addSponsor(Sponsor s) {
		sponsors.add(s);
	}
	/**
	 * Accessor - method to get owner 
	 * @return owner
	 */
	public Owner getOwner() {
		return owner;
	}
	/**
	 * Mutator - method to set owner by given owner object
	 * @param coach name
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	/**
	 * Accessor - method to get manager 
	 * @return manager
	 */
	public TeamManager getManager() {
		return manager;
	}
	/**
	 * Mutator - method to set manager by given manager object
	 * @param manager name
	 */
	public void setManager(TeamManager manager) {
		this.manager = manager;
	}
	/**
	 * Accessor - method to get list of footballers 
	 * @return list of footballers
	 */
	public List<Footballer> getFootballer() {
		return footballers;
	}
	/**
	 * Mutator - method to set list of footballers 
     * @return list of footballers
	 */
	public void setFootballers(List<Footballer> footballers) {
		this.footballers = footballers;
	}
	/**
	 * Accessor - method to get list of coaches
	 * @return list of coaches
	 */
	public List<Coach> getCoaches() {
		return coaches;
	}
	/**
	 * Mutator - method to set list of coaches 
     * @return list of coaches
	 */
	public void setCoaches(List<Coach> coaches) {
		this.coaches = coaches;
	}
	/**
	 * Accessor - method to get list of sponsors 
	 * @return list of sponsors 
	 */
	public List<Sponsor> getSponsors() {
		return sponsors;
	}
	/**
	 * Mutator - method to set list of sponsors 
     * @return list of sponsors
	 */
	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

    /**
     * Method to get the value of isValidLineup
     * @return isValidLineUp
     */
	public boolean getIsValidLineUp() {
		return this.isValidLineUp;
	}

	/**
	 * Method to check whether team lineup is valid or not
	 * @param isValidLineUp
	 */
	public void setIsValidLineUp(boolean isValidLineUp) {
		this.isValidLineUp = isValidLineUp;
	}

}
