package pl.kielce.tu.kronos.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.kielce.tu.kronos.gui.PopUp;
import pl.kielce.tu.kronos.logic.Model;

public class ControllerFXML extends MainWindow implements Initializable {

	public Model model;

	public void initialize(URL location, ResourceBundle resources) {
		model = Model.getInstance();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// BUTTONS AND OTHER STUFF FROM
	////////////////////////////////////////////////////////////////////////////////////////////////////////// FXML//////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	// private Button[][] buttons;

	@FXML
	private Button startGameButton;

	@FXML
	private Button yesButton;

	@FXML
	private Button noButton;

	@FXML
	private TextField hostAddress;

	@FXML
	private PasswordField logInPassInput;

	@FXML
	private TextField logInNameInput;

	@FXML
	private Button signInUserButton;

	@FXML
	private Button registerUserButton;

	@FXML
	private TextField registerNameInput;

	@FXML
	private PasswordField registerPassInput;

	@FXML
	private PasswordField registerRepeatPassInput;

	// private Button tempButton;

	@FXML
	private Button logInButton;

	@FXML
	private Button signInButton;

	@FXML
	private Button popUpButton;

	@FXML
	private Button applyButton;

	@FXML
	private Button registerButton;

	@FXML
	private Button backMenuWindowButton;

	@FXML
	private Button backStartGameButton;

	/*
	 * public void setTemp(ActionEvent e) { this.tempButton = (Button)
	 * e.getSource(); }
	 * 
	 * 
	 * public void setNewStage(Button tempButton) { stage = (Stage)
	 * tempButton.getScene().getWindow(); }
	 */

	public void catchSignInUserButton() throws IOException {

		if (model.catchSignInUserButton(logInNameInput.getText(), logInPassInput.getText())) {
			Model.setOwnNick(logInNameInput.getText());
			changeStage(model.getTitleWindow(), model.getFxml(), 600, 460);
			//changeStage("HighScore", "HighScore", 600, 400);
		} else {
			PopUp.display(model.getPopUpData());
		}

		/*
		 * Model.setOwnNick(logInNameInput.getText());
		 * changeStage("shipslocation", "ShipsLocation", 600, 460);
		 */
	}

	public void catchRegisterUserButton() throws IOException {
		if (model.catchRegisterUserButton(registerNameInput.getText(), registerPassInput.getText(),
				registerRepeatPassInput.getText())) {
			PopUp.display(Model.getPopUpData());
			System.out.println("MODEL?: " + model.getFxml());
			changeStage(model.getTitleWindow(), model.getFxml(), 600, 460);
		} else {
			PopUp.display(Model.getPopUpData());
		}

	}

	public void catchGetHostAddress(String hostAddress) throws IOException {
		model.getHostAddressFromTextField(hostAddress);
		changeStage("Ships - Main Menu", "MenuWindow", 600, 460);
	}

	public void handleButtonAction(ActionEvent event) throws IOException {
		setTemp(event);
		setNewStage();

		if (tempButton == signInUserButton)
			catchSignInUserButton();

		if (tempButton == registerUserButton)
			catchRegisterUserButton();

		if (tempButton == registerButton)
			changeStage("Ships - register", "Register", 600, 460);

		if (tempButton == signInButton)
			changeStage("Ships - LogIn", "SignIn", 600, 460);

		if (tempButton == applyButton)
			catchGetHostAddress(hostAddress.getText());

		if (tempButton == registerButton)
			changeStage("Ships - Register", "Register", 600, 460);

		if (tempButton == backMenuWindowButton)
			changeStage("Ships - Main Menu", "MenuWindow", 600, 460);

		if (tempButton == backStartGameButton)
			changeStage("Ships", "StartGame", 600, 460);

		if (tempButton == yesButton) {
			// Model.connect.disconnectWithServer();
			System.exit(0);
		}

		if (tempButton == noButton)
			stage.close();

	}

}