package pl.kielce.tu.kronos.logic;

import pl.kielce.tu.kronos.database.DatabaseConnection;
import pl.kielce.tu.kronos.flagstaff.Flagstaff;
import pl.kielce.tu.kronos.flagstaff.FourFlagstaff;
import pl.kielce.tu.kronos.flagstaff.OneFlagstaff;
import pl.kielce.tu.kronos.flagstaff.ThreeFlagstaff;
import pl.kielce.tu.kronos.flagstaff.TwoFlagstaff;
import pl.kielce.tu.kronos.network.ServerConnection;

public class ServerGameOperation {
	public static void decodeXY(String data, int x, int y) {
		String[] tab = data.split(":");
		x = Integer.parseInt(tab[0]);
		y = Integer.parseInt(tab[1]);
	}

	public static void turePlayer(ServerConnection clientCurrent, ServerConnection clientEnemy, Player playerCurrent,
			Player playerEnemy, int idGame, int ture, DatabaseConnection database) {
		int x, y;
		String getData, sendData;
		getData = clientCurrent.getData();
		String[] tab = getData.split(":");
		x = Integer.parseInt(tab[0]);
		y = Integer.parseInt(tab[1]);
		if (playerEnemy.getMap().isHit(x, y)) {
			OneFlagstaff ship = ServerGameOperation.searchShip(playerEnemy, x, y);
			String cord = ServerGameOperation.hitShip(playerEnemy, ship, x, y);
			if (ship.isSunk()) {
				playerEnemy.incSunkShips();
				if (playerEnemy.getSunkShips() == 10) {
					sendData = Byte.toString(Const.HIT_AND_SUNK) + ":" + cord + ":" + ship.getLength() + ":"
							+ ship.getOrientation() + ":" + Byte.toString(Const.VICTORY);
					clientCurrent.sendData(sendData);
					sendData = Byte.toString(Const.HIT_AND_SUNK) + ":" + cord + ":" + ship.getLength() + ":"
							+ ship.getOrientation() + ":" + Byte.toString(Const.DEFEAT);
					clientEnemy.sendData(Byte.toString(Const.ENEMY_TURE) + ":" + sendData);
					database.insertProgress(idGame, playerCurrent.getId(), ture,
							Integer.toString(x) + ":" + Integer.toString(y), Const.HIT_AND_SUNK);
					database.updateIdWinner(idGame, playerCurrent.getId());
				} else {
					sendData = Byte.toString(Const.HIT_AND_SUNK) + ":" + cord + ":" + ship.getLength() + ":"
							+ ship.getOrientation() + ":" + Byte.toString(Const.HIT_AND_SUNK);
					clientCurrent.sendData(sendData);
					clientEnemy.sendData(Byte.toString(Const.ENEMY_TURE) + ":" + sendData);

					database.insertProgress(idGame, playerCurrent.getId(), ture,
							Integer.toString(x) + ":" + Integer.toString(y), Const.HIT_AND_SUNK);
				}
			} else {
				sendData = Byte.toString(Const.HIT) + ":" + getData;
				clientCurrent.sendData(sendData);
				clientEnemy.sendData(Byte.toString(Const.ENEMY_TURE) + ":" + sendData);
				database.insertProgress(idGame, playerCurrent.getId(), ture,
						Integer.toString(x) + ":" + Integer.toString(y), Const.HIT);
			}
		} else {
			sendData = Byte.toString(Const.MISS) + ":" + getData;
			clientCurrent.sendData(sendData);
			clientEnemy.sendData(Byte.toString(Const.YOUR_TURE) + ":" + sendData);
			playerCurrent.setTure(false);
			playerEnemy.setTure(true);
			database.insertProgress(idGame, playerCurrent.getId(), ture,
					Integer.toString(x) + ":" + Integer.toString(y), Const.MISS);
		}
	}

	public static boolean fieldIsFourflagstaff(FourFlagstaff ship, int x, int y) {
		if ((ship.getX1Point() == x) && (ship.getY1Point() == y)) {
			return true;
		} else if ((ship.getX2Point() == x) && (ship.getY2Point() == y)) {
			return true;
		} else if ((ship.getX3Point() == x) && (ship.getY3Point() == y)) {
			return true;
		} else if ((ship.getX4Point() == x) && (ship.getY4Point() == y)) {
			return true;
		}

		return false;
	}

	public static boolean fieldsInThreeFlagstaff(ThreeFlagstaff ship, int x, int y) {
		if ((ship.getX1Point() == x) && (ship.getY1Point() == y)) {
			return true;
		} else if ((ship.getX2Point() == x) && (ship.getY2Point() == y)) {
			return true;
		} else if ((ship.getX3Point() == x) && (ship.getY3Point() == y)) {
			return true;
		}
		return false;
	}

	public static boolean fieldsInTwoFlagstaff(TwoFlagstaff ship, int x, int y) {
		if ((ship.getX1Point() == x) && (ship.getY1Point() == y)) {
			return true;
		} else if ((ship.getX2Point() == x) && (ship.getY2Point() == y)) {
			return true;
		}
		return false;
	}

	public static boolean fieldsInOneFlagstaff(OneFlagstaff ship, int x, int y) {
		if ((ship.getX1Point() == x) && (ship.getY1Point() == y)) {
			return true;
		}
		return false;
	}

	public static OneFlagstaff searchShip(Player player, int x, int y) {

		FourFlagstaff ship;

		if (fieldIsFourflagstaff(player.getFourFlagstaff(0), x, y)) {
			return (OneFlagstaff) player.getFourFlagstaff(0);
		}

		for (int i = 0; i < 2; i++) {
			if (fieldsInThreeFlagstaff(player.getThreeFlagstaff(i), x, y)) {
				return (OneFlagstaff) player.getThreeFlagstaff(i);
			}
		}

		for (int i = 0; i < 3; i++) {
			if (fieldsInTwoFlagstaff(player.getTwoFlagstaff(i), x, y)) {
				return (OneFlagstaff) player.getTwoFlagstaff(i);
			}
		}

		for (int i = 0; i < 4; i++) {
			if (fieldsInOneFlagstaff(player.getOneFlagstaff(i), x, y)) {
				return player.getOneFlagstaff(i);
			}
		}

		return new OneFlagstaff();

	}

	public static String hitShip(Player player, OneFlagstaff ship, int x, int y) {
		player.getMap().setMapXY(x, y, Const.HIT_FLAGSTAFF);
		ship.lives--;
		if (ship.getLives() == 0) {
			ship.setSunk(true);
		}
		return Integer.toString(ship.getX1Point()) + ":" + Integer.toString(ship.getY1Point());
	}
}
