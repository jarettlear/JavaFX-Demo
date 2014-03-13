package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import application.Main;

/**
 * This is a simple demo on difference between loading objects during initialization 
 * and pushing those off to a different thread to load after initialization
 * 
 * @author jlear
 *
 */

public class PreInitializationController implements Initializable {

	// FXML elements
	@FXML private Label label1;
	@FXML private Label label2;
	@FXML private ComboBox<String> box1;
	@FXML private ComboBox<String> box2;
	
	// Non FXML elements
	// Object we want to pass in to the view
	private String text;
	// Application
	private Main application;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Null check for text object
		if (null != text) {
		label1.setText(text);
		} else {
			label1.setText("null");
		}

		box1.setItems(FXCollections.observableArrayList("Box 1 Choice 1","Box 1 Choice 2","Box 1 Choice 3","Box 1 Choice 4"));
		
		// Set the values after initialization
		Platform.runLater(new Runnable() {
			  @Override public void run() { 
				  label2.setText(text);
				  box2.setItems(FXCollections.observableArrayList("Box 2 Choice 1","Box 2 Choice 2","Box 2 Choice 3","Box 2 Choice 4"));
			  }
		});

	}

	public void back(ActionEvent event) {
		application.gotoDemo();
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setApp(Main application) {
        this.application = application;
    }
	
}
