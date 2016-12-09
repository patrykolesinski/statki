package pl.kielce.tu.kronos.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.kielce.tu.kronos.database.HighScore;
import pl.kielce.tu.kronos.database.HighScores;
import pl.kielce.tu.kronos.logic.Model;

public class ControllerHighScore extends MainWindow implements Initializable {

	@FXML
	TableView<HighScore> tableHighScore;

	@FXML
	TableColumn<HighScore, Integer> columnPosition;

	@FXML
	TableColumn<HighScore, String> columnNick;

	@FXML
	TableColumn<HighScore, Integer> columnWonGames;

	public void goToStartGame(ActionEvent event) {

		System.out.println("Przeszlem");
		try {
			setTemp(event);
			setNewStage();
			changeStage("Ships", "SignIn", 600, 460);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Cos sie spier... popsulo :");
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Jestem ladny");
		columnPosition.setCellValueFactory(new PropertyValueFactory<>("number"));
		columnNick.setCellValueFactory(new PropertyValueFactory<>("nick"));
		columnWonGames.setCellValueFactory(new PropertyValueFactory<>("wins"));
		tableHighScore.setItems(getHighScore());
		Model.connect.disconnectWithServer();
	}

	public ObservableList<HighScore> getHighScore() {
		HighScores highScores = null;
		ObservableList<HighScore> highScore = FXCollections.observableArrayList();
		try {
			highScores = Model.connect.getHighScores();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (highScores != null) {
			System.out.println("PRZED ITERATOREM\n");
			Iterator<HighScore> it = highScores.getHsArray().iterator();
			HighScore h;
			while (it.hasNext()) {

				h = it.next();
				highScore.add(h);
				System.out.println(h.getNumber() + "   " + h.getNick() + "   " + h.getWins());
				// h.getWins());
			}
			System.out.println("Po iteratorze\n");

		} else {
			System.out.println("Jestem nullem");
			System.out.println();
		}

		return highScore;

	}

}
