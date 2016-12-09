package pl.kielce.tu.kronos.logic;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import pl.kielce.tu.kronos.flagstaff.Flagstaff;
import pl.kielce.tu.kronos.flagstaff.FourFlagstaff;
import pl.kielce.tu.kronos.flagstaff.OneFlagstaff;
import pl.kielce.tu.kronos.flagstaff.ThreeFlagstaff;
import pl.kielce.tu.kronos.flagstaff.TwoFlagstaff;
import pl.kielce.tu.kronos.gui.ControllerDuel;
import pl.kielce.tu.kronos.gui.MainWindow;
import pl.kielce.tu.kronos.gui.PopUp;
import pl.kielce.tu.kronos.logic.Const;

public class ShipsLogic {
	private static ShipsLogic shipsLogic = null;

	private ShipsLogic() {
	}

	public static ShipsLogic getInstance() {
		if (shipsLogic == null) {
			shipsLogic = new ShipsLogic();
		}
		return shipsLogic;
	}

	// public static ClientConnection connect;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * public static ClientConnection getConnect() { return connect; }
	 * 
	 * public static void setConnect(ClientConnection connect) {
	 * ShipsLogic.connect = connect; }
	 */

	/*
	 * public static byte GOOD_AREA_HORIZONTAL = 0; public static byte
	 * Const.GOOD_AREA_VERTICAL = 1; public static byte
	 * Const.OUT_OF_RANGE_HORIZONTAL = 2; public static byte
	 * Const.OUT_OF_RANGE_VERTICAL = 3; public static byte
	 * Const.BLOCKED_HORIZONTAL = 4; public static byte Const.BLOCKED_VERTICAL =
	 * 5; public static byte Const.NOT_BLOCKED_HORIZONTAL = 6; public static
	 * byte Const.NOT_BLOCKED_VERTICAL = 7; public static byte
	 * Const.READY_TO_SET = 8; public static byte Const.NOT_READY_TO_SET = 9;
	 * public static byte Const.MAX_NUMBER_SHIP = 10; public static byte
	 * Const.BAD_AREA = 11; public static byte BLOCKED = 12;
	 * 
	 * public static byte MISS = 13; public static byte HIT = 14; public static
	 * byte HIT_AND_SUNK = 15; public static byte YOUR_TURE = 16; public static
	 * byte ENEMY_TURE = 17; public static byte HORIZONTAL = 18; public static
	 * byte VERTICAL = 19; public static byte OWN_IMAGES = 20; public static
	 * byte ENEMY_IMAGES = 21;
	 * 
	 * public static byte DEFEAT = 22; public static byte VICTORY = 23;
	 */

	private Label nickAndNumberOfFlagstaff;
	private int error;
	private int numberOfShip;

	public String orientation;
	public String typeOfShip;

	public ComboBox<String> orientationCombo;
	public ComboBox<String> typeOfShipCombo;

	private Label labelMessage;
	Label ownRemainedShips;
	private Button startGameButton;

	Player player;

	private int lengthFlagstaff;
	private String idButton;
	public Button[][] buttons;
	public Button[][] enemyButtons;

	public ImageView[][] ownImages;

	public ImageView[][] enemyImages;

	public Flagstaff[] tabOfShips;

	private int pointX;
	private int pointY;

	private Label enemySunkShips;
	private TextFlow logs;
	private ScrollPane scrollPane;

	private Map enemyMap;
	private Label labelTure;

	static int activeTure;;

	public Label enemyNick;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Label getNickAndNumberOfFlagstaff() {
		return nickAndNumberOfFlagstaff;
	}

	public Label getEnemyNick() {
		return enemyNick;
	}

	public void setEnemyNick(Label enemyNick) {
		this.enemyNick = enemyNick;
	}

	public int getActiveTure() {
		return activeTure;
	}

	public void setActiveTure(int activeTure) {
		this.activeTure = activeTure;
	}

	public Map getEnemyMap() {
		return enemyMap;
	}

	public void setEnemyMap(Map enemyMap) {
		this.enemyMap = enemyMap;
	}

	public Label getLabelTure() {
		return labelTure;
	}

	public void setLabelTure(Label ture) {
		this.labelTure = ture;
	}

	public ScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(ScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public TextFlow getLogs() {
		return logs;
	}

	public void setLogs(TextFlow logs) {
		this.logs = logs;
	}

	public Label getEnemySunkShip() {
		return enemySunkShips;
	}

	public void setEnemySunkShips(Label enemySunkShips) {
		this.enemySunkShips = enemySunkShips;
	}

	public void setNickAndNumberOfFlagstaff(Label nickAndNumberOfFlagstaff) {
		this.nickAndNumberOfFlagstaff = nickAndNumberOfFlagstaff;
	}

	public Button getStartGameButton() {
		return startGameButton;
	}

	public void setStartGameButton(Button startGameButton) {
		this.startGameButton = startGameButton;
	}

	public Label getRemainedShips() {
		return ownRemainedShips;
	}

	public void resetRemainedShips() {
		this.ownRemainedShips.setText("10 ships to set.");
	}

	public void setRemainedShips(Label remainedShips) {
		this.ownRemainedShips = remainedShips;
	}

	public Label getLabelMessage() {
		return labelMessage;
	}

	public void setLabelMessage(Label labelMessage) {
		this.labelMessage = labelMessage;
	}

	public ComboBox<String> getOrientationCombo() {
		return orientationCombo;
	}

	public void setOrientationCombo(ComboBox<String> orientationCombo) {
		this.orientationCombo = orientationCombo;
	}

	public ComboBox<String> getTypeOfShipCombo() {
		return typeOfShipCombo;
	}

	public void setTypeOfShipCombo(ComboBox<String> typeOfShipCombo) {
		this.typeOfShipCombo = typeOfShipCombo;
	}

	public String getTypeOfShip() {
		return typeOfShip;
	}

	public void setTypeOfShip(String typeOfShip) {
		this.typeOfShip = typeOfShip;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public int getNumberOfShip() {
		return numberOfShip;
	}

	public void setNumberOfShip(int numberOfShips) {
		this.numberOfShip = numberOfShips;
	}

	public void incNumberOfShip() {
		this.numberOfShip++;
	}

	public void resetNumberOfShip() {
		this.numberOfShip = 0;
	}

	public int getError() {
		return error;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setError(int error) {
		this.error = error;
	}

	private static ObservableList<String> orientationList = FXCollections.observableArrayList("Horizontal", "Vertical");

	public ObservableList<String> getOrientationList() {
		return orientationList;
	}

	private static ObservableList<String> typeOfShipList = FXCollections.observableArrayList("1-flagstaff",
			"2-flagstaff", "3-flagstaff", "4-flagstaff");

	public ObservableList<String> typeOfShipList() {
		return typeOfShipList;
	}

	public int getLengthFlagstaff() {
		return lengthFlagstaff;
	}

	public void setLengthFlagstaff(int lengthFlagstaff) {
		this.lengthFlagstaff = lengthFlagstaff;
	}

	public String getIdButton() {
		return idButton;
	}

	public void setIdButton(String idButton) {
		this.idButton = idButton;
	}

	public int getPointX() {
		return pointX;
	}

	public void setPointX(int pointX) {
		this.pointX = pointX;
	}

	public int getPointY() {
		return pointY;
	}

	public void setPointY(int pointY) {
		this.pointY = pointY;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// ////////////////////////////////////////////////////
	///////////////////////////// OWN METHODS
	/////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////
	///////////////////////////// ////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void createPlayer() throws IOException {
		player = new Player(0, Model.getOwnNick());
	}

	// D:\STUDIA\Semestr_4\JAVA\workspace\Statki\src\main\resources\jpg\flagstaff\hitFlagstaff.jpg
	// static final File file = new
	// File("D:\\STUDIA\\Semestr_4\\JAVA\\workspace\\Statki\\src\\main\\resources\\jpg\\flagstaff\\hitFlagstaff.jpg");

	// static final File file = new File("../jpg/flagstaff/hitFlagstaff.jpg");
	// static final Image image = new Image(file.toURI().toString());

	public void setImages(Map map, ImageView[][] images) {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (map.getMapXY(x, y) == Const.BLOCKED_FIELD) {
					images[x][y].setId("blockedField");
				} else if (map.getMapXY(x, y) == Const.EMPTY_FIELD) {
					images[x][y].setId("emptyField");
				} else if (map.getMapXY(x, y) == Const.HIT_FLAGSTAFF) {
					// images[x][y].setImage(image);
					images[x][y].setId("hitFlagstaff");
				} else if (map.getMapXY(x, y) == Const.MISS_FIELD) {
					images[x][y].setId("missField");
				} else if (map.getMapXY(x, y) == Const.SET_FLAGSTAFF) {
					images[x][y].setId("setFlagstaff");
				} else if (map.getMapXY(x, y) == Const.SUNK_FLAGSTAFF) {
					images[x][y].setId("sunkFlagstaff");
				}
				// System.out.println(y);

			}
			// System.out.println(x);

		}

	}

	public void updateImages(int images) {
		Map map;
		ImageView[][] tabImages;
		if (images == Const.OWN_IMAGES) {
			map = player.getMap();
			tabImages = ownImages;
			setImages(map, tabImages);
		} else if (images == Const.ENEMY_IMAGES) {
			tabImages = enemyImages;
			map = enemyMap;
			setImages(map, tabImages);
		}
	}

	public void setOriginalIDButton(int x, int y) {
		buttons[x][y].setId("ownShipButton" + String.valueOf(x) + String.valueOf(y));
	}

	public void setHButtonsOriginalIDOutOfRange() {
		for (int x = getPointX(); x < 10; x++) {
			setOriginalIDButton(x, getPointY());
		}
	}

	public void setVButtonsOriginalIDOutOfRange() {
		for (int y = getPointY(); y < 10; y++) {
			setOriginalIDButton(getPointX(), y);
		}
	}

	public void setHButtonsOriginalID() {
		for (int x = getPointX(); x < getPointX() + getLengthFlagstaff(); x++) {
			setOriginalIDButton(x, getPointY());
		}
	}

	public void setVButtonsOriginalID() {
		for (int y = getPointY(); y < getPointY() + getLengthFlagstaff(); y++) {
			setOriginalIDButton(getPointX(), y);
		}
	}

	public void setButtonsOriginalID() {

		int error = getError();
		if (error == Const.OUT_OF_RANGE_HORIZONTAL) {
			setHButtonsOriginalIDOutOfRange();
		} else if (error == Const.GOOD_AREA_HORIZONTAL) {
			setHButtonsOriginalID();
		} else if (error == Const.OUT_OF_RANGE_VERTICAL) {
			setVButtonsOriginalIDOutOfRange();
		} else if (error == Const.GOOD_AREA_VERTICAL) {
			setVButtonsOriginalID();
		} else if (error == Const.NOT_BLOCKED_HORIZONTAL) {
			setHButtonsOriginalID();
		} else if (error == Const.BLOCKED_HORIZONTAL) {
			setHButtonsOriginalID();
		} else if (error == Const.NOT_BLOCKED_VERTICAL) {
			setVButtonsOriginalID();
		} else if (error == Const.BLOCKED_VERTICAL) {
			setVButtonsOriginalID();
		}
	}

	public void changeOrientation(MouseEvent e) {
		if (e.getButton() == MouseButton.SECONDARY) {
			if (getOrientationCombo().getValue().equals("Horizontal")) {
				setButtonsOriginalID();
				setOrientation("Vertical");
				getOrientationCombo().setValue(getOrientation());
				isPossibleSetFlagstaff(getOrientation());
				return;
			} else if (getOrientationCombo().getValue().equals("Vertical")) {
				setButtonsOriginalID();
				setOrientation("Horizontal");
				getOrientationCombo().setValue(getOrientation());
				isPossibleSetFlagstaff(getOrientation());
				return;
			}
		}
	}

	public void thingsToDoAfterScroll(int typeOfFlagstaff) {
		setButtonsOriginalID();
		setTypeOfShip(String.valueOf(typeOfFlagstaff + "-flagstaff"));
		getTypeOfShipCombo().setValue(getTypeOfShip());
		isPossibleSetFlagstaff(getOrientation());
	}

	public void incTypeOfFlagstaff(int typeOfFlagstaff) {
		typeOfFlagstaff++;
		if (typeOfFlagstaff > 4) {
			typeOfFlagstaff = 1;
		}
		thingsToDoAfterScroll(typeOfFlagstaff);
	}

	public void decTypeOfFlagstaff(int typeOfFlagstaff) {
		typeOfFlagstaff--;
		if (typeOfFlagstaff < 1) {
			typeOfFlagstaff = 4;
		}
		thingsToDoAfterScroll(typeOfFlagstaff);
	}

	public void scrollChangeTypeOfShip(ScrollEvent e) {
		String typeAcutalElement;
		typeAcutalElement = typeOfShipCombo.getValue();
		int typeOfFlagstaff;
		typeOfFlagstaff = Character.getNumericValue(typeAcutalElement.charAt(0));

		// DOWN
		if (e.getDeltaY() < 0) {
			if (getOrientationCombo().getValue().equals("Horizontal")) {
				decTypeOfFlagstaff(typeOfFlagstaff);
			} else {
				incTypeOfFlagstaff(typeOfFlagstaff);
			}
		} else if (e.getDeltaY() > 0) {
			// UP
			if (getOrientationCombo().getValue().equals("Horizontal")) {
				incTypeOfFlagstaff(typeOfFlagstaff);
			} else {
				decTypeOfFlagstaff(typeOfFlagstaff);
			}
		}
	}

	public void setErrorOnView(int x, int y) {
		if (getError() == Const.OUT_OF_RANGE_HORIZONTAL) {
			labelSetErrorMessage(Const.BAD_AREA);
		} else if (getError() == Const.BLOCKED_HORIZONTAL) {
			labelSetErrorMessage(Const.BLOCKED);
		} else {
			labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
		}
		buttons[x][y].setId("errorSetFlagstaff");
	}

	public int isHOutOfRange() {
		if ((getPointX() + getLengthFlagstaff()) > 10) {
			return Const.OUT_OF_RANGE_HORIZONTAL;
		} else {
			return Const.GOOD_AREA_HORIZONTAL;
		}
	}

	public int isVOutOfRange() {
		if ((getPointY() + getLengthFlagstaff()) > 10) {
			return Const.OUT_OF_RANGE_VERTICAL;
		} else {
			return Const.GOOD_AREA_VERTICAL;
		}
	}

	public void setHButtonsIDErrorOutOfRange() {
		for (int x = getPointX(); x < 10; x++) {
			setErrorOnView(x, getPointY());
		}
	}

	public void setVButtonsIDErrorOutOfRange() {
		for (int y = getPointY(); y < 10; y++) {
			setErrorOnView(getPointX(), y);
		}
	}

	public void labelSetReadyMessage() {
		getLabelMessage().setId("labelReady");
		getLabelMessage().setText("You can set a ship");
	}

	public void labelSetErrorMessage(int type) {
		getLabelMessage().setId("labelError");
		if (type == Const.BAD_AREA) {
			getLabelMessage().setText("Ship on Land! :D");
		} else if (type == Const.MAX_NUMBER_SHIP) {
			getLabelMessage().setText("Enough of these ships!");
		} else if (type == Const.BLOCKED) {
			getLabelMessage().setText("Collision of ships!");
		}
	}

	public void setButtonIDReady(int x, int y) {
		labelSetReadyMessage();
		buttons[x][y].setId("shipIsReadyToSet");
	}

	public void setHButtonsIDReady() {
		for (int x = getPointX(); x < getPointX() + getLengthFlagstaff(); x++) {
			setButtonIDReady(x, getPointY());
		}
	}

	public void setVButtonsIDReady() {
		for (int y = getPointY(); y < getPointY() + getLengthFlagstaff(); y++) {
			setButtonIDReady(getPointX(), y);
		}
	}

	public void setHButtonsIDError() {
		for (int x = getPointX(); x < getPointX() + getLengthFlagstaff(); x++) {
			setErrorOnView(x, getPointY());
		}
	}

	public void setVButtonsIDError() {
		for (int y = getPointY(); y < getPointY() + getLengthFlagstaff(); y++) {
			setErrorOnView(getPointX(), y);
		}
	}

	public int checkHBlockedShip() {
		for (int x = getPointX(); x < getPointX() + getLengthFlagstaff(); x++) {
			if ((player.getMap().getMapXY(x, getPointY()) == Const.SET_FLAGSTAFF)
					|| (player.getMap().getMapXY(x, getPointY()) == Const.BLOCKED_FIELD)) {
				return Const.BLOCKED_HORIZONTAL;
			}
		}
		return Const.NOT_BLOCKED_HORIZONTAL;
	}

	public int checkVBlockedShip() {
		for (int y = getPointY(); y < getPointY() + getLengthFlagstaff(); y++) {
			if ((player.getMap().getMapXY(getPointX(), y) == Const.SET_FLAGSTAFF)
					|| (player.getMap().getMapXY(getPointX(), y) == Const.BLOCKED_FIELD)) {
				return Const.BLOCKED_VERTICAL;
			}
		}
		return Const.NOT_BLOCKED_VERTICAL;
	}

	public boolean setFlagstaff(String orientation, String typeOfShip) {
		if (typeOfShip.equals("1-flagstaff")) {
			if (player.getOneFlagstaff(OneFlagstaff.getNumber1Flagstaff()).setFlagstaff(getPointX(), getPointY(),
					orientationCombo.getValue())) {
				return true;
			} else {
				labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
			}
		} else if (typeOfShip.equals("2-flagstaff")) {
			if (player.getTwoFlagstaff(TwoFlagstaff.getNumber2Flagstaff()).setFlagstaff(getPointX(), getPointY(),
					orientation)) {

				return true;
			}

			else {
				labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
			}
		}
		if (typeOfShip.equals("3-flagstaff")) {
			if (player.getThreeFlagstaff(ThreeFlagstaff.getNumber3Flagstaff()).setFlagstaff(getPointX(), getPointY(),
					orientationCombo.getValue())) {

				return true;
			} else {
				labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
			}
		}
		if (typeOfShip.equals("4-flagstaff")) {
			if (player.getFourFlagstaff(FourFlagstaff.getNumber4Flagstaff()).setFlagstaff(getPointX(), getPointY(),
					orientationCombo.getValue())) {
				return true;
			} else {
				labelSetErrorMessage(Const.MAX_NUMBER_SHIP);
			}
		}
		return false;
	}

	public boolean setFlagstaffOnView(String orientation, String typeOfShip) {
		if (getNumberOfShip() >= 10) {
			// System.out.println("Nie mozna ustawic juz wiecej statkow!");
			return false;
		} else {
			if (isPossibleSetFlagstaff(orientation)) {
				if (setFlagstaff(orientation, typeOfShip)) {
					player.getMap().updateMap(getPointX(), getPointY(), getLengthFlagstaff(), orientation);
					updateImages(Const.OWN_IMAGES);
					incNumberOfShip();
					if (getNumberOfShip() == 10) {
						startGameButton.setDisable(false);
						getNickAndNumberOfFlagstaff().setText(Model.getOwnNick() + ", start Game!");
					}
					getRemainedShips().setText(String.valueOf(10 - getNumberOfShip()) + " ships to set.");
				}
			}
			return true;
		}
	}

	public boolean isMaxNumberOfAnyTypeOfShip() {
		if ((FourFlagstaff.getNumber4Flagstaff() == 1) && (getTypeOfShip().equals("4-flagstaff"))
				|| (ThreeFlagstaff.getNumber3Flagstaff() == 2) && (getTypeOfShip().equals("3-flagstaff"))
				|| (TwoFlagstaff.getNumber2Flagstaff() == 3) && (getTypeOfShip().equals("2-flagstaff"))
				|| (OneFlagstaff.getNumber1Flagstaff() == 4) && (getTypeOfShip().equals("1-flagstaff"))) {
			return true;
		}
		return false;
	}

	public int isPossibleSetHFlagstaff() {
		setError(isHOutOfRange());
		if (getError() == Const.OUT_OF_RANGE_HORIZONTAL) {
			setHButtonsIDErrorOutOfRange();
			return Const.NOT_READY_TO_SET;
		} else if (getError() == Const.GOOD_AREA_HORIZONTAL) {
			setError(checkHBlockedShip());
			if ((getError() == Const.BLOCKED_HORIZONTAL) || isMaxNumberOfAnyTypeOfShip()) {
				setHButtonsIDError();
				return Const.NOT_READY_TO_SET;
			} else if (getError() == Const.NOT_BLOCKED_HORIZONTAL) {
				setHButtonsIDReady();
				return Const.READY_TO_SET;
			}
		}
		return Const.NOT_READY_TO_SET;
	}

	public int isPossibleSetVFlagstaff() {
		setError(isVOutOfRange());
		if (getError() == Const.OUT_OF_RANGE_VERTICAL) {
			setVButtonsIDErrorOutOfRange();
			return Const.NOT_READY_TO_SET;
		} else if (getError() == Const.GOOD_AREA_VERTICAL) {
			setError(checkVBlockedShip());
			if ((getError() == Const.BLOCKED_VERTICAL) || isMaxNumberOfAnyTypeOfShip()) {
				setVButtonsIDError();
				return Const.NOT_READY_TO_SET;
			} else if (getError() == Const.NOT_BLOCKED_VERTICAL) {
				setVButtonsIDReady();
				return Const.READY_TO_SET;
			}
		}
		return Const.NOT_READY_TO_SET;
	}

	public boolean isPossibleSetFlagstaff(String orientation) {
		if ((orientation.equals("Horizontal")) && (isPossibleSetHFlagstaff() == Const.READY_TO_SET)) {
			return true;
		} else if ((orientation.equals("Vertical")) && (isPossibleSetVFlagstaff() == Const.READY_TO_SET)) {
			return true;
		}
		return false;
	}

	public void randomSetTypeOfShip(Random r) {
		int random;
		String type;
		random = r.nextInt(5);
		type = String.valueOf(random);
		setTypeOfShip(type + "-flagstaff");
		getTypeOfShipCombo().setValue(getTypeOfShip());

	}

	public void randomSetOrientation(Random r) {
		int random;
		random = (byte) r.nextInt(2);
		if (random % 2 == 0) {
			setOrientation("Horizontal");
		} else {
			setOrientation("Vertical");
		}
		getOrientationCombo().setValue(getOrientation());
	}

	public void randomSetXY(Random r) {
		int x, y;
		boolean correctPoint = true;
		do {
			x = r.nextInt(10);
			y = r.nextInt(10);
			if (player.getMap().getMapXY(x, y) == Const.EMPTY_FIELD) {
				correctPoint = false;
			}
		} while (correctPoint);
		setPointX(x);
		setPointY(y);
	}

	public void randomMap() {
		int loop = 0;
		if (getNumberOfShip() == 10) {
			resetMap();
			getLabelMessage().setText("Ships are setted!\n but order is a order!");
		}
		Random r = new Random();
		while (getNumberOfShip() < 10) {
			randomSetTypeOfShip(r);
			randomSetOrientation(r);
			randomSetXY(r);
			setFlagstaffOnView(getOrientationCombo().getValue(), getTypeOfShipCombo().getValue());
			setButtonsOriginalID();
			loop++;

			if (loop > 300) {
				getLabelMessage().setTextFill(Color.RED);
				getLabelMessage().setText("Not all ships are setted!");
				break;
			}
		}
		// System.out.println(loop);
		getLabelMessage().setText("All ships are setted!");
	}

	public void resetNumbers() {
		OneFlagstaff.resetNumber1Flagstaff();
		TwoFlagstaff.resetNumber2Flagstaff();
		ThreeFlagstaff.resetNumber3Flagstaff();
		FourFlagstaff.resetNumber4Flagstaff();
		resetNumberOfShip();
		resetRemainedShips();
	}

	public void resetOrientation() {
		setOrientation("Horizontal");
		getOrientationCombo().setValue(getOrientation());
	}

	public void resetTypeOfShip() {
		setTypeOfShip("4-flagstaff");
		getTypeOfShipCombo().setValue(getTypeOfShip());
	}

	public void resetMapOnView() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				player.getMap().setMapXY(x, y, Const.EMPTY_FIELD);
			}
		}
		updateImages(Const.OWN_IMAGES);
	}

	public void resetShip() {
		player.resetTablesOfShip();
	}

	public void resetMap() {
		if (getNumberOfShip() == 0) {
			getLabelMessage().setText("Clear a empty Map?\n As you wish!");
		}
		resetOrientation();
		resetTypeOfShip();
		resetMapOnView();
		resetShip();
		resetNumbers();
		startGameButton.setDisable(true);
	}

	public void tureSetYou() {
		Platform.runLater(() -> {
			getLabelTure().setFont(new Font("Arial", 28));
			labelTure.setTextFill(Color.GREEN);
			labelTure.setText("Your Ture");
		});
	}

	public void tureSetEnemy() {
		Platform.runLater(() -> {
			getLabelTure().setFont(new Font("Arial", 28));
			labelTure.setTextFill(Color.RED);
			getLabelTure().setText("Enemy Ture");
		});
	}

	public void setDisableEnemyButtons() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				enemyButtons[x][y].setDisable(true);
			}
		}
	}

	public void setEnableEnemyButtons() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				enemyButtons[x][y].setDisable(false);
			}
		}
	}

	public void enemyShotMiss(int x, int y) {
		setEnableEnemyButtons();
		addLog(Const.ENEMY_TURE, x, y, Const.MISS);
		player.getMap().setMapXY(x, y, Const.MISS_FIELD);
		setActiveTure(Const.YOUR_TURE);

		Platform.runLater(() -> {
			labelTure.setTextFill(Color.GREEN);
			labelTure.setText("Your Ture");
		});
	}

	public void addLog(int ture, int x, int y, byte status) {
		Text text = new Text();
		Text line = new Text("\n----------------------------------------\n");

		text.setFont(Font.font("Arial", FontPosture.REGULAR, 16));

		int temp;
		temp = x;
		x = y;
		y = temp;
		y++;
		if (ture == Const.YOUR_TURE) {
			shipsLogic.addLogYourMove(text, x, y, status);
		} else {
			shipsLogic.addLogEnemyMove(text, x, y, status);
		}

		Platform.runLater(() -> {
			shipsLogic.getLogs().getChildren().addAll(text, line);
			ControllerDuel.setScrooling(true);
		});

	}

	public void yourShotMiss(ServerData data) {
		setDisableEnemyButtons();
		addLog(Const.YOUR_TURE, data.getX(), data.getY(), Const.MISS);
		enemyMap.setMapXY(data.getX(), data.getY(), Const.MISS_FIELD);
		updateImages(Const.ENEMY_IMAGES);
		setActiveTure(Const.ENEMY_TURE);

		Platform.runLater(() -> {
			labelTure.setTextFill(Color.RED);
			labelTure.setText("Enemy ture");
		});

		waitForYourTure();
	}

	public void enemyShotHit(ServerData data) {
		addLog(Const.ENEMY_TURE, data.getX(), data.getY(), Const.HIT);
		player.getMap().setMapXY(data.getX(), data.getY(), Const.HIT_FLAGSTAFF);
	}

	public void yourShotHit(ServerData data) {
		addLog(Const.YOUR_TURE, data.getX(), data.getY(), Const.HIT);
		enemyMap.setMapXY(data.getX(), data.getY(), Const.HIT_FLAGSTAFF);
	}

	public void incEnemySunkShips() {
		int drowned;
		drowned = Integer.parseInt(enemySunkShips.getText());
		drowned++;
		enemySunkShips.setText(String.valueOf(drowned));
	}

	public void enemyShotHitAndSunk(ServerData data) {
		addLog(Const.ENEMY_TURE, data.getX(), data.getY(), Const.HIT_AND_SUNK);
		// System.out.println("ZATAPIAM STATEK");
		// System.out.println("X: " + data.getX());
		// System.out.println("Y: " + data.getY());
		// System.out.println("ORIENTACJA: " + data.getOrientation());
		if (data.getOrientation().equals("Horizontal")) {
			// System.out.println("Horizontal");
			shipsLogic.player.getMap().setHSunkShipOnMap(data.getX(), data.getY(), data.getLength());
		} else {
			// System.out.println("Vertical");
			shipsLogic.player.getMap().setVSunkShipOnMap(data.getX(), data.getY(), data.getLength());
		}
		decOwnRemainedShips();

	}

	public void decOwnRemainedShips() {
		Label pozostale;
		pozostale = shipsLogic.ownRemainedShips;
		int remained = Integer.parseInt(pozostale.getText()) - 1;
		Platform.runLater(() -> {
			pozostale.setText(String.valueOf(remained));
		});
	}

	public void yourShotHitAndSunk(ServerData data) {
		addLog(Const.YOUR_TURE, data.getX(), data.getY(), Const.HIT_AND_SUNK);
		// System.out.println("ZATAPIAM STATEK");
		// System.out.println("X: " + data.getX());
		// System.out.println("Y: " + data.getY());
		if (data.getOrientation().equals("Horizontal")) {
			// System.out.println("horizontal");
			enemyMap.setHSunkShipOnMap(data.getX(), data.getY(), data.getLength());
		} else {
			// System.out.println("vertical");
			enemyMap.setVSunkShipOnMap(data.getX(), data.getY(), data.getLength());
		}
		incEnemySunkShips();
	}

	public void startGame() {
		//getLabelTure().setFont(new Font("Arial", 28));
		Runnable r = new WaitForSecondThread(player, enemyNick);
		Thread t = new Thread(r);
		t.start();
		/*
		 * player.setId(Integer.parseInt(Model.connect.getData()));
		 * Model.connect.sendPlayer(player);
		 * 
		 * enemyNick.setText(Model.connect.getData());
		 * setActiveTure(Integer.parseInt(Model.connect.getData()));
		 * 
		 * getLabelTure().setFont(new Font("Arial", 28)); if (getActiveTure() ==
		 * Const.YOUR_TURE) { // Gra setEnableEnemyButtons(); tureSetYou(); }
		 * else { // Czeka tureSetEnemy(); setDisableEnemyButtons();
		 * waitForYourTure(); } // Model.connect.disconnectWithServer(); // To
		 * musi byc na koncu // pogramu!
		 */
	}

	public String getLetter(int x) {
		String letter;
		x += 65;
		letter = Character.toString((char) x);
		return letter;
	}

	public void addLogYourMove(Text text, int x, int y, byte status) {
		text.setText("You shot in: " + getLetter(x) + ":" + String.valueOf(y));
		if (status == Const.MISS) {
			text.setFill(Color.ORANGE);
			text.setText(text.getText() + "\nStatus: Miss");
		} else if (status == Const.HIT) {
			text.setFill(Color.BLUEVIOLET);
			text.setText(text.getText() + "\nStatus: Hit");
		} else if (status == Const.HIT_AND_SUNK) {
			text.setFill(Color.GREEN);
			text.setText(text.getText() + "\nStatus: Hit and Sunk");
		}
	}

	public void addLogEnemyMove(Text text, int x, int y, byte status) {
		text.setText("Enemy shot in: " + getLetter(x) + ":" + String.valueOf(y));
		if (status == Const.MISS) {
			text.setFill(Color.ORANGE);
			text.setText(text.getText() + "\nStatus: Miss");
		} else if (status == Const.HIT) {
			text.setFill(Color.CRIMSON);
			text.setText(text.getText() + "\nStatus: Hit");
		} else if (status == Const.HIT_AND_SUNK) {
			text.setFill(Color.RED);
			text.setText(text.getText() + "\nStatus: Hit and Sunk");
		}

	}

	public void createEnemyMap() {
		enemyMap = new Map();
	}

	public void removeBlockedFields() {
		player.getMap().removeBlockedFields();
	}

	public void setEnemyButtonID() {
		if (enemyMap.getMapXY(getPointX(), getPointY()) != Const.EMPTY_FIELD) {
			enemyButtons[getPointX()][getPointY()].setId("errorShot");
		}
	}

	public void yourTure() {
		// System.out.println("typ: " +
		// enemyButtons[getPointX()][getPointY()].getId());
		// kod, gdy atakujesz statek przeciwnika
		String coordXY;
		// System.out.print("X:=" + getPointX() + " Y=" + getPointY() + "\n");
		coordXY = Integer.toString(getPointX()) + ":" + Integer.toString(getPointY());
		// System.out.println("Wyslalem XY na serwer: " + coordXY);
		Model.connect.sendData(coordXY);
		ServerData serverData = new ServerData("10:" + Model.connect.getData());
		// System.out.println("Po uderzeniu dostalem: " + serverData.getData());

		if (serverData.getTypeOfShot() == Const.MISS) {
			// System.out.println("Po uderzeniu spudlowalem...");
			yourShotMiss(serverData);
		} else if (serverData.getTypeOfShot() == Const.HIT) {
			// System.out.println("Po uderzeniu trafilem!");
			yourShotHit(serverData);
		} else if (serverData.getTypeOfShot() == Const.HIT_AND_SUNK) {
			// System.out.println("Po uderzeniu trafilem i zatopilem!");
			yourShotHitAndSunk(serverData);
		}
		updateImages(Const.ENEMY_IMAGES);
		if (isYouWin(serverData.getStatus())) {
			youWin();
		}
	}

	public void youWin() {
		Model.setPopUpData("popUpPaneYouWin", "Victory", "VICTORY!!");
		try {
			PopUp.display(Model.getPopUpData());
			ClientStart.mainWindow.changeStage("HighScore", "HighScore", 600, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Model.connect.disconnectWithServer();
	}

	public boolean isYouWin(int status) {
		if (status == Const.VICTORY) {
			return true;
		}
		return false;

	}

	public void enemyMissed(ServerData data) {
		// System.out.println("Przeciwnik spudlowal\n Wyslal mi: " +
		// data.getData());
		enemyShotMiss(data.getX(), data.getY());
		updateImages(Const.OWN_IMAGES);
		setActiveTure(Const.YOUR_TURE);
	}

	public void waitForYourTure() {
		Runnable ref = new WaitPlayerThread(shipsLogic);
		Thread thread = new Thread(ref);
		thread.start();

	}

	public boolean isYouDefeated(int status) {
		if (status == Const.DEFEAT) {
			return true;
		} else {
			return false;
		}
	}

	public void youLose() {
		Model.setPopUpData("popUpPaneYouLose", "Lose", "You Lose...");
		Platform.runLater(() -> {
			try {
				PopUp.display(Model.getPopUpData());
				ClientStart.mainWindow.changeStage("HighScore", "HighScore", 600, 400);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		// Model.connect.disconnectWithServer();
	}

}