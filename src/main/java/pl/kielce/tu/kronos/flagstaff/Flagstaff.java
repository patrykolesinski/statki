package pl.kielce.tu.kronos.flagstaff;

import java.io.Serializable;

public class Flagstaff implements Serializable {

	/**
	 * TRUE - sunked Ship, FALSE - swimming Ship
	 */
	protected boolean sunk;
	protected byte length;

	public Flagstaff() {
		this.sunk = false;
	}

	/*
	 * public void setSunkOnFalse() { this.sunk = false;
	 * 
	 * }
	 */
	
	

	public boolean isSunk() {
		return sunk;
	}

	public byte getLength() {
		return length;
	}

	public void setLength(byte length) {
		this.length = length;
	}

	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}

}
