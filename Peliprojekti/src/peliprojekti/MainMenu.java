package peliprojekti;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;

public class MainMenu extends Window {

	public MainMenu() {
		super ("Päävalikko");
		addComponent((new Button("Uusi Peli", new Action(){
			public void doAction() {
				Player player = new Player(); // Luodaan uusi pelaaja
				GameEngine gameEngine = new GameEngine(player); // luodaan pelimoottori uudelle pelaajalle
				gameEngine.play(player);
				// newGameEngine.gameLoop(); // kutsutaan pelimoottorin pelilooppia (vanha)
			}
		})));
		addComponent((new Button("Avaa Peli", new Action(){
			public void doAction() {
				//Toiminto
			}

		})));
		addComponent((new Button("Ohjeet", new Action(){
			public void doAction() {
				InstructionsWindow instructionsWindow = new InstructionsWindow();
				Main.startupGui.showWindow(instructionsWindow, GUIScreen.Position.CENTER);
			}
		})));
		addComponent((new Button("Lopeta", new Action(){
			public void doAction() {
				close();
			}

		})));
	}
}
