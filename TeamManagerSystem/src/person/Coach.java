package person;
import utils.Team;

public class Coach extends Person{

	private TeamManager reportingManager;
	private Team Team;

	/**
	 * 
	 * @param team
	 */
	public Coach(Team team) {
		// TODO - implement Coach.Coach
		throw new UnsupportedOperationException();
	}
		

	public TeamManager getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(TeamManager reportingManager) {
		this.reportingManager = reportingManager;
	}

	public Team getTeam() {
		return Team;
	}

	public void setTeam(Team team) {
		Team = team;
	}

	public void addTraining() {
		// TODO - implement Coach.addTraining
		throw new UnsupportedOperationException();
	}

	public void addPhoto() {
		// TODO - implement Coach.addPhoto
		throw new UnsupportedOperationException();
	}

	public void addVideo() {
		// TODO - implement Coach.addVideo
		throw new UnsupportedOperationException();
	}

	public void recordAttendency() {
		// TODO - implement Coach.recordAttendency
		throw new UnsupportedOperationException();
	}

}