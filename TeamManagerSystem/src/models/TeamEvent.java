package models;

import javafx.beans.property.SimpleStringProperty;

public class TeamEvent {
	private SimpleStringProperty eventName, eventLocation, eventDate;

	public TeamEvent(String name, String location, String date) {
		this.eventName = new SimpleStringProperty(name);
		this.eventLocation = new SimpleStringProperty(location);
		this.eventDate = new SimpleStringProperty(date);
	}

	public String getEventDate() {
		return eventDate.get();
	}

	public void setEventDate(SimpleStringProperty eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventLocation() {
		return eventLocation.get();
	}

	public void setEventLocation(SimpleStringProperty eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventName() {
		return eventName.get();
	}

	public void setEventName(SimpleStringProperty eventName) {
		this.eventName = eventName;
	}
}
