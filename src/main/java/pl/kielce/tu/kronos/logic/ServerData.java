package pl.kielce.tu.kronos.logic;

public class ServerData {

	public ServerData(String data) {
		this.data = data;
		System.out.println("DANE: " + data);

		System.out.println("DANE: THIS" + this.data);
		String[] tab = new String[7];
		tab = data.split(":");
		
		this.activeTure = Integer.parseInt(tab[0]);		
		this.typeOfShot = Integer.parseInt(tab[1]);
		this.x = Integer.parseInt(tab[2]);
		this.y = Integer.parseInt(tab[3]);

		if (this.typeOfShot == Const.HIT_AND_SUNK) {
			this.length = 0; 
			this.length = Integer.parseInt(tab[4]);
			System.out.println("LENGTH: " + this.length);
			this.i_Orientation = Integer.parseInt(tab[5]);
			this.status = Integer.parseInt(tab[6]);

			if (this.i_Orientation == Const.HORIZONTAL) {
				this.orientation = "Horizontal";
			} else {
				this.orientation = "Vertical";
			}
			
			System.out.println("ORI-SERVERDATA: " + this.orientation);
		}
	}

	private int typeOfShot, activeTure, x, y, length, i_Orientation, status;
	private String orientation = "", data = "";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public int getTypeOfShot() {
		return typeOfShot;
	}

	public int getActiveTure() {
		return activeTure;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLength() {
		return length;
	}

	public int getI_Orientation() {
		return i_Orientation;
	}

	public int getStatus() {
		return status;
	}

	public void setTypeOfShot(int typeOfShot) {
		this.typeOfShot = typeOfShot;
	}

	public void setActiveTure(int activeTure) {
		this.activeTure = activeTure;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setI_Orientation(int i_Orientation) {
		this.i_Orientation = i_Orientation;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
