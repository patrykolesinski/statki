package pl.kielce.tu.kronos.logic;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WaitForSecondThread implements Runnable {
	Player player;
	Label enemyNick;
	ShipsLogic shipsLogic;
	public WaitForSecondThread(Player player, Label enemyNick) {
		super();
		this.player = player;
		this.enemyNick=enemyNick;
		this.shipsLogic = ShipsLogic.getInstance();
	}

	@Override
	public void run() {
		String data="";
		final String nick;
		String[] tab = new String[3];
		data = Model.connect.getData();
		tab = data.split(":");
		nick = tab[1];
		player.setId(Integer.parseInt(tab[0]));
		Platform.runLater(() -> {
			enemyNick.setText(nick);
		});
		shipsLogic.setActiveTure(Integer.parseInt(tab[2]));
		
		Model.connect.sendPlayer(player);
		
		/*player.setId(Integer.parseInt(Model.connect.getData()));
		Model.connect.sendPlayer(player);

		enemyNick.setText(Model.connect.getData());
		shipsLogic.setActiveTure(Integer.parseInt(Model.connect.getData()));
*/
		if (shipsLogic.getActiveTure() == Const.YOUR_TURE) {
			// Gra
			shipsLogic.setEnableEnemyButtons();
			shipsLogic.tureSetYou();
		} else {
			// Czeka
			shipsLogic.tureSetEnemy();
			shipsLogic.setDisableEnemyButtons();
			shipsLogic.waitForYourTure();
		}
		// Model.connect.disconnectWithServer(); // To musi byc na koncu
		// programu!

	}
}
