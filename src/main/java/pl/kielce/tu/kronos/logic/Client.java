package pl.kielce.tu.kronos.logic;



import pl.kielce.tu.kronos.network.ClientConnection;

public class Client {
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
		String data;
		ClientConnection connect = new ClientConnection();
		Client client = new Client();
		String serverHost;
		serverHost="127.0.0.1"; //Adres ip pozyskiwany z okienka
		
		client.setLogin("test2"); //Bedzie pobierane z gui
		client.setPassword("test2"); //Bedzie pobierane z gui
		client.setAction(2); //Bedzie pobierane z gui
		
		data=client.getLogin()+":"+client.getPassword()+":"+client.getAction().toString();
		
		connect.connectWithServer(serverHost);
		
		connect.sendData(data);
		client.setAuthenticationSuccess(Integer.parseInt(connect.getData()));
		if(client.getAuthenticationSuccess()==1){
			//Wlaczenie okienka gry
			System.out.println("Login completed. Start game");
		}
		if(client.getAuthenticationSuccess()==2) {
			connect.disconnectWithServer();
			//Wlaczenie okienka logowania
			System.out.println("Registration completed");
		}
		if(client.getAuthenticationSuccess()==3) {
			connect.disconnectWithServer();
			//Powrot do rejestracji
			System.out.println("Registration failed. Login is exist");
		}
		if(client.getAuthenticationSuccess()==4) {
			connect.disconnectWithServer();
			//Powrot do logowania
			System.out.println("Connection problem, this user is already connected");
		}
		if(client.getAuthenticationSuccess()==0) {
			connect.disconnectWithServer();
			//powrot do logowania
			System.out.println("Login failed. Wrong login or password.");
		}
	}
}
