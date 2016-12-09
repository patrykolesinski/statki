package pl.kielce.tu.kronos.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

import pl.kielce.tu.kronos.logic.Logs;

public class ServerRun {;
	public static final int SERVER_PORT = 8189;
	ServerSocket serverConnection;
	
	public ServerSocket getServerConnection() {
		return serverConnection;
	}

	public void up(){
		try {
			serverConnection = new ServerSocket(SERVER_PORT);
			Logs.LOGGER.info("Server Up. IP: "+InetAddress.getLocalHost().getHostAddress());
		} catch (IOException e) {
			Logs.LOGGER.warning("ERROR: Server Problem: Dont up");
			e.printStackTrace();
		}
	}
	public void down(){
		try {
			serverConnection.close();
			Logs.LOGGER.info("Server Down");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("Server Problem: Dont down");
			e.printStackTrace();
		}
	}
	
}
