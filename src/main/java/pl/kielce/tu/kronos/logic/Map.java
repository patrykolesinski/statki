package pl.kielce.tu.kronos.logic;

import java.io.Serializable;

public class Map implements Serializable {
	/// **@map 0-czysty, 1-pud³o, 2-trafiony, 3-zatopiony, 4-ustawiony,
	/// 5-blokada*/



	/**
	 * <pre>
	 * 0 - pusty obszar
	 * 1 - statek ustawiony w danym miejscu
	 * 2 - statek trafiony
	 * 3 - zatopiony
	 * 4 - pudlo
	 * 9 - zablokowany obszar
	 * </pre>
	 */
	private int map[][];

	public Map() {
		map = new int[10][10];
		// int i,j;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.map[i][j] = 0;
			}
		}
	}

	public void setMapXY(int x, int y, int type) {
		map[x][y] = type;
	}

	public int getMapXY(int x, int y) {
		return map[x][y];// = type;
	}

	public void print() {
		int i, j;
		for (i = 0; i < 10; i++) {
			for (j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	/*
	 * public void testStrzal(){ map[1][1]=1; }
	 */

	public static void main(String[] args) {
		// Player player=new Player(0,"Marek");
		// player.getMap().print();
		// player.getMap().testStrzal();
		// player.getMap().print();
	}

	public void setBlockedFields(int x, int y) {
		// 1: x-1, y-1
		if ((x - 1 >= 0) && (y - 1 >= 0)) {
			if (getMapXY(x - 1, y - 1) == Const.EMPTY_FIELD) {
				setMapXY(x - 1, y - 1, Const.BLOCKED_FIELD);
			}
		}
		// 2: y-1
		if (y - 1 >= 0) {
			if (getMapXY(x, y - 1) == Const.EMPTY_FIELD) {
				setMapXY(x, y - 1, Const.BLOCKED_FIELD);
			}
		}

		// 3: x+1, y-1
		if ((x + 1 <= 9) && (y - 1 >= 0)) {
			if (getMapXY(x + 1, y - 1) == Const.EMPTY_FIELD) {
				setMapXY(x + 1, y - 1, Const.BLOCKED_FIELD);
			}
		}

		// 4: x-1
		if (x - 1 >= 0) {
			if (getMapXY(x - 1, y) == Const.EMPTY_FIELD) {
				setMapXY(x - 1, y, Const.BLOCKED_FIELD);
			}
		}

		// 5: x+1
		if (x + 1 <= 9) {
			if (getMapXY(x + 1, y) == Const.EMPTY_FIELD) {
				setMapXY(x + 1, y, Const.BLOCKED_FIELD);
			}
		}

		// 6: x-1, y-1
		if ((x - 1 >= 0) && (y + 1 <= 9)) {
			if (getMapXY(x - 1, y + 1) == Const.EMPTY_FIELD) {
				setMapXY(x - 1, y + 1, Const.BLOCKED_FIELD);
			}
		}
		// 2: y+1
		if (y + 1 <= 9) {
			if (getMapXY(x, y + 1) == Const.EMPTY_FIELD) {
				setMapXY(x, y + 1, Const.BLOCKED_FIELD);
			}
		}

		// 3: x+1, y+1
		if ((x + 1 <= 9) && (y + 1 <= 9)) {
			if (getMapXY(x + 1, y + 1) == Const.EMPTY_FIELD) {
				setMapXY(x + 1, y + 1, Const.BLOCKED_FIELD);
			}
		}
	}

	public void setShip(int x, int y, int type) {
		setMapXY(x, y, type);
	}

	public void setHBlockedFields(int pointX, int pointY, int lengthFlagstaff) {
		for (int x = pointX; x < pointX + lengthFlagstaff; x++) {
			setBlockedFields(x, pointY);
		}
	}

	public void setHShipOnMap(int pointX, int pointY, int lengthFlagstaff) {
		for (int x = pointX; x < pointX + lengthFlagstaff; x++) {
			setShip(x, pointY, Const.SET_FLAGSTAFF);
		}
		setHBlockedFields(pointX, pointY, lengthFlagstaff);
	}
	
	public void setHSunkShipOnMap(int pointX, int pointY, int lengthFlagstaff) {
		System.out.println("X=" + pointX + "Y=" + pointY);
		int a = pointX + lengthFlagstaff;
		System.out.println("Dlugosc: " +  a);
		for (int x = pointX; x < pointX + lengthFlagstaff; x++) {
			setShip(x, pointY, Const.SUNK_FLAGSTAFF);
		}
		setHBlockedFields(pointX, pointY, lengthFlagstaff);
	}

	public void setVBlockedFields(int pointX, int pointY, int lengthFlagstaff) {
		for (int y = pointY; y < pointY + lengthFlagstaff; y++) {
			setBlockedFields(pointX, y);
		}
	}

	public void setVShipOnMap(int pointX, int pointY, int lengthFlagstaff) {
		for (int y = pointY; y < pointY + lengthFlagstaff; y++) {
			setShip(pointX, y, Const.SET_FLAGSTAFF);
		}
		setVBlockedFields(pointX, pointY, lengthFlagstaff);
	}
	
	public void removeBlockedFields() {
		for (int x=0; x<10; x++) {
			for (int y=0; y<10; y++) {
				if (getMapXY(x, y) == Const.BLOCKED_FIELD) {
					setShip(x, y, Const.EMPTY_FIELD);
				}
			}
		}
	}
	
	public void setVSunkShipOnMap(int pointX, int pointY, int lengthFlagstaff) {
		System.out.println("X=" + pointX + "Y=" + pointY);
		int a = pointY + lengthFlagstaff;
		System.out.println("Dlugosc: " +  a);
		for (int y = pointY; y < pointY + lengthFlagstaff; y++) {
			setShip(pointX, y, Const.SUNK_FLAGSTAFF);
		}
		setVBlockedFields(pointX, pointY, lengthFlagstaff);
	}

	public void updateMap(int x, int y, int lengthFlagstaff, String orientation) {
		if (orientation.equals("Horizontal")) {
			setHShipOnMap(x, y, lengthFlagstaff);
		} else if (orientation.equals("Vertical")) {
			setVShipOnMap(x, y, lengthFlagstaff);
		}
	}

	public boolean isHit(int x, int y) {
		if (map[x][y] == Const.SET_FLAGSTAFF) {
			return true;
		}
		return false;
	}

	public void hit(int x, int y) {
		map[x][y] = Const.HIT_FLAGSTAFF;
	}

	public void sunk(int x, int y) {
		map[x][y] = Const.SUNK_FLAGSTAFF;
	}

	public void miss(int x, int y) {
		map[x][y] = Const.MISS_FIELD;
	}

}
