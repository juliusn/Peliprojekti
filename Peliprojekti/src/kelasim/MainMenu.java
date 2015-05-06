package kelasim;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.dialog.MessageBox;

public class MainMenu extends Window {

	public MainMenu() {
		super ("Päävalikko");
		addComponent((new Button("Uusi Peli", new Action(){
			public void doAction() {
				Player player = new Player(); // Luodaan uusi pelaaja
				MessageBox.showMessageBox(getOwner(), "Uuden pelaajan tiedot:", "Nimi: "+player.getPlayerForeName()+" "+player.getPlayerSurName()+".\n"+"Sosiaaliturvatunnus: "+player.getPlayerSsn());
				GameEngine gameEngine = new GameEngine(player); // luodaan pelimoottori uudelle pelaajalle
				gameEngine.play(player);
			}
		})));
		addComponent((new Button("Jatka Tallennettua Peliä", new Action(){
			public void doAction() {
				try {
					FileInputStream in = new FileInputStream("player.ser");
					ObjectInputStream obin = new ObjectInputStream(in);
					Player player = (Player)obin.readObject();
					obin.close();
					GameEngine gameEngine = new GameEngine(player);
					gameEngine.play(player);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					MessageBox.showMessageBox(getOwner(), "Virhe:", "Peliä ei voitu avata.");
				} catch (IOException e) {
					System.out.println("Error reading file");
					MessageBox.showMessageBox(getOwner(), "Virhe:", "Peliä ei voitu avata.");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("Error reading object");
					MessageBox.showMessageBox(getOwner(), "Virhe:", "Peliä ei voitu avata.");
					e.printStackTrace();
				}
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
