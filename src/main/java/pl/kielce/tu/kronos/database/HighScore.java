package pl.kielce.tu.kronos.database;

import java.io.Serializable;

public class HighScore implements Serializable {
	private int number;
	private String nick;
	private int wins;

	public HighScore(int number, String nick, int wins) {
		this.nick = nick;
		this.wins = wins;
		this.number = number;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
}
