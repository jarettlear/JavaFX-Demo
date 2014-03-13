package application;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.controllers.DemoController;
import application.controllers.FunStuff;
import application.controllers.PreInitializationController;
import application.controllers.TransitionController;

public class Main extends Application {

	private Stage stage;

	// Define the views
	private static String DEMO = "resources/fxml/Demo.fxml";
	private static String PRE_INITIALIZATION = "resources/fxml/PreInitialization.fxml";
	private static String TRANSITION = "resources/fxml/TransitionController.fxml";
	private static String FUN_STUFF = "resources/fxml/FunStuff.fxml";

	// Set up the stage and go to the main screen
	@Override
	public void start(Stage primaryStage) {
		try {

			stage = primaryStage;
			stage.setTitle("Demo Application");
			stage.setMinWidth(600);
			stage.setMinHeight(400);

			// Center the window
			stage.centerOnScreen();

			gotoDemo();
			primaryStage.show();

		} catch (Exception e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// Main Screen
	public void gotoDemo() {
		try {
			DemoController demo = (DemoController) replaceSceneContent(DEMO);
			demo.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// Pre Initialization Demo Screen
	public void gotoPreInit(String text) {
		try {
			PreInitializationController initialization = (PreInitializationController) replaceSceneContent(PRE_INITIALIZATION);
			initialization.setText(text);
			initialization.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// Transition Demo Screen
	public void gotoTransition() {
		try {
			TransitionController transition = (TransitionController) replaceSceneContent(TRANSITION);
			transition.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// Fun Stuff Demo Screen
	public void gotoFunStuff() {
		try {
			FunStuff fun = (FunStuff) replaceSceneContent(FUN_STUFF);
			fun.setApp(this);
		} catch (Exception ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// Scene Content Loader controls switching between views
	private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = Main.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(Main.class.getResource(fxml));
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page, 600, 400);

		/**
		 * In some cases style sheets will need to be "preloaded" to work. This
		 * would typically be used to style items used across all the screens,
		 * such as a menu. scene.getStylesheets().add(Main.class.getResource(
		 * "resources/css/main.css").toExternalForm());
		 */

		stage.setScene(scene);
		stage.sizeToScene();
		return (Initializable) loader.getController();
	}

	// Main Method
	public static void main(String[] args) {
		launch(args);
	}
}
