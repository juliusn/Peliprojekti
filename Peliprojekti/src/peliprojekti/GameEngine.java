package peliprojekti;

import java.io.Serializable;

public class GameEngine {
	private Player player;
	private CommandInterpreter newCommandInterpreter = new CommandInterpreter(); 
	private Calendar newCalendar = new Calendar();
	public boolean quit = false;

	private Grocery newGrocery = new Grocery();
	private Application newApplication = new Application();

	public GameEngine(Player player) {
		this.player = player;
	}

	public void gameLoop() {
		System.out.println("KelaSim");
		while (quit == false) { // Tässä loopissa pelaaminen tapahtuu. 
			System.out.println("Day "+newCalendar.dateCounter);
			System.out.println("Pelivalikko: q/save/buy food/stats/skip");
			String command = newCommandInterpreter.consoleCommand();
			System.out.println("Valitsit: " + command);
			switch (command) {
			case "q":
				quit = true;
				break;
			case "stats":
				System.out.println("Raha: "+player.getPlayerMoney()+", terveys: "+player.getPlayerHealth());
				break;
			case "skip":
				newCalendar.dateCounter = newCalendar.dateCounter + 1;
				break;
			case "save": // Tallentaa pelin
				player.savePlayer();
				break;	
			case "buy food":
				newGrocery.buyFood(this.player);
				break;
			case "fill application":
				newApplication.fillApplication();
				break;
			default:
				System.out.println("Mitään ei tapahdu.");
				break;
			}
		}
		System.out.println("Exit gameloop");
	}
}
