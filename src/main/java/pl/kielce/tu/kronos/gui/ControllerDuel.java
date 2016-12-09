package pl.kielce.tu.kronos.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.TextFlow;
import pl.kielce.tu.kronos.logic.Const;
import pl.kielce.tu.kronos.logic.Model;
import pl.kielce.tu.kronos.logic.ShipsLogic;

public class ControllerDuel extends MainWindow implements Initializable {

	@FXML
	private Label ture;

	@FXML
	private ImageView ownShip00, ownShip10, ownShip20, ownShip30, ownShip40, ownShip50, ownShip60, ownShip70, ownShip80,
			ownShip90, ownShip01, ownShip11, ownShip21, ownShip31, ownShip41, ownShip51, ownShip61, ownShip71,
			ownShip81, ownShip91, ownShip02, ownShip12, ownShip22, ownShip32, ownShip42, ownShip52, ownShip62,
			ownShip72, ownShip82, ownShip92, ownShip03, ownShip13, ownShip23, ownShip33, ownShip43, ownShip53,
			ownShip63, ownShip73, ownShip83, ownShip93, ownShip04, ownShip14, ownShip24, ownShip34, ownShip44,
			ownShip54, ownShip64, ownShip74, ownShip84, ownShip94, ownShip05, ownShip15, ownShip25, ownShip35,
			ownShip45, ownShip55, ownShip65, ownShip75, ownShip85, ownShip95, ownShip06, ownShip16, ownShip26,
			ownShip36, ownShip46, ownShip56, ownShip66, ownShip76, ownShip86, ownShip96, ownShip07, ownShip17,
			ownShip27, ownShip37, ownShip47, ownShip57, ownShip67, ownShip77, ownShip87, ownShip97, ownShip08,
			ownShip18, ownShip28, ownShip38, ownShip48, ownShip58, ownShip68, ownShip78, ownShip88, ownShip98,
			ownShip09, ownShip19, ownShip29, ownShip39, ownShip49, ownShip59, ownShip69, ownShip79, ownShip89,
			ownShip99;

	@FXML
	private ImageView enemyShip00, enemyShip10, enemyShip20, enemyShip30, enemyShip40, enemyShip50, enemyShip60,
			enemyShip70, enemyShip80, enemyShip90, enemyShip01, enemyShip11, enemyShip21, enemyShip31, enemyShip41,
			enemyShip51, enemyShip61, enemyShip71, enemyShip81, enemyShip91, enemyShip02, enemyShip12, enemyShip22,
			enemyShip32, enemyShip42, enemyShip52, enemyShip62, enemyShip72, enemyShip82, enemyShip92, enemyShip03,
			enemyShip13, enemyShip23, enemyShip33, enemyShip43, enemyShip53, enemyShip63, enemyShip73, enemyShip83,
			enemyShip93, enemyShip04, enemyShip14, enemyShip24, enemyShip34, enemyShip44, enemyShip54, enemyShip64,
			enemyShip74, enemyShip84, enemyShip94, enemyShip05, enemyShip15, enemyShip25, enemyShip35, enemyShip45,
			enemyShip55, enemyShip65, enemyShip75, enemyShip85, enemyShip95, enemyShip06, enemyShip16, enemyShip26,
			enemyShip36, enemyShip46, enemyShip56, enemyShip66, enemyShip76, enemyShip86, enemyShip96, enemyShip07,
			enemyShip17, enemyShip27, enemyShip37, enemyShip47, enemyShip57, enemyShip67, enemyShip77, enemyShip87,
			enemyShip97, enemyShip08, enemyShip18, enemyShip28, enemyShip38, enemyShip48, enemyShip58, enemyShip68,
			enemyShip78, enemyShip88, enemyShip98, enemyShip09, enemyShip19, enemyShip29, enemyShip39, enemyShip49,
			enemyShip59, enemyShip69, enemyShip79, enemyShip89, enemyShip99;

	@FXML
	private Button enemyShipButton00, enemyShipButton10, enemyShipButton20, enemyShipButton30, enemyShipButton40,
			enemyShipButton50, enemyShipButton60, enemyShipButton70, enemyShipButton80, enemyShipButton90,
			enemyShipButton01, enemyShipButton11, enemyShipButton21, enemyShipButton31, enemyShipButton41,
			enemyShipButton51, enemyShipButton61, enemyShipButton71, enemyShipButton81, enemyShipButton91,
			enemyShipButton02, enemyShipButton12, enemyShipButton22, enemyShipButton32, enemyShipButton42,
			enemyShipButton52, enemyShipButton62, enemyShipButton72, enemyShipButton82, enemyShipButton92,
			enemyShipButton03, enemyShipButton13, enemyShipButton23, enemyShipButton33, enemyShipButton43,
			enemyShipButton53, enemyShipButton63, enemyShipButton73, enemyShipButton83, enemyShipButton93,
			enemyShipButton04, enemyShipButton14, enemyShipButton24, enemyShipButton34, enemyShipButton44,
			enemyShipButton54, enemyShipButton64, enemyShipButton74, enemyShipButton84, enemyShipButton94,
			enemyShipButton05, enemyShipButton15, enemyShipButton25, enemyShipButton35, enemyShipButton45,
			enemyShipButton55, enemyShipButton65, enemyShipButton75, enemyShipButton85, enemyShipButton95,
			enemyShipButton06, enemyShipButton16, enemyShipButton26, enemyShipButton36, enemyShipButton46,
			enemyShipButton56, enemyShipButton66, enemyShipButton76, enemyShipButton86, enemyShipButton96,
			enemyShipButton07, enemyShipButton17, enemyShipButton27, enemyShipButton37, enemyShipButton47,
			enemyShipButton57, enemyShipButton67, enemyShipButton77, enemyShipButton87, enemyShipButton97,
			enemyShipButton08, enemyShipButton18, enemyShipButton28, enemyShipButton38, enemyShipButton48,
			enemyShipButton58, enemyShipButton68, enemyShipButton78, enemyShipButton88, enemyShipButton98,
			enemyShipButton09, enemyShipButton19, enemyShipButton29, enemyShipButton39, enemyShipButton49,
			enemyShipButton59, enemyShipButton69, enemyShipButton79, enemyShipButton89, enemyShipButton99;

	@FXML
	public Label ownRemainedShips;

	@FXML
	public Label enemySunkShips;

	@FXML
	public Label ownNick;

	@FXML
	public Label enemyNick;

	@FXML
	public ScrollPane scrollPane;

	@FXML
	public TextFlow textFlow;

	public Label getEnemyNick() {
		return enemyNick;
	}

	public void setEnemyNick(Label enemyNick) {
		this.enemyNick = enemyNick;
	}

	public Label getTure() {
		return ture;
	}

	public void setTure(Label ture) {
		this.ture = ture;
	}

	public ShipsLogic shipsLogic;

	private static boolean scrooling = false;

	public static boolean isScrooling() {
		return scrooling;
	}

	public static void setScrooling(boolean scrooling) {
		ControllerDuel.scrooling = scrooling;
	}

	public ScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(ScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public TextFlow getTextFlow() {
		return textFlow;
	}

	public void setTextFlow(TextFlow textFlow) {
		this.textFlow = textFlow;
	}

	public Label getOwnRemainedShips() {
		return ownRemainedShips;
	}

	public void setOwnRemainedShips(Label ownRemainedShips) {
		this.ownRemainedShips = ownRemainedShips;
	}

	public Label getEnemySunkShips() {
		return enemySunkShips;
	}

	public void setEnemySunkShips(Label enemySunkShips) {
		this.enemySunkShips = enemySunkShips;
	}

	public Button[][] enemyButtons;

	private void setEnemyButtonsToTab() {
		enemyButtons = new Button[][] {
				{ enemyShipButton00, enemyShipButton01, enemyShipButton02, enemyShipButton03, enemyShipButton04,
						enemyShipButton05, enemyShipButton06, enemyShipButton07, enemyShipButton08, enemyShipButton09 },
				{ enemyShipButton10, enemyShipButton11, enemyShipButton12, enemyShipButton13, enemyShipButton14,
						enemyShipButton15, enemyShipButton16, enemyShipButton17, enemyShipButton18, enemyShipButton19 },
				{ enemyShipButton20, enemyShipButton21, enemyShipButton22, enemyShipButton23, enemyShipButton24,
						enemyShipButton25, enemyShipButton26, enemyShipButton27, enemyShipButton28, enemyShipButton29 },
				{ enemyShipButton30, enemyShipButton31, enemyShipButton32, enemyShipButton33, enemyShipButton34,
						enemyShipButton35, enemyShipButton36, enemyShipButton37, enemyShipButton38, enemyShipButton39 },
				{ enemyShipButton40, enemyShipButton41, enemyShipButton42, enemyShipButton43, enemyShipButton44,
						enemyShipButton45, enemyShipButton46, enemyShipButton47, enemyShipButton48, enemyShipButton49 },
				{ enemyShipButton50, enemyShipButton51, enemyShipButton52, enemyShipButton53, enemyShipButton54,
						enemyShipButton55, enemyShipButton56, enemyShipButton57, enemyShipButton58, enemyShipButton59 },
				{ enemyShipButton60, enemyShipButton61, enemyShipButton62, enemyShipButton63, enemyShipButton64,
						enemyShipButton65, enemyShipButton66, enemyShipButton67, enemyShipButton68, enemyShipButton69 },
				{ enemyShipButton70, enemyShipButton71, enemyShipButton72, enemyShipButton73, enemyShipButton74,
						enemyShipButton75, enemyShipButton76, enemyShipButton77, enemyShipButton78, enemyShipButton79 },
				{ enemyShipButton80, enemyShipButton81, enemyShipButton82, enemyShipButton83, enemyShipButton84,
						enemyShipButton85, enemyShipButton86, enemyShipButton87, enemyShipButton88, enemyShipButton89 },
				{ enemyShipButton90, enemyShipButton91, enemyShipButton92, enemyShipButton93, enemyShipButton94,
						enemyShipButton95, enemyShipButton96, enemyShipButton97, enemyShipButton98,
						enemyShipButton99 } };
		shipsLogic.enemyButtons = enemyButtons;
	}

	private void setImagesToTab() {
		shipsLogic.ownImages = new ImageView[][] {
				{ ownShip00, ownShip01, ownShip02, ownShip03, ownShip04, ownShip05, ownShip06, ownShip07, ownShip08,
						ownShip09 },
				{ ownShip10, ownShip11, ownShip12, ownShip13, ownShip14, ownShip15, ownShip16, ownShip17, ownShip18,
						ownShip19 },
				{ ownShip20, ownShip21, ownShip22, ownShip23, ownShip24, ownShip25, ownShip26, ownShip27, ownShip28,
						ownShip29 },
				{ ownShip30, ownShip31, ownShip32, ownShip33, ownShip34, ownShip35, ownShip36, ownShip37, ownShip38,
						ownShip39 },
				{ ownShip40, ownShip41, ownShip42, ownShip43, ownShip44, ownShip45, ownShip46, ownShip47, ownShip48,
						ownShip49 },
				{ ownShip50, ownShip51, ownShip52, ownShip53, ownShip54, ownShip55, ownShip56, ownShip57, ownShip58,
						ownShip59 },
				{ ownShip60, ownShip61, ownShip62, ownShip63, ownShip64, ownShip65, ownShip66, ownShip67, ownShip68,
						ownShip69 },
				{ ownShip70, ownShip71, ownShip72, ownShip73, ownShip74, ownShip75, ownShip76, ownShip77, ownShip78,
						ownShip79 },
				{ ownShip80, ownShip81, ownShip82, ownShip83, ownShip84, ownShip85, ownShip86, ownShip87, ownShip88,
						ownShip89 },
				{ ownShip90, ownShip91, ownShip92, ownShip93, ownShip94, ownShip95, ownShip96, ownShip97, ownShip98,
						ownShip99 } };
	}

	private void setEnemyImagesToTab() {
		shipsLogic.enemyImages = new ImageView[][] {
				{ enemyShip00, enemyShip01, enemyShip02, enemyShip03, enemyShip04, enemyShip05, enemyShip06,
						enemyShip07, enemyShip08, enemyShip09 },
				{ enemyShip10, enemyShip11, enemyShip12, enemyShip13, enemyShip14, enemyShip15, enemyShip16,
						enemyShip17, enemyShip18, enemyShip19 },
				{ enemyShip20, enemyShip21, enemyShip22, enemyShip23, enemyShip24, enemyShip25, enemyShip26,
						enemyShip27, enemyShip28, enemyShip29 },
				{ enemyShip30, enemyShip31, enemyShip32, enemyShip33, enemyShip34, enemyShip35, enemyShip36,
						enemyShip37, enemyShip38, enemyShip39 },
				{ enemyShip40, enemyShip41, enemyShip42, enemyShip43, enemyShip44, enemyShip45, enemyShip46,
						enemyShip47, enemyShip48, enemyShip49 },
				{ enemyShip50, enemyShip51, enemyShip52, enemyShip53, enemyShip54, enemyShip55, enemyShip56,
						enemyShip57, enemyShip58, enemyShip59 },
				{ enemyShip60, enemyShip61, enemyShip62, enemyShip63, enemyShip64, enemyShip65, enemyShip66,
						enemyShip67, enemyShip68, enemyShip69 },
				{ enemyShip70, enemyShip71, enemyShip72, enemyShip73, enemyShip74, enemyShip75, enemyShip76,
						enemyShip77, enemyShip78, enemyShip79 },
				{ enemyShip80, enemyShip81, enemyShip82, enemyShip83, enemyShip84, enemyShip85, enemyShip86,
						enemyShip87, enemyShip88, enemyShip89 },
				{ enemyShip90, enemyShip91, enemyShip92, enemyShip93, enemyShip94, enemyShip95, enemyShip96,
						enemyShip97, enemyShip98, enemyShip99 } };
	}

	public void setActionOnMouseEntered(int x, int y) {
		enemyButtons[x][y].addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				enemyButtons[x][y].setOpacity(1);
				shipsLogic.setIdButton(enemyButtons[x][y].getId());
				shipsLogic.setPointX(Character.getNumericValue(shipsLogic.getIdButton().charAt(15)));
				shipsLogic.setPointY(Character.getNumericValue(shipsLogic.getIdButton().charAt(16)));
				shipsLogic.setEnemyButtonID();
				// System.out.println("Najechlem");
			}
		});
	}

	public void setActionOnMouseClicked(int x, int y) {
		enemyButtons[x][y].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(!enemyButtons[x][y].getId().equals("errorShot")){
					shipsLogic.yourTure();
				}
				return;
			}
		});
	}

	public void setActionOnMouseExited(int x, int y) {
		enemyButtons[x][y].addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				// System.out.println("Wyjechalem");
				// System.out.println("Wyjechalem!");
				enemyButtons[x][y].setOpacity(0);
				enemyButtons[shipsLogic.getPointX()][shipsLogic.getPointY()].setId("enemyShipButton"
						+ String.valueOf(shipsLogic.getPointX()) + String.valueOf(shipsLogic.getPointY()));

			}
		});
	}

	public void setEnemyXY() {
		for (int i = 0; i < enemyButtons.length; i++) {
			for (int j = 0; j < enemyButtons[i].length; j++) {
				final int x = i, y = j;
				setActionOnMouseEntered(x, y);
				setActionOnMouseClicked(x, y);
				setActionOnMouseExited(x, y);
			}
		}
	}

	// private Model model;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		shipsLogic = ShipsLogic.getInstance();
		setImagesToTab();
		setEnemyButtonsToTab();
		setEnemyImagesToTab();
		setEnemyXY();
		setActionOnScrollPane();

		shipsLogic.setLabelTure(getTure());

		shipsLogic.removeBlockedFields();
		shipsLogic.updateImages(Const.OWN_IMAGES);

		textFlow.setStyle(" -fx-background-color: #E8E8E8");

		// wlasny nick
		ownNick.setText(Model.getOwnNick());
		shipsLogic.setRemainedShips(getOwnRemainedShips());
		shipsLogic.setEnemySunkShips(enemySunkShips);
		
		shipsLogic.setScrollPane(getScrollPane());
		scrollPane.setContent(getTextFlow());
		scrollPane.setVvalue(scrollPane.getVmax());
		shipsLogic.setLogs(getTextFlow());
		shipsLogic.setDisableEnemyButtons();
		shipsLogic.createEnemyMap();
		shipsLogic.setEnemyNick(getEnemyNick());
		//shipsLogic.startGame(); 
	}

	public void generateLog() {
		//shipsLogic.addLog(Const.YOUR_TURE, 1, 8, Const.HIT);
		//setScrooling(true);
		// shipsLogic.waitForYourTure();
	}

	public void setActionOnScrollPane() {
		scrollPane.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				setScrooling(true);
			}
		});

		scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				if (isScrooling()) {
					setScrooling(false);
					scrollPane.setVvalue(1.0);
				}
			}
		});
	}

}
