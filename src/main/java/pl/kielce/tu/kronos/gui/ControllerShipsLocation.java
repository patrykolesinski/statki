package pl.kielce.tu.kronos.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import pl.kielce.tu.kronos.logic.Model;
import pl.kielce.tu.kronos.logic.ShipsLogic;

public class ControllerShipsLocation  extends MainWindow implements Initializable {

	public Model model;
	public ShipsLogic shipsLogic;

	@FXML
	Label nickAndNumberOfFlagstaff;

	@FXML
	ComboBox<String> orientation;

	@FXML
	ComboBox<String> typeOfShip;

	@FXML
	Label remainedShips;

	@FXML
	Label labelMessageShipsLocation;

	@FXML
	Button startGameButton;

	public Button[][] buttons;

	public Label getNickAndNumberOfFlagstaff() {
		return nickAndNumberOfFlagstaff;
	}

	public void setNickAndNumberOfFlagstaff(Label nickAndNumberOfFlagstaff) {
		this.nickAndNumberOfFlagstaff = nickAndNumberOfFlagstaff;
	}

	public ComboBox<String> getOrientation() {
		return orientation;
	}

	public void setOrientation(ComboBox<String> orientation) {
		this.orientation = orientation;
	}

	public ComboBox<String> getTypeOfShip() {
		return typeOfShip;
	}

	public void setTypeOfShip(ComboBox<String> typeOfShip) {
		this.typeOfShip = typeOfShip;
	}

	public Button getStartGameButton() {
		return startGameButton;
	}

	public void setStartGameButton(Button startGameButton) {
		this.startGameButton = startGameButton;
	}

	public Label getRemainedShips() {
		return remainedShips;
	}

	public void setRemainedShips(Label remainedShips) {
		this.remainedShips = remainedShips;
	}

	public Label getLabelMessageShipsLocation() {
		return labelMessageShipsLocation;
	}

	public void setLabelMessageShipsLocation(Label labelMessageShipsLocation) {
		this.labelMessageShipsLocation = labelMessageShipsLocation;
	}

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
	private Button ownShipButton00, ownShipButton10, ownShipButton20, ownShipButton30, ownShipButton40, ownShipButton50,
			ownShipButton60, ownShipButton70, ownShipButton80, ownShipButton90, ownShipButton01, ownShipButton11,
			ownShipButton21, ownShipButton31, ownShipButton41, ownShipButton51, ownShipButton61, ownShipButton71,
			ownShipButton81, ownShipButton91, ownShipButton02, ownShipButton12, ownShipButton22, ownShipButton32,
			ownShipButton42, ownShipButton52, ownShipButton62, ownShipButton72, ownShipButton82, ownShipButton92,
			ownShipButton03, ownShipButton13, ownShipButton23, ownShipButton33, ownShipButton43, ownShipButton53,
			ownShipButton63, ownShipButton73, ownShipButton83, ownShipButton93, ownShipButton04, ownShipButton14,
			ownShipButton24, ownShipButton34, ownShipButton44, ownShipButton54, ownShipButton64, ownShipButton74,
			ownShipButton84, ownShipButton94, ownShipButton05, ownShipButton15, ownShipButton25, ownShipButton35,
			ownShipButton45, ownShipButton55, ownShipButton65, ownShipButton75, ownShipButton85, ownShipButton95,
			ownShipButton06, ownShipButton16, ownShipButton26, ownShipButton36, ownShipButton46, ownShipButton56,
			ownShipButton66, ownShipButton76, ownShipButton86, ownShipButton96, ownShipButton07, ownShipButton17,
			ownShipButton27, ownShipButton37, ownShipButton47, ownShipButton57, ownShipButton67, ownShipButton77,
			ownShipButton87, ownShipButton97, ownShipButton08, ownShipButton18, ownShipButton28, ownShipButton38,
			ownShipButton48, ownShipButton58, ownShipButton68, ownShipButton78, ownShipButton88, ownShipButton98,
			ownShipButton09, ownShipButton19, ownShipButton29, ownShipButton39, ownShipButton49, ownShipButton59,
			ownShipButton69, ownShipButton79, ownShipButton89, ownShipButton99;

	private void setOrientation() {
		orientation.setValue("Horizontal");
		orientation.setItems(shipsLogic.getOrientationList());
	}

	private void setTypeOfShip() {
		typeOfShip.setValue("4-flagstaff");
		typeOfShip.setItems(shipsLogic.typeOfShipList());
	}

	private void setNickAndNumberOfFlagstaff() {
		nickAndNumberOfFlagstaff.setText(Model.getOwnNick() + ", set now 4-flagstaff");
	}

	private void setButtonsToTab() {
		buttons = new Button[][] {
				{ ownShipButton00, ownShipButton01, ownShipButton02, ownShipButton03, ownShipButton04, ownShipButton05,
						ownShipButton06, ownShipButton07, ownShipButton08, ownShipButton09 },
				{ ownShipButton10, ownShipButton11, ownShipButton12, ownShipButton13, ownShipButton14, ownShipButton15,
						ownShipButton16, ownShipButton17, ownShipButton18, ownShipButton19 },
				{ ownShipButton20, ownShipButton21, ownShipButton22, ownShipButton23, ownShipButton24, ownShipButton25,
						ownShipButton26, ownShipButton27, ownShipButton28, ownShipButton29 },
				{ ownShipButton30, ownShipButton31, ownShipButton32, ownShipButton33, ownShipButton34, ownShipButton35,
						ownShipButton36, ownShipButton37, ownShipButton38, ownShipButton39 },
				{ ownShipButton40, ownShipButton41, ownShipButton42, ownShipButton43, ownShipButton44, ownShipButton45,
						ownShipButton46, ownShipButton47, ownShipButton48, ownShipButton49 },
				{ ownShipButton50, ownShipButton51, ownShipButton52, ownShipButton53, ownShipButton54, ownShipButton55,
						ownShipButton56, ownShipButton57, ownShipButton58, ownShipButton59 },
				{ ownShipButton60, ownShipButton61, ownShipButton62, ownShipButton63, ownShipButton64, ownShipButton65,
						ownShipButton66, ownShipButton67, ownShipButton68, ownShipButton69 },
				{ ownShipButton70, ownShipButton71, ownShipButton72, ownShipButton73, ownShipButton74, ownShipButton75,
						ownShipButton76, ownShipButton77, ownShipButton78, ownShipButton79 },
				{ ownShipButton80, ownShipButton81, ownShipButton82, ownShipButton83, ownShipButton84, ownShipButton85,
						ownShipButton86, ownShipButton87, ownShipButton88, ownShipButton89 },
				{ ownShipButton90, ownShipButton91, ownShipButton92, ownShipButton93, ownShipButton94, ownShipButton95,
						ownShipButton96, ownShipButton97, ownShipButton98, ownShipButton99 } };
		shipsLogic.buttons = buttons;
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

	public void setFields() throws IOException {
		shipsLogic.setNickAndNumberOfFlagstaff(getNickAndNumberOfFlagstaff());
		shipsLogic.setLengthFlagstaff(4);
		shipsLogic.setStartGameButton(getStartGameButton());
		shipsLogic.setOrientationCombo(getOrientation());
		shipsLogic.setTypeOfShipCombo(getTypeOfShip());
		shipsLogic.setRemainedShips(getRemainedShips());
		typeOfShipSetOnAction(typeOfShip, nickAndNumberOfFlagstaff);
		orientationSetOnAction(orientation);
		shipsLogic.setLabelMessage(getLabelMessageShipsLocation());
		setXY();
		shipsLogic.setOrientation(orientation.getValue());
		shipsLogic.setTypeOfShip(typeOfShip.getValue());
		shipsLogic.resetNumberOfShip();
		shipsLogic.createPlayer();
	}

	public void typeOfShipSetOnAction(ComboBox<String> typeOfShipList, Label nickAndNumberOfFlagstaff) {
		typeOfShipList.setOnAction(e -> {
			nickAndNumberOfFlagstaff.setText(Model.getOwnNick() + ", set now " + typeOfShipList.getValue());
			switch (typeOfShipList.getValue()) {
			case "1-flagstaff": {
				shipsLogic.setLengthFlagstaff(1);
				shipsLogic.setTypeOfShip("1-flagstaff");
				break;
			}
			case "2-flagstaff": {
				shipsLogic.setLengthFlagstaff(2);
				shipsLogic.setTypeOfShip("2-flagstaff");
				break;
			}
			case "3-flagstaff": {
				shipsLogic.setLengthFlagstaff(3);
				shipsLogic.setTypeOfShip("3-flagstaff");
				break;
			}
			case "4-flagstaff": {
				shipsLogic.setLengthFlagstaff(4);
				shipsLogic.setTypeOfShip("4-flagstaff");
				break;
			}
			}
		});
	}

	public void orientationSetOnAction(ComboBox<String> orientationList) {
		orientationList.setOnAction(e -> {
			switch (orientationList.getValue()) {
			case "Horizontal": {
				shipsLogic.setOrientation("Horizontal");
				break;
			}
			case "Vertical": {
				shipsLogic.setOrientation("Vertical");
				break;
			}
			}
		});
	}

	public void setXY() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				final int x = i, y = j;

				buttons[x][y].setOnScroll(new EventHandler<ScrollEvent>() {
					@Override
					public void handle(ScrollEvent e) {
						shipsLogic.scrollChangeTypeOfShip(e);
					}
				});

				buttons[x][y].addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						shipsLogic.setIdButton(buttons[x][y].getId());
						shipsLogic.setPointX(Character.getNumericValue(shipsLogic.getIdButton().charAt(13)));
						shipsLogic.setPointY(Character.getNumericValue(shipsLogic.getIdButton().charAt(14)));
						shipsLogic.isPossibleSetFlagstaff(shipsLogic.getOrientation());
					}
				});

				buttons[x][y].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {

						if (e.getButton() == MouseButton.SECONDARY) {
							shipsLogic.changeOrientation(e);
						} else if (e.getButton() == MouseButton.PRIMARY) {
							shipsLogic.setFlagstaffOnView(shipsLogic.getOrientation(), shipsLogic.getTypeOfShip());
							return;
						}
						return;
					}
				});

				buttons[x][y].addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						shipsLogic.setButtonsOriginalID();
					}
				});
			}
		}
	}

	public void randomMap() {
		shipsLogic.randomMap();
	}

	public void resetMap() {
		shipsLogic.resetMap();
	}

	public void startGame(ActionEvent event) throws IOException {
			setTemp(event);
			setNewStage();
			changeStage("Duel", "Duel", 978, 460);
			shipsLogic.startGame();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		shipsLogic = ShipsLogic.getInstance();
		// ShipsLogic.setConnect(Model.getConnect());
		setButtonsToTab();
		setImagesToTab();
		setOrientation();
		setTypeOfShip();
		setNickAndNumberOfFlagstaff();
		try {
			setFields();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}