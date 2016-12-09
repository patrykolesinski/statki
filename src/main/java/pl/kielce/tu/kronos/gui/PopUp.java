package pl.kielce.tu.kronos.gui;

import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp extends MainWindow {

	/**
	 * 
	 * @param numberPopUp
	 *            rodzja wyswietlanego okna
	 * @param title
	 *            tytul wyswietlanego okna
	 * @param description
	 *            opis znajdujacy sie w etykiecie label
	 * @throws IOException
	 */
	public static void display(String data) throws IOException {

		String[] tab = new String[3];
		tab = data.split(":");

		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(tab[1]);
		window.setResizable(false);
		Button closeButton = new Button("Close");
		
		if (tab[0].contentEquals("popUpPaneYou")) {
			closeButton.setText("HighScores");
		}



		Label label = new Label();
		label.setWrapText(true);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setText(tab[2]);
		label.setFont(new Font("Arial", 20));

		// closeButton.setOnAction(e -> window.close());

		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(label, closeButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPrefSize(402, 250);

		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(vBox);

		Pane pane = new Pane();
		pane.setPrefSize(402, 250);
		pane.getChildren().add(hBox);

		System.out.println("tab0: " + tab[0]);
		System.out.println("tab1: " + tab[1]);
		System.out.println("tab2: " + tab[2]);

		
		pane.setId(tab[0]);

		
		closeButton.setOnAction(e -> {
			window.close();
		}); 

		Scene scene = new Scene(pane, 402, 250);
		scene.getStylesheets().add(PopUp.class.getResource("/resources/stylesheet/Stylesheet.css").toString());
		window.setScene(scene);
		window.showAndWait();

	}
}
