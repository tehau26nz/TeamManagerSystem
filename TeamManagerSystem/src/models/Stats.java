package models;

import javafx.beans.property.SimpleStringProperty;

public class Stats {
	private Integer rank;
	private SimpleStringProperty club;
	private Integer win, draw,loss,points;
	
	public Stats(int rank, String club,int win,int draw,int loss,int points) {
		this.rank =rank;
		this.club =new SimpleStringProperty(club);
		this.draw =draw;
		this.win =win;
		this.loss =loss;
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
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getLoss() {
		return loss;
	}
	public void setLoss(Integer loss) {
		this.loss = loss;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getWin() {
		return win;
	}
	public void setWin(Integer win) {
		this.win = win;
	}
}
