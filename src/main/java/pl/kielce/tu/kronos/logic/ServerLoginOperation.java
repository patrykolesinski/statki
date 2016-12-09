package pl.kielce.tu.kronos.logic;

import pl.kielce.tu.kronos.database.DatabaseConnection;
import pl.kielce.tu.kronos.flagstaff.FourFlagstaff;
import pl.kielce.tu.kronos.flagstaff.OneFlagstaff;
import pl.kielce.tu.kronos.network.ServerConnection;
import pl.kielce.tu.kronos.network.ServerRun;

public class ServerLoginOperation {
	public static  Player loginAuthentication(ServerConnection client, ServerRun server, DatabaseConnection database,
			Player player2) {
		String tab[] = null;
		String data = null;
		String login = null;
		String password = null;
		int action;
		Player player = null;
		client.connectWithClient(server.getServerConnection());
		data = client.getData();
		tab = data.split(":");
		login = tab[0];
		password = tab[1];
		action = Integer.parseInt(tab[2]);
		if (action == 2) {
			if (database.isAuthenticationOk(login, password)) {
				player = database.getPlayer(login);
				if (player2 != null && player.getId() == player2.getId()) {
					Logs.LOGGER.info("Connection problem, this login is already connected");
					player = null;
					client.sendData("4");
				} else {
					Logs.LOGGER.info("Authentication success, player created. ID: " + player.getId() + " Login: " + player.getLogin());
					client.setReady(true);
					client.sendData("1");
				}

			} else {
				Logs.LOGGER.info("Authentication failure");
				client.sendData("0");
				client.disconnectWithClient();
			}
		}
		if (action == 1) {
			if (database.isLoginExist(login)) {
				Logs.LOGGER.info("Player registered problem. Login is exist");
				client.sendData("3");
				client.disconnectWithClient();
			} else {
				Logs.LOGGER.info("Player registered successfull");
				database.createAccount(login, password);
				client.sendData("2");
				client.disconnectWithClient();
			}
		}
		return player;
	}
	
	
}


