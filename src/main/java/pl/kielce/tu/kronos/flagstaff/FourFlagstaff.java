package pl.kielce.tu.kronos.flagstaff;

public class FourFlagstaff extends ThreeFlagstaff {

	protected int x4Point, y4Point;

	public FourFlagstaff() {
		super();
		this.length=4;
		this.lives=4;
	}

	/*
	 * @Override public void createTabFlagstaff() { tabFourFlagstaff = new
	 * FourFlagstaff[1]; }
	 */

	
	
	
	public void setCoordinates(int x1, int y1, String orientation) {
		// super(x1,y1,orientation);
		super.setCoordinates(x1, y1, orientation);

		if (orientation.equals("Vertical")) {
			this.y4Point = y3Point + 1;
			this.x4Point = x1;
		}

		if (orientation.equals("Horizontal")) {
			this.y4Point = y1;
			this.x4Point = x3Point + 1;
		}
	}

	public int getX4Point() {
		return x4Point;
	}

	public int getY4Point() {
		return y4Point;
	}

	public void setX4Point(int x4Point) {
		this.x4Point = x4Point;
	}

	public void setY4Point(int y4Point) {
		this.y4Point = y4Point;
	}

	private static byte number4Flagstaff = 0;

	public static byte getNumber4Flagstaff() {
		return number4Flagstaff;
	}

	public static void setNumber4Flagstaff(byte number4Flagstaff) {
		FourFlagstaff.number4Flagstaff = number4Flagstaff;
	}

	public static void incNumber4Flagstaff() {
		FourFlagstaff.number4Flagstaff++;
	}

	public static void resetNumber4Flagstaff() {
		FourFlagstaff.number4Flagstaff = 0;
	}

	public static byte MAX_NUMBER_FOUR_FLAGSTAFF = 1;

	@Override
	public boolean setFlagstaff(int x1, int y1, String orientation) {
		if (FourFlagstaff.getNumber4Flagstaff() == MAX_NUMBER_FOUR_FLAGSTAFF) {
			return false;
		} else {

			setCoordinates(x1, y1, orientation);
			FourFlagstaff.incNumber4Flagstaff();
			return true;
		}
	}
}