package pl.kielce.tu.kronos.logic;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Random;

import pl.kielce.tu.kronos.database.DatabaseConnection;
import pl.kielce.tu.kronos.database.HighScore;
import pl.kielce.tu.kronos.database.HighScores;
import pl.kielce.tu.kronos.flagstaff.FourFlagstaff;
import pl.kielce.tu.kronos.network.ServerConnection;
import pl.kielce.tu.kronos.network.ServerRun;

public class Server {
	public static void main(String[] args) throws IOException {

		Logs.logsToFileOn("ServerLogs");

		DatabaseConnection database = new DatabaseConnection();
		database.connect();

		ServerRun server = new ServerRun();
		server.up();

		ServerConnection client1 = new ServerConnection();
		ServerConnection client2 = new ServerConnection();

		Player player1 = null;
		Player player2 = null;

		while (!client1.isReady() || !client2.isReady()) {
			if (!client1.isReady()) {
				player1 = ServerLoginOperation.loginAuthentication(client1, server, database, player2);
			}
			if (!client2.isReady()) {
				player2 = ServerLoginOperation.loginAuthentication(client2, server, database, player1);
			}
		}
		/////////////////////

		client1.sendData(Integer.toString(player1.getId())+":"+player2.getLogin()+":"+Byte.toString(Const.YOUR_TURE));
		client2.sendData(Integer.toString(player2.getId())+":"+player1.getLogin()+":"+Byte.toString(Const.ENEMY_TURE));

		player1 = client1.getPlayer();
		player2 = client2.getPlayer();

		Logs.LOGGER.info("Player 1 nick: " + player1.getLogin() + " ID: " + player1.getId());
		Logs.LOGGER.info("Player 2 nick: " + player2.getLogin() + " ID: " + player2.getId());
		//client1.sendData(player2.getLogin());
		//client1.sendData(Byte.toString(Const.YOUR_TURE));
		player1.setTure(true);

		//client2.sendData(player1.getLogin());
		//client2.sendData(Byte.toString(Const.ENEMY_TURE));
		player2.setTure(false);
		int idGame = database.insertGame(player1.getId(), player2.getId());
		int ture = 1;
		while (player1.getSunkShips() != 10 && player2.getSunkShips() != 10) {
			if (player1.isTure()) {
				ServerGameOperation.turePlayer(client1, client2, player1, player2, idGame, ture, database);
			} else {
				ServerGameOperation.turePlayer(client2, client1, player2, player1, idGame, ture, database);
			}
			ture++;
		}

		HighScores hs = database.getHighScores();
		client1.sendHighScores(hs);
		client2.sendHighScores(hs);
		database.disconnect();
		client1.disconnectWithClient();
		client2.disconnectWithClient();
		server.down();
	}
}
