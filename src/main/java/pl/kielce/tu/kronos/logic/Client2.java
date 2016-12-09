package pl.kielce.tu.kronos.logic;



import pl.kielce.tu.kronos.flagstaff.OneFlagstaff;
import pl.kielce.tu.kronos.network.ClientConnection;

public class Client2 {
	String login;
	String password;
	/** @authenticationSuccess: 0:login failed, go to login page, 1:login successfull, start game, 2:registered completed, 3:registered failed*/
	int authenticationSuccess=0;
	/** @action 1:register; 2:login */
	Integer action;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAuthenticationSuccess() {
		return authenticationSuccess;
	}
	public void setAuthenticationSuccess(int authenticationSuccess) {
		this.authenticationSuccess = authenticationSuccess;
	}
	public Integer getAction() {
		return action;
	}
	public void setAction(Integer action) {
		this.action = action;
	}
	
	public static void main(String[] args) {
		
		//nie dziala i juz dzialac nie bedzie nigdy
		ClientConnection connect = new ClientConnection();
		Client2 client = new Client2();
		String serverHost;
		serverHost="127.0.0.1"; //Adres ip pozyskiwany z okienka
		
		
		connect.connectWithServer(serverHost);
		Player player = new Player(0,"Test");
		//player.setShip(new OneFlagstaff(5,7),0);
		Player player2 = new Player(1,"Test2");
		String data = "test";
		player.getMap().setMapXY(1, 1, Const.EMPTY_FIELD);
		connect.sendData(data);
		connect.sendPlayer(player);
    	connect.sendPlayer(player2);
		connect.disconnectWithServer();
		
		
	}
}
