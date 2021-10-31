package application;
import java.util.ArrayList;

public class Team {
	// Field
	private ArrayList<Player> teamPlayers = new ArrayList<>();
	private String teamName;
	private String coachName;

	// Constructor
	public Team(String teamName, String coachName) {
		this.teamName = teamName;
		this.coachName = coachName;
	}

	// Accessor
	public ArrayList<Player> getTeamPlayers() {
		return new ArrayList<Player>(teamPlayers);
	}

	//Set team players
	public void setTeamPlayers(ArrayList<Player> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}


	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	// Method
	public void addPlayer(Player p) {
		teamPlayers.add(p);
	}

}
