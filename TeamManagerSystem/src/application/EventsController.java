package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class EventsController implements Initializable {

	@FXML private TableView<TeamEvent> tableView;
	@FXML private TableColumn<TeamEvent,String> eventNameCol;
	@FXML private TableColumn<TeamEvent,String> eventLocationCol;
	@FXML private TableColumn<TeamEvent,String> eventDateCol;
	
	private ObservableList<TeamEvent> events = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		eventNameCol.setCellValueFactory(new PropertyValueFactory<TeamEvent,String>("eventName"));
		eventLocationCol.setCellValueFactory(new PropertyValueFactory<TeamEvent,String>("eventLocation"));
		eventDateCol.setCellValueFactory(new PropertyValueFactory<TeamEvent,String>("eventDate"));
		
		tableView.setItems(events);
		events.add(new TeamEvent("Pheonix vs Tiger","Wellington","2021-11-09"));
		events.add(new TeamEvent("Pheonix vs Tiger","Wellington","2021-11-21"));
		events.add(new TeamEvent("Pheonix vs Tiger","Wellington","2021-12-09"));
	}
	
	
	
	
	public static class TeamEvent {
		private SimpleStringProperty eventName,eventLocation,eventDate;
		
		public TeamEvent(String name,String location, String date) {
			this.eventName =  new SimpleStringProperty(name);
			this.eventLocation = new SimpleStringProperty(location);
			this.eventDate =new SimpleStringProperty(date);
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

}
