package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class FunStuff implements Initializable {

	private Main application;
	
	public void setApp(Main application){
        this.application = application;
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Initialize
	}
	
	// Back Button
	public void back(ActionEvent event) {
		application.gotoDemo();
	}

}
