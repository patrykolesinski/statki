package pl.kielce.tu.kronos.logic;

public class Const {
	
	/* Ships logic */
	public static byte GOOD_AREA_HORIZONTAL = 0;
	public static byte GOOD_AREA_VERTICAL = 1;
	public static byte OUT_OF_RANGE_HORIZONTAL = 2;
	public static byte OUT_OF_RANGE_VERTICAL = 3;
	public static byte BLOCKED_HORIZONTAL = 4;
	public static byte BLOCKED_VERTICAL = 5;
	public static byte NOT_BLOCKED_HORIZONTAL = 6;
	public static byte NOT_BLOCKED_VERTICAL = 7;
	public static byte READY_TO_SET = 8;
	public static byte NOT_READY_TO_SET = 9;
	public static byte MAX_NUMBER_SHIP = 10;
	public static byte BAD_AREA = 11;
	public static byte BLOCKED = 12;

	public static byte MISS = 13;
	public static byte HIT = 14;
	public static byte HIT_AND_SUNK = 15;
	public static byte YOUR_TURE = 16;
	public static byte ENEMY_TURE = 17;
	public static byte HORIZONTAL = 18;
	public static byte VERTICAL = 19;
	public static byte OWN_IMAGES = 20;
	public static byte ENEMY_IMAGES = 21;

	public static byte DEFEAT = 22;
	public static byte VICTORY = 23;
	
	
	/* Mapa */
	public static int EMPTY_FIELD = 0;
	public static int SET_FLAGSTAFF = 1;
	public static int HIT_FLAGSTAFF = 2;
	public static int SUNK_FLAGSTAFF = 3;
	public static int MISS_FIELD = 4;
	public static int BLOCKED_FIELD = 9;
}
