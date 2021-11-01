package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.TeamEvent;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class EventsController implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	private TableView<TeamEvent> tableView;
	@FXML
	private TableColumn<TeamEvent, String> eventNameCol;
	@FXML
	private TableColumn<TeamEvent, String> eventLocationCol;
	@FXML
	private TableColumn<TeamEvent, String> eventDateCol;

	@FXML
	private TextField addEventName;
	@FXML
	private TextField addEventLocation;
	@FXML
	private TextField addEventDate;
	@FXML
	private Button btnAddEvent;
	@FXML
	private Button btnDeleteEvent;

	private ObservableList<TeamEvent> events = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		eventNameCol.setCellValueFactory(new PropertyValueFactory<TeamEvent, String>("eventName"));
		eventLocationCol.setCellValueFactory(new PropertyValueFactory<TeamEvent, String>("eventLocation"));
		eventDateCol.setCellValueFactory(new PropertyValueFactory<TeamEvent, String>("eventDate"));

		tableView.setItems(events);
		events.add(new TeamEvent("Pheonix vs Tiger", "Wellington", "2021-11-09"));
		events.add(new TeamEvent("Pheonix vs Tiger", "Wellington", "2021-11-21"));
		events.add(new TeamEvent("Pheonix vs Tiger", "Wellington", "2021-12-09"));
		
		//League manager only allows to view teams
		if(LoginSelectionController.managerAccessLevel.equals("teamManager")) {
			btnAddEvent.setVisible(false);
			btnDeleteEvent.setVisible(false);
			addEventName.setVisible(false);
			addEventLocation.setVisible(false);
			addEventDate.setVisible(false);
		}else {
			btnAddEvent.setVisible(true);
			btnDeleteEvent.setVisible(true);
			addEventName.setVisible(true);
			addEventLocation.setVisible(true);
			addEventDate.setVisible(true);
		}
	}

	/**
	 * Allow users to add events
	 * 
	 * @param e
	 */
	@FXML
	public void handleButtonAction(Event e) {
		events.add(new TeamEvent(addEventName.getText(), addEventLocation.getText(), addEventDate.getText()));

		addEventName.clear();
		addEventLocation.clear();
		addEventDate.clear();
	}

	/**
	 * Allow users to delete the selected event
	 * 
	 * @param e
	 */
	@FXML
	public void deleteRowFromTableViewAction(Event e) {
		tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
	}

	/**
	 * Allow users to delete the selected event
	 * 
	 * @param e
	 */
	@FXML
	public void switchToPrevious(Event e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/layouts/Dashboard.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
