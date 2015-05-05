package peliprojekti;

import java.io.Serializable;

import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;

public class GameEngine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GUIScreen gameGui = new GUIScreen(Main.screen);
	public boolean keepPlaying = true;
	public GameEngine(Player player) {
		System.out.println("GameEngine "+this.toString()+" created with "+player.toString());
	}

	public void play(Player player) {
		System.out.println("Play method started");
		System.out.println("in screen "+this.gameGui.getScreen());
		GameWindow gameWindow = new GameWindow(player, this); // Kutsu peli-ikkunaa pelaajalla
		while (player.keepPlaying) {
			gameGui.showWindow(gameWindow, GUIScreen.Position.FULL_SCREEN); // Näytä peli-ikkuna
		}
		System.out.println("Exit GameEngine "+this.toString());
	}
}
