package pl.kielce.tu.kronos.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import pl.kielce.tu.kronos.logic.Logs;
import pl.kielce.tu.kronos.logic.Player;

import java.sql.Connection;

public class DatabaseConnection {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DATABASE_URL = "78.46.43.228:3306";
	private final String DATABASE_NAME = "starysad_statki";
	private final String DATABASE_USER = "starysad_statki";
	private final String DATABASE_PASSWORD = "Statki2016";
	private Connection databaseConnection;

	public void connect() {
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			databaseConnection = DriverManager.getConnection("jdbc:mysql://" + DATABASE_URL + "/" + DATABASE_NAME
					+ "?user=" + DATABASE_USER + "&password=" + DATABASE_PASSWORD);
			Logs.LOGGER.info("Database Connected");
		} catch (SQLException ex) {
			Logs.LOGGER.warning("Connection problem");
			ex.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			databaseConnection.close();
			Logs.LOGGER.info("Database Disonnected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isAuthenticationOk(String login, String password) {
		boolean authentication = false;
		try {
			Statement statement = databaseConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM player WHERE LOGIN=\"" + login + "\" AND PASSWORD=\"" + password + "\"");
			if (resultSet.next()) {
				authentication = true;
			} else {
				authentication = false;
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("Authentication problem. Database problem");
			e.printStackTrace();
		}
		return authentication;
	}

	public boolean isLoginExist(String login) {
		boolean authentication = false;
		try {
			Statement statement = databaseConnection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM player WHERE LOGIN=\"" + login + "\"");
			if (resultSet.next()) {
				authentication = true;
			} else {
				authentication = false;
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("isLoginExist problem. Database problem");
			e.printStackTrace();
		}
		return authentication;
	}

	public Player getPlayer(String login) {
		Player player = null;
		try {
			Statement statement = databaseConnection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM player WHERE LOGIN=\"" + login + "\"");
			resultSet.next();
			player = new Player(resultSet.getInt(1), resultSet.getString(2));
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("getPlayer problem. Database problem");
			e.printStackTrace();
		}
		return player;
	}

	public void createAccount(String login, String password) {
		try {
			Statement statement = databaseConnection.createStatement();
			statement.executeUpdate("INSERT INTO player(ID_PLAYER,LOGIN,PASSWORD) VALUES (null,\"" + login + "\",\""
					+ password + "\")");
			statement.close();
			Logs.LOGGER.info("Database: Account Created");
		} catch (SQLException e) {
			Logs.LOGGER.warning("createAccount problem. Database problem");
			e.printStackTrace();
		}
	}

	public int insertGame(int idPlayer1, int idPlayer2) {
		int idGame = 0;
		Statement statement;
		try {
			statement = databaseConnection.createStatement();

			statement.executeUpdate("INSERT INTO game(ID_GAME,ID_PLAYER1,ID_PLAYER2,DATE,ID_WINNER) VALUES (null,\""
					+ idPlayer1 + "\",\"" + idPlayer2 + "\",null,null)");
			statement.close();
			Logs.LOGGER.info("Database: Game Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("Insert game problem. Database problem");
			e.printStackTrace();
		}
		try {
			statement = databaseConnection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM game WHERE ID_PLAYER1=\"" + idPlayer1
					+ "\" AND ID_PLAYER2=\"" + idPlayer2 + "\" AND ID_WINNER IS NULL");
			resultSet.next();
			idGame = resultSet.getInt(1);
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			Logs.LOGGER.warning("Select idGame problem. Database problem");
			e.printStackTrace();
		}
		return idGame;
	}

	public void updateIdWinner(int idGame, int idWinner) {
		try {
			Statement statement = databaseConnection.createStatement();
			statement.executeUpdate("UPDATE game SET ID_WINNER=\"" + idWinner + "\" WHERE ID_GAME=\"" + idGame + "\"");
			statement.close();
			Logs.LOGGER.info("Database: Winner updated");
		} catch (SQLException e) {
			Logs.LOGGER.warning("Update idWinner problem. Database problem");
			e.printStackTrace();
		}
	}

	public void insertProgress(int idGame, int idPlayer, int ture, String cord, int status) {
		Statement statement;
		try {
			statement = databaseConnection.createStatement();

			statement.executeUpdate(
					"INSERT INTO progress(ID_PROGRESS,ID_GAME,TURE,ID_PLAYER,CORD,STATUS) VALUES (null,\"" + idGame
							+ "\",\"" + ture + "\",\"" + idPlayer + "\",\"" + cord + "\",\"" + status + "\")");
			statement.close();
			Logs.LOGGER.info("Database: Progress Inserted");
		} catch (SQLException e) {
			Logs.LOGGER.warning("Insert game problem. Database problem");
			e.printStackTrace();
		}
	}

	public HighScores getHighScores() {
		HighScores hs = new HighScores();
		try {
			Statement statement = databaseConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT player.LOGIN,COUNT(game.ID_WINNER) FROM game,player WHERE game.ID_WINNER = player.ID_PLAYER GROUP BY game.ID_WINNER ORDER BY (COUNT(game.ID_WINNER)) DESC");
			int number = 1;
			for (int i = 0; i < 10; i++) {
				if (!resultSet.isAfterLast()) {
					if (resultSet.isLast()) {
						resultSet.next();
					} else {
						resultSet.next();
						hs.getHsArray().add(new HighScore(number, resultSet.getString(1), resultSet.getInt(2)));
						number++;
					}
				}
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logs.LOGGER.warning("getHighScores problem. Database problem");
			e.printStackTrace();
		}
		return hs;
	}
}
