package pl.kielce.tu.kronos.logic;

public class WaitPlayerThread implements Runnable {

	ShipsLogic shipsLogic;

	public WaitPlayerThread(ShipsLogic shipsLogic) {
		this.shipsLogic = shipsLogic;
	}

	public ServerData updateServerData(ServerData serverData) {
		if (serverData.getStatus() != Const.DEFEAT) {
			System.out.println("Gram dalej...");

			String data = Model.connect.getData();
			ServerData server = new ServerData(data);

			shipsLogic.setActiveTure(serverData.getActiveTure());
			return server;
		} else {
			System.out.println("Przegralem....");
			shipsLogic.setActiveTure(Const.DEFEAT);
			serverData.setActiveTure(Const.DEFEAT);
			return serverData;
		}
	}

	@Override
	public void run() {
		String data = Model.connect.getData();
		ServerData serverData = new ServerData(data);
		shipsLogic.setActiveTure(serverData.getActiveTure());
		while (serverData.getActiveTure() == Const.ENEMY_TURE) {
			System.out.println("Czekam na info czu HIT czy HIT and SUNK");
			System.out.println("Tura Enemy, odebralem: " + serverData.getData());
			System.out.println("");
			if (serverData.getTypeOfShot() == Const.HIT) {
				System.out.println("Przeciwnik trafil mnie :(");
				shipsLogic.enemyShotHit(serverData);
			} else if (serverData.getTypeOfShot() == Const.HIT_AND_SUNK) {
				System.out.println("Przeciwnik trafil mnie i zatopil");
				shipsLogic.enemyShotHitAndSunk(serverData);
			}
			shipsLogic.updateImages(Const.OWN_IMAGES);
			serverData = updateServerData(serverData);
		}

		if (shipsLogic.isYouDefeated(serverData.getStatus())) {
			shipsLogic.youLose();
			// Thread.currentThread().interrupt();
		} else {
			shipsLogic.enemyMissed(serverData);
		}
		Thread.currentThread().interrupt();
	}

}
