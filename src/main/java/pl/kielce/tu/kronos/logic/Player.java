package pl.kielce.tu.kronos.logic;

import java.io.Serializable;

import pl.kielce.tu.kronos.flagstaff.FourFlagstaff;
import pl.kielce.tu.kronos.flagstaff.OneFlagstaff;
import pl.kielce.tu.kronos.flagstaff.ThreeFlagstaff;
import pl.kielce.tu.kronos.flagstaff.TwoFlagstaff;

public class Player implements Serializable {
	Integer id;
	String login;
	Map map;
	int sunkShips;
	boolean ture;

	OneFlagstaff[] tabOneFlagstaff;
	TwoFlagstaff[] tabTwoFlagstaff;
	ThreeFlagstaff[] tabThreeFlagstaff;
	FourFlagstaff[] tabFourFlagstaff;

	public Player(Integer id, String login) {
		super();
		this.id = id;
		this.login = login;
		this.map = new Map();
		this.sunkShips = 0;

		resetTablesOfShip();

	}

	public boolean isTure() {
		return ture;
	}

	public void setTure(boolean ture) {
		this.ture = ture;
	}

	public void incSunkShips() {
		this.sunkShips=this.sunkShips+1;
	}

	public int getSunkShips() {
		return sunkShips;
	}

	public OneFlagstaff[] getTabOneFlagstaff() {
		return tabOneFlagstaff;
	}

	public void setTabOneFlagstaff(OneFlagstaff[] tabOneFlagstaff) {
		this.tabOneFlagstaff = tabOneFlagstaff;
	}

	public TwoFlagstaff[] getTabTwoFlagstaff() {
		return tabTwoFlagstaff;
	}

	public void setTabTwoFlagstaff(TwoFlagstaff[] tabTwoFlagstaff) {
		this.tabTwoFlagstaff = tabTwoFlagstaff;
	}

	public ThreeFlagstaff[] getTabThreeFlagstaff() {
		return tabThreeFlagstaff;
	}

	public void setTabThreeFlagstaff(ThreeFlagstaff[] tabThreeFlagstaff) {
		this.tabThreeFlagstaff = tabThreeFlagstaff;
	}

	public FourFlagstaff[] getTabFourFlagstaff() {
		return tabFourFlagstaff;
	}

	public void setTabFourFlagstaff(FourFlagstaff[] tabFourFlagstaff) {
		this.tabFourFlagstaff = tabFourFlagstaff;
	}

	public void resetTablesOfShip() {
		this.tabOneFlagstaff = new OneFlagstaff[4];

		for (int i = 0; i < OneFlagstaff.MAX_NUMBER_ONE_FLAGSTAFF; i++) {
			this.tabOneFlagstaff[i] = new OneFlagstaff();
		}

		this.tabTwoFlagstaff = new TwoFlagstaff[3];

		for (int i = 0; i < TwoFlagstaff.MAX_NUMBER_TWO_FLAGSTAFF; i++) {
			this.tabTwoFlagstaff[i] = new TwoFlagstaff();
		}

		this.tabThreeFlagstaff = new ThreeFlagstaff[2];
		for (int i = 0; i < ThreeFlagstaff.MAX_NUMBER_THREE_FLAGSTAFF; i++) {
			this.tabThreeFlagstaff[i] = new ThreeFlagstaff();
		}

		this.tabFourFlagstaff = new FourFlagstaff[1];
		for (int i = 0; i < FourFlagstaff.MAX_NUMBER_FOUR_FLAGSTAFF; i++) {
			this.tabFourFlagstaff[i] = new FourFlagstaff();
		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public OneFlagstaff getOneFlagstaff(int number) {
		return tabOneFlagstaff[number];
	}

	public TwoFlagstaff getTwoFlagstaff(int number) {
		return tabTwoFlagstaff[number];
	}

	public ThreeFlagstaff getThreeFlagstaff(int number) {
		return tabThreeFlagstaff[number];
	}

	public FourFlagstaff getFourFlagstaff(int number) {
		return tabFourFlagstaff[number];
	}

}
