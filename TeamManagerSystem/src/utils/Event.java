package utils;

import java.sql.Time;
import java.util.Date;

import person.Sponsor;

public class Event {

	private Date date;
	private Time time;
	private String place;
	private String teamHome;
	private String teamAway;
	private Sponsor sponsors;
	private int goalHomeTeam;
	private int goalAwayTeam;
	private int stadiumCapacity;
	private int ticketSold;
	
	public Event(Date date, String teamHome, String teamAway) {
		super();
		this.date = date;
		this.teamHome = teamHome;
		this.teamAway = teamAway;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTeamHome() {
		return teamHome;
	}

	public void setTeamHome(String teamHome) {
		this.teamHome = teamHome;
	}

	public String getTeamAway() {
		return teamAway;
	}

	public void setTeamAway(String teamAway) {
		this.teamAway = teamAway;
	}

	public Sponsor getSponsors() {
		return sponsors;
	}

	public void setSponsors(Sponsor sponsors) {
		this.sponsors = sponsors;
	}

	public int getGoalHomeTeam() {
		return goalHomeTeam;
	}

	public void setGoalHomeTeam(int goalHomeTeam) {
		this.goalHomeTeam = goalHomeTeam;
	}

	public int getGoalAwayTeam() {
		return goalAwayTeam;
	}

	public void setGoalAwayTeam(int goalAwayTeam) {
		this.goalAwayTeam = goalAwayTeam;
	}

	public int getStadiumCapacity() {
		return stadiumCapacity;
	}

	public void setStadiumCapacity(int stadiumCapacity) {
		this.stadiumCapacity = stadiumCapacity;
	}

	public int getTicketSold() {
		return ticketSold;
	}

	public void setTicketSold(int ticketSold) {
		this.ticketSold = ticketSold;
	}

}