package kelasim; // jotain muuta
import java.nio.charset.Charset;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
public class Main {
	/* Graafista käyttöliittymää varten täytyy luoda muutamia objekteja. 
	 * Näistä voi lueskella sivulla https://code.google.com/p/lanterna/wiki/UsingTerminal
	 * Pelin aloitusnäkymään viitataan Main.startupGui
	 * */
	public static Terminal terminal = TerminalFacade.createTerminal(Charset.forName("UTF-8"));
	public static TerminalSize screenSize = terminal.getTerminalSize();
	public static Screen screen = new Screen(terminal);
	public static ScreenWriter screenWriter = new ScreenWriter(screen);
	public static GUIScreen startupGui = new GUIScreen(screen);
	public static void main(String[] args) throws InterruptedException {
		
		startupGui.getScreen().startScreen(); // Avataan graafinen näkymä


		/* Introruutu ennen päävalikkoa. 
		 * Ruudun näkymistä voi pidentää kasvattamalla for-loopin countteria.
		 * Ruutu tullaan ehkä korvaamaan tervetulodialogilla tai animaatiolla. */
		
		String startupMsg = "KelaSim Starting In "; 
		screenWriter.setForegroundColor(Terminal.Color.WHITE);
		screenWriter.setBackgroundColor(Terminal.Color.CYAN);
		for (int i = 0; i > 0; i--){
			// i = kuinka monta sekuntia startup-viesti näkyy
			screenWriter.drawString(screenSize.getColumns()/2-startupMsg.length()/2, screenSize.getRows()/2, startupMsg+i);
			startupGui.getScreen().refresh();
			Thread.sleep(1000);
		}
		
		/* Uutta ikkunaa/valikkoa varten täytyy luoda luokka, 
		 * joka käyttää Lanternan Window-interfacea. Siitä
		 * luodaan uusi objekti, joka saadaan näkymään kutsumalla
		 * gui.showWindow-metodia seuraavasti: */
		
		MainMenu newMainMenu = new MainMenu(); // Luodaan päävalikko
		startupGui.showWindow(newMainMenu, GUIScreen.Position.CENTER); // Avataan päävalikko
		
		startupGui.getScreen().stopScreen(); // Suljetaan graafinen näkymä
		System.out.println("Screen "+screen.toString()+" stopped");
		
	}	
}
