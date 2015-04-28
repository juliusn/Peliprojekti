package peliprojekti;

import java.io.Serializable;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;

public class GameEngine implements Serializable {

	public GameEngine(Player player) {
		System.out.println("GameEngine created with "+player.toString());
	}

	public void play(Player player) {
		System.out.println("Play method started");
		do {

			GameWindow gameWindow = new GameWindow(player);
			gameWindow.setBorder((new Border.Invisible()));

			Main.gui.showWindow(gameWindow, GUIScreen.Position.FULL_SCREEN);

			/* VANHA PELIMOOTTORI ON TÄSSÄ. 
		System.out.println("KelaSim");
		while (quit == false) { // Tässä loopissa pelaaminen tapahtuu. 
			System.out.println("Day "+newCalendar.getDateCounter());
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
				newApplication.fillApplication(player);
				break;
			default:
				System.out.println("Mitään ei tapahdu.");
				break;
			}
		}
		System.out.println("Exit gameloop");
			 */
		} while (player.keepPlaying = true);
		System.out.println("Exit GameEngine");
	}

}
