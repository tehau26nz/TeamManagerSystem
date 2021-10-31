package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class DashboardController implements Initializable {
@FXML Button btnEvents;
@FXML Button btnteams;
	
	public void handleButtonClicks(Event mouseEvent) {
		if(mouseEvent.getSource() == btnEvents) {
			loadStages("UI_Events.fxml");
		}else if(mouseEvent.getSource() == btnteams){
			loadStages("Teams.fxml");
		}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private void loadStages(String fxml) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Teams.fxml"));
			Stage stage = new Stage();
			Image icon = new Image("football_color_icon.png");
			stage.getIcons().add(icon);
			stage.setScene(new Scene(root));
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
