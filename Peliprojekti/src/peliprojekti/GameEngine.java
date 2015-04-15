package peliprojekti;

import java.io.Serializable;

public class GameEngine {
	private Player player;
	private CommandInterpreter newCommandInterpreter = new CommandInterpreter(); 
	private Calendar newCalendar = new Calendar();
	public boolean quit = false;
	public GameEngine(Player player) {
		this.player = player;
	}

	public void gameLoop() {
		System.out.println("KelaSim");
		while (quit == false) { // Tässä loopissa pelaaminen tapahtuu. 
			System.out.println("Day "+newCalendar.getDateCounter());
			System.out.println("Pelivalikko: q/save/testi/stats/skip");
			String command = newCommandInterpreter.consoleCommand();
			System.out.println("Valitsit: " + command);
			switch (command) {
			case "q":
				quit = true;
				break;
			case "save":

				break;
			case "testi":
				System.out.println("Testi toimii. ");
				break;
			case "stats":
				System.out.println("Raha: "+player.getMoney()+", terveys: "+player.getHealth());
				break;
			case "skip":
				newCalendar.increaseDateCounter();
				break;
			}
		}
		System.out.println("Exit gameloop");
	}
}
