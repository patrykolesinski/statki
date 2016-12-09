package pl.kielce.tu.kronos.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import pl.kielce.tu.kronos.database.HighScores;
import pl.kielce.tu.kronos.logic.Logs;
import pl.kielce.tu.kronos.logic.Player;

public class ServerConnection {
	private Socket incoming;
	private boolean ready = false;

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public void connectWithClient(ServerSocket serverConnection) {
		try {
			Logs.LOGGER.info("Wainting for client...");
			incoming = serverConnection.accept();
			Logs.LOGGER.info("Client connected. Incomming: " + incoming.toString());
		} catch (IOException e) {
			Logs.LOGGER.warning("Client connect problem");
			e.printStackTrace();
		}

	}

	public void disconnectWithClient() {
		try {
			incoming.close();
			Logs.LOGGER.info("Client disconnected");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("Client disconnect problem");
			e.printStackTrace();
		}

	}

	public void sendData(String data) {
		OutputStream outStream;
		try {
			outStream = incoming.getOutputStream();
			PrintWriter out = new PrintWriter(outStream, true);
			out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("Server sendData problem");
			e.printStackTrace();
		}

	}

	public String getData() {
		InputStream inStream;
		String data = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
			// inStream = incoming.getInputStream();
			// Scanner in = new Scanner(inStream);
			data = in.readLine();
			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("Server getData problem");
			e.printStackTrace();
		}
		return data;
	}

	public Player getPlayer() throws IOException {
		Player player = null;
		ObjectInputStream ois;
		ois = new ObjectInputStream(incoming.getInputStream());
		try {
			player = (Player) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}

	public void sendPlayer(Player player) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(incoming.getOutputStream());
			oos.writeObject(player);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HighScores getHighScores() throws IOException {
		HighScores hs = null;
		ObjectInputStream ois;
		ois = new ObjectInputStream(incoming.getInputStream());
		try {
			hs = (HighScores) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hs;
	}

	public void sendHighScores(HighScores hs) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(incoming.getOutputStream());
			oos.writeObject(hs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
