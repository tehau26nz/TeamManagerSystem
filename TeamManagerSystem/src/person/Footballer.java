package person;

import utils.Team;

public class Footballer extends Person{

	private String name;
	private String birthPlace;
	private int height;
	private String[] position;
	private Team teamSigned;
	private Agent agentSigned;
	
	public Footballer(String name, String birthPlace, int height, String[] position) {
		super();
		this.name = name;
		this.birthPlace = birthPlace;
		this.height = height;
		this.position = position;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthPlace() {
		return birthPlace;
	}


	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String[] getPosition() {
		return position;
	}


	public void setPosition(String[] position) {
		this.position = position;
	}


	public Team getTeamSigned() {
		return teamSigned;
	}


	public void setTeamSigned(Team teamSigned) {
		this.teamSigned = teamSigned;
	}


	public Agent getAgentSigned() {
		return agentSigned;
	}


	public void setAgentSigned(Agent agentSigned) {
		this.agentSigned = agentSigned;
	}


	public void hireAgent() {
		// TODO - implement Footballer.hireAgent
		throw new UnsupportedOperationException();
	}

	public void attendTraining() {
		// TODO - implement Footballer.attendTraining
		throw new UnsupportedOperationException();
	}

	public void shootCommercial() {
		// TODO - implement Footballer.shootCommercial
		throw new UnsupportedOperationException();
	}

	public void cancelAgency() {
		// TODO - implement Footballer.cancelAgency
		throw new UnsupportedOperationException();
	}

	
}