package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class DemoController implements Initializable {

	private Main application;
	private String text = "This is text passed from one controller to another!";
	
	public void setApp(Main application){
        this.application = application;
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	// Pre Initialization Button Action
	public void preInitialization(ActionEvent event) {
		application.gotoPreInit(text);
	}
	
	// Transition Button Action
	public void transition(ActionEvent event) {
		application.gotoTransition();
	}
	
	// Fun Stuff Button Action
	public void funStuff(ActionEvent event) {
		application.gotoFunStuff();
	}

}
