package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import application.Main;

public class TransitionController implements Initializable {

	@FXML HBox drawer;
	@FXML VBox opacityOverlay;
	@FXML VBox overlay;
	@FXML Button nothing;
	@FXML Button opacity;
	
	private Timeline timeline;
	private Duration duration = Duration.seconds(0.4);
	
	private Main application;
	
	public void setApp(Main application){
        this.application = application;
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	// Overlay Animation
	public void overlayButton(ActionEvent event) {
		
		timeline = new Timeline();
		
		if (!overlay.isVisible()) {
		
			opacityOverlay.setVisible(true);
			overlay.setVisible(true);
			KeyValue overlayShow = new KeyValue(overlay.opacityProperty(), 1);
			KeyValue opacityOverlayShow = new KeyValue(opacityOverlay.opacityProperty(), .8);
			KeyFrame keyFrame = new KeyFrame(duration, overlayShow, opacityOverlayShow);
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
		
		} else {

			KeyValue overlayHide = new KeyValue(overlay.opacityProperty(), 0);
			KeyValue opacityOverlayHide = new KeyValue(opacityOverlay.opacityProperty(), 0);
			EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent t) {
	            	opacityOverlay.setVisible(false);
	    			overlay.setVisible(false);
	            }
	        };
			KeyFrame keyFrame = new KeyFrame(duration, onFinished, overlayHide, opacityOverlayHide);
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
			
		}
	}
	
	
	public void opacityButton(ActionEvent event) {
		
		if (opacity.getOpacity() >= 1) {
			opacity.setOpacity(.1);
		} else {
			opacity.setOpacity(opacity.getOpacity() + 0.1);
		}
		
	}

	// Drawer Animation
	public void drawerButton(ActionEvent event) {
		
		timeline = new Timeline();
		
		if (drawer.getPrefHeight() > 0) {
			
			KeyValue drawerShow = new KeyValue(drawer.prefHeightProperty(), 0);
			EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent t) {
	            	nothing.setVisible(false);
	            }
	        };
	        KeyFrame keyFrame = new KeyFrame(duration, onFinished, drawerShow);
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
		
		} else {
			nothing.setVisible(true);
			KeyValue drawerHide = new KeyValue(drawer.prefHeightProperty(), 100);
			KeyFrame keyFrame = new KeyFrame(duration, drawerHide);
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
			
		}
		
	}
	
	public void back(ActionEvent event) {
		application.gotoDemo();
	}
	
}
