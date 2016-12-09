package pl.kielce.tu.kronos.flagstaff;

public class TwoFlagstaff extends OneFlagstaff {

	protected int x2Point, y2Point;

	public TwoFlagstaff() {
		super();
		this.length=2;
		this.lives=2;
	}

	public void setCoordinates(int x1, int y1, String orientation) {
		super.setCoordinates(x1, y1, orientation);

		if (orientation.equals("Vertical")) {
			this.y2Point = y1Point + 1;
			this.x2Point = x1;
		}

		if (orientation.equals("Horizontal")) {
			this.y2Point = y1;
			this.x2Point = x1Point + 1;
		}

	}
	
	

	public int getX2Point() {
		return x2Point;
	}

	public int getY2Point() {
		return y2Point;
	}

	public void setX2Point(int x2Point) {
		this.x2Point = x2Point;
	}

	public void setY2Point(int y2Point) {
		this.y2Point = y2Point;
	}



	private static byte number2Flagstaff = 0;

	public static byte getNumber2Flagstaff() {
		return number2Flagstaff;
	}

	public static void setNumber2Flagstaff(byte number2Flagstaff) {
		TwoFlagstaff.number2Flagstaff = number2Flagstaff;
	}

	public static void incNumber2Flagstaff() {
		TwoFlagstaff.number2Flagstaff++;
	}

	public static void resetNumber2Flagstaff() {
		TwoFlagstaff.number2Flagstaff = 0;
	}

	public static byte MAX_NUMBER_TWO_FLAGSTAFF = 3;

	@Override
	public boolean setFlagstaff(int x1, int y1, String orientation) {
		if (TwoFlagstaff.getNumber2Flagstaff() == MAX_NUMBER_TWO_FLAGSTAFF) {
			return false;
		} else {

			setCoordinates(x1, y1, orientation);
			TwoFlagstaff.incNumber2Flagstaff();
			return true;
		}
	}

}