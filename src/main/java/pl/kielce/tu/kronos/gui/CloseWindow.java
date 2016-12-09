package pl.kielce.tu.kronos.gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CloseWindow {

	public static void display() throws IOException {

		Stage window = new Stage();
		window.setResizable(false);

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirm Exit");

		Parent root = FXMLLoader.load(CloseWindow.class.getResource("/fxml/CloseWindow.fxml"));

		Scene scene = new Scene(root, 402, 150);
		scene.getStylesheets().add(CloseWindow.class.getResource("/stylesheet/Stylesheet.css").toString());

		window.setScene(scene);
		window.showAndWait();

	}
}
