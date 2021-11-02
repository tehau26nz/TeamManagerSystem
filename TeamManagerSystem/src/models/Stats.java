package models;

import javafx.beans.property.SimpleStringProperty;

public class Stats {
	private Integer rank;
	private SimpleStringProperty club;
	private Integer won,drawn,lost,points;
	
	public Stats(int rank, String club,int won,int drawn,int lost,int points) {
		this.rank =rank;
		this.club = new SimpleStringProperty(club);
		this.drawn =drawn;
		this.won =won;
		this.lost =lost;
		this.points =points;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getClub() {
		return club.get();
	}
	public void setClub(SimpleStringProperty club) {
		this.club = club;
	}
	public Integer getDrawn() {
		return drawn;
	}
	public void setDraw(Integer drawn) {
		this.drawn = drawn;
	}
	public Integer getLost() {
		return lost;
	}
	public void setLost(Integer lost) {
		this.lost = lost;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getWon() {
		return won;
	}
	public void setWon(Integer won) {
		this.won = won;
	}
}
