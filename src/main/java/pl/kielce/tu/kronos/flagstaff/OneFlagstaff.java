package pl.kielce.tu.kronos.flagstaff;

import pl.kielce.tu.kronos.logic.Const;

public class OneFlagstaff extends Flagstaff {

	protected int x1Point, y1Point;
	protected byte orientation;
	public int lives;


	public OneFlagstaff() {
		super();
		this.length=1;
		this.lives=1;

	}

	/*
	 * public int getX1Point() { return x1Point; }
	 * 
	 * public void setX1Point(int x1Point) { this.x1Point = x1Point; }
	 */
	
	
	

	
	public void setCoordinates(int x1, int y1, String orientation) {
		this.x1Point = x1;
		this.y1Point = y1;
		if(orientation.equals("Horizontal")){
			this.orientation=Const.HORIZONTAL;
		}
		else{
			this.orientation=Const.VERTICAL;
		}
		
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getX1Point() {
		return x1Point;
	}

	public int getY1Point() {
		return y1Point;
	}

	public void setX1Point(int x1Point) {
		this.x1Point = x1Point;
	}

	public void setY1Point(int y1Point) {
		this.y1Point = y1Point;
	}

	public byte getOrientation() {
		return orientation;
	}

	public void setOrientation(byte orientation) {
		this.orientation = orientation;
	}

	public static byte MAX_NUMBER_ONE_FLAGSTAFF = 4;

	public boolean setFlagstaff(int x1, int y1, String orientation) {
		if (OneFlagstaff.getNumber1Flagstaff() == MAX_NUMBER_ONE_FLAGSTAFF) {
			return false;
		} else {
			setCoordinates(x1, y1, orientation);
			OneFlagstaff.incNumber1Flagstaff();
			return true;
		}
	}

	private static byte number1Flagstaff = 0;

	public static byte getNumber1Flagstaff() {
		return number1Flagstaff;
	}

	public static void setNumber1Flagstaff(byte numberFlagstaff) {
		OneFlagstaff.number1Flagstaff = numberFlagstaff;
	}

	public static void incNumber1Flagstaff() {
		OneFlagstaff.number1Flagstaff++;
	}

	public static void resetNumber1Flagstaff() {
		OneFlagstaff.number1Flagstaff = 0;
	}

	public void print() {
		System.out.println("napis");
	}

}
