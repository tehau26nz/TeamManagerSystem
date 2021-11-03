package person;

public class Agent extends Person{

	private Footballer playerManaged;
	private Sponsor sponsorshipCollabrated;

	public Agent(Footballer playerManaged) {
		super();
		this.playerManaged = playerManaged;
	}

	public Footballer getPlayerManaged() {
		return playerManaged;
	}

	public void setPlayerManaged(Footballer playerManaged) {
		this.playerManaged = playerManaged;
	}

	public Sponsor getSponsorshipCollabrated() {
		return sponsorshipCollabrated;
	}

	public void setSponsorshipCollabrated(Sponsor sponsorshipCollabrated) {
		this.sponsorshipCollabrated = sponsorshipCollabrated;
	}

	public void acceptTeamOffer() {
		// TODO - implement Agent.acceptTeamOffer
		throw new UnsupportedOperationException();
	}

	public void acceptSponsorship() {
		// TODO - implement Agent.acceptSponsorship
		throw new UnsupportedOperationException();
	}

	public void resign() {
		// TODO - implement Agent.resign
		throw new UnsupportedOperationException();
	}

}