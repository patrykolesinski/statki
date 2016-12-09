package pl.kielce.tu.kronos.logic;

import java.io.IOException;
import pl.kielce.tu.kronos.network.ClientConnection;

public class Model {

	private static Model model = null;

	private Model() {
	}

	public static Model getInstance() {
		if (model == null) {
			model = new Model();
		}

		return model;
	}

	public static String ownNick;

	/*
	 * public String getOwnNick() { return ownNick; }
	 * 
	 * public void setOwnNick(String ownNick) { this.ownNick = ownNick; }
	 */

	public static String getOwnNick() {
		return ownNick;
	}

	public static void setOwnNick(String ownNick) {
		Model.ownNick = ownNick;
	}

	/** Adres hosta */
	private String serverHost;

	/** Dane ktore beda wysylane do hosta */
	private String data;

	/** Dane ktore sie wyswietlaja w okienku + typ okienka */
	private static String popUpData;

	/** Nazwa glownego okna */
	private String TitleWindow;

	/** nazwa pliku fxml dla glownego okna */
	private String fxml;

	public String getTitleWindow() {
		return TitleWindow;
	}

	public void setTitleWindow(String titleWindow) {
		this.TitleWindow = titleWindow;
	}

	public String getFxml() {
		return fxml;
	}

	public void setFxml(String fxml) {
		this.fxml = fxml;
	}

	/** pole przechowujace dostep do klasy typu Client */
	public static Client client;

	/** pole przechowujace dostep do klasy typu ClientConnection */
	public static ClientConnection connect;

	public static ClientConnection getConnect() {
		return connect;
	}

	public static void setConnect(ClientConnection connect) {
		Model.connect = connect;
	}

	public String getData() {
		return data;
	}

	/**
	 * ustawia dane do wyslania na serwer
	 */
	public void setData() {
		this.data = client.getLogin() + ":" + client.getPassword() + ":" + client.getAction().toString();
		;
	}

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}

	public static String getPopUpData() {
		return Model.popUpData;
	}

	/**
	 * 
	 * @param numberPopUp
	 *            typ okna 1-dobrze, 2-zle, 3-wygrana, 4-przegrana
	 * @param title
	 *            tytul PopUp'a
	 * @param description
	 *            opis ktory jest wyswietlany w PopUp'ie
	 */
	public static void setPopUpData(String numberPopUp, String title, String description) {
		Model.popUpData = numberPopUp + ":" + title + ":" + description;
	}

	public void printfCos() {
		System.out.println("To sie cod druknelo!");
	}

	/**
	 * 
	 * @param passInput
	 *            haslo podane podczas rejestracji
	 * @param repeatPassInput
	 *            ponowne haslo podane podczas rejestracji
	 * @return true - gdy nowy uztkownik sie utworzy, false - gdy problem z
	 *         walidacja formularza
	 * @throws IOException
	 *             - blad gdy cos sie nie uda
	 */
	public boolean checkPasswordAndLoginFromRegister(String passInput, String repeatPassInput) throws IOException {
		if (passInput.equals(repeatPassInput) && !passInput.isEmpty() && !repeatPassInput.isEmpty()) {
			return true;
		} else {
			setPopUpData("popUpPaneError", "Error registrating",
					"Occur one of this problem \n1. Login or password is empty \n 2. Password and repeat password are different");
			return false;
		}
	}

	/**
	 * 
	 * @param nameInput
	 *            login podany podczas logowania
	 * @param passInput
	 *            haslo podane podczas logowania
	 * @return true - walidacja formularza pomyslna, false - walidacja
	 *         niepomyslna
	 */
	public boolean checkPasswordAndLoginFromSignIn(String nameInput, String passInput) {
		if (!nameInput.isEmpty() && !passInput.isEmpty()) {
			return true;
		} else {
			setPopUpData("popUpPaneError", "Error signing", "Login or password is empty...");
			return false;
		}
	}

	/**
	 * 
	 * @param pobiera
	 *            adres hosta z pola tekstowego i zapisuje go do pola ServerHost
	 * @throws IOException
	 */

	public void getHostAddressFromTextField(String hostAddress) throws IOException {
		setServerHost(hostAddress);
	}

	/**
	 * 
	 * @param nameInput
	 *            login z okna logowania
	 * @param passInput
	 *            haslo z okna logowania
	 */
	public void getUsernameAndPasswordFromSignIn(String nameInput, String passInput) {
		client = new Client();
		client.setLogin(nameInput);
		client.setPassword(passInput);
		client.setAction(2);
		setData();
	}

	/**
	 * 
	 * @param registerNameInput
	 *            login z okna rejestracji
	 * @param registerPassInput
	 *            haslo z okna rejestracji
	 */
	public void getUsernameAndPasswordFromRegister(String registerNameInput, String registerPassInput) {
		client = new Client();
		client.setLogin(registerNameInput);
		client.setPassword(registerPassInput);
		client.setAction(1);
		setData();
	}

	/**
	 * 
	 * @return numer popupa, czyli co ma sie zrobic po polaczeniu z serwerem
	 * @throws IOException
	 */
	public int runConnectWithServer() throws IOException {
		connect = new ClientConnection();

		if (connect.connectWithServer(serverHost)) {
			return runClientAuthorisation();
		} else {

			setPopUpData("popUpPaneError", "Server error", "Error during connection with server...");
			return 0;
		}
	}

	/**
	 * 
	 * @return 1 udalo sie cos zrobic na serwerze, 0 - jakis problem, -1
	 *         nieoczekiwany blad
	 * @throws IOException
	 */
	public int runClientAuthorisation() throws IOException {
		connect.sendData(data);
		client.setAuthenticationSuccess(Integer.parseInt(connect.getData()));

		if (client.getAuthenticationSuccess() == 1) {
			// Wlaczenie okienka gry
			System.out.println("Login completed. Start game");
			setTitleWindow("Ships - Set ships");
			setFxml("ShipsLocation");
			return 1;

		}
		if (client.getAuthenticationSuccess() == 2) {
			connect.disconnectWithServer();
			// Wlaczenie okienka logowania
			System.out.println("Registration completed");
			setPopUpData("popUpPaneGood", "Registration", "Registration completed successfull\n Now you can sign in");
			setTitleWindow("Ships - LogIn");
			setFxml("SignIn");
			return 1;
		}
		if (client.getAuthenticationSuccess() == 3) {
			connect.disconnectWithServer();
			// Powrot do rejestracji
			// System.out.println("Registration failed. Login is already
			// exist");
			setPopUpData("popUpPaneError", "Error registration", "This login is already in use...");
			return 0;
		}
		if (client.getAuthenticationSuccess() == 4) {
			connect.disconnectWithServer();
			// Powrot do logowania
			// System.out.println("Connection problem, this user is already
			// connected");
			setPopUpData("popUpPaneError", "Error signing", "This user is already connected...");
			return 0;
		}
		if (client.getAuthenticationSuccess() == 0) {
			connect.disconnectWithServer();
			// powrot do logowania
			System.out.println("Login failed. Wrong login or password.");
			setPopUpData("popUpPaneError", "Error signing", "Wrong login or password...");
			return 0;
		}

		// gdy nie stanie sie zadne z tych
		setPopUpData("popUpPaneError", "Error", "Occur an unecpected error");
		return -1;
	}
	
	

	/**
	 * 
	 * @param registerPassInput
	 *            haslo z okna rejestracji
	 * @param registerRepeatPassInput
	 *            powtorzone haslo z okna rejestracji
	 * @return true - wszystko zakonczone pomyslnie, false - jakis blad sie
	 *         pojawil na serwerze
	 * @throws IOException
	 */
	public boolean catchRegisterUserButton(String registerUserName, String registerPassInput, String registerRepeatPassInput)
			throws IOException {

		if (checkPasswordAndLoginFromRegister(registerPassInput, registerRepeatPassInput)) {
			getUsernameAndPasswordFromRegister(registerUserName, registerRepeatPassInput);

			int temp;
			temp = runConnectWithServer();
			if (temp == 0 || temp == -1) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param logInNameInput
	 *            login z okna logowania
	 * @param logInPassInput
	 *            haslo z okna logowania
	 * @return 1 - wszystko zakonczone pomyslnie, mozna w okienku przejsc dalej,
	 *         0- blad, -1 nieoczekiwany blad
	 * @throws IOException
	 */
	public boolean catchSignInUserButton(String logInNameInput, String logInPassInput) throws IOException {
		if (model.checkPasswordAndLoginFromSignIn(logInNameInput, logInPassInput)) {
			model.getUsernameAndPasswordFromSignIn(logInNameInput, logInPassInput);

			int temp;
			temp = runConnectWithServer();
			if (temp == 0 || temp == -1) {
				return false;
			} else {
				return true;
			}

		} else {
			return false;
		}
	}

}