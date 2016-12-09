package pl.kielce.tu.kronos.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindow {

	public Button tempButton;

	public Parent root;
	public Scene scene;
	public Stage stage;

	public Parent getRoot() {
		return root;
	}

	public void setRoot(String fileFXML) throws IOException {
		
		this.root = FXMLLoader.load(getClass().getResource("/resources/fxml/" + fileFXML + ".fxml"));
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Parent root, int width, int height) {
		this.scene = new Scene(root, width, height);
		this.scene.getStylesheets().add(getClass().getResource("/resources/stylesheet/Stylesheet.css").toString());
	}

	public Stage getStage() {
		return stage;
	}

	public void setStageFromPrimaryStage(Stage primaryStage) {
		this.stage = primaryStage;
	}

	public void setStage(String title) {
		this.stage.setTitle(title);
		this.stage.setScene(getScene());

		/*
		stage.setOnCloseRequest(e -> {
			e.consume();
			try {
				CloseWindow.display();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}); */

		this.stage.centerOnScreen();
		this.stage.show();
		this.stage.setResizable(false);

	}

	public void changeStage(String title, String fileFXML, int width, int height) throws IOException {
		setRoot(fileFXML);
		setScene(getRoot(), width, height);
		setStage(title);
	}

	public void setTemp(ActionEvent e) {
		this.tempButton = (Button) e.getSource();
	}

	public void setNewStage() {
		this.stage = (Stage) this.tempButton.getScene().getWindow();
	}

}
