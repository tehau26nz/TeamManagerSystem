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
import javafx.stage.Stage;


public class IntroController implements Initializable {
	@FXML Button btnSkiptheIntro;
	
	
	public void handleSkiptheIntroButtonClick(Event mouseEvent) {
		if(mouseEvent.getSource() == btnSkiptheIntro) {
			loadStages("UI_Dashboard.fxml");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private void loadStages(String fxml) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
