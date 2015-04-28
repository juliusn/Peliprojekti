package peliprojekti; // jotain muuta
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
public class Main {
	/* Graafista käyttöliittymää varten täytyy luoda muutamia objekteja. 
	 * Näistä voi lueskella sivulla https://code.google.com/p/lanterna/wiki/UsingTerminal
	 * Grafiikkamoottoriin viitataan muissa luokissa nimellä Main.gui
	 * */
	public static Terminal terminal = TerminalFacade.createTerminal();
	public static TerminalSize screenSize = terminal.getTerminalSize();
	public static Screen startupScreen = new Screen(terminal);
	public static ScreenWriter startupScreenWriter = new ScreenWriter(startupScreen);
	public static GUIScreen gui = new GUIScreen(startupScreen);

	public static void main(String[] args) throws InterruptedException {
		/*		StartMenu newStartMenu = new StartMenu();
		newStartMenu.choose(); // vanhaan alkuvalikkoon
		System.out.println("Exit Main");*/

		gui.getScreen().startScreen(); // Avataan graafinen näkymä


		/* Introruutu ennen päävalikkoa. 
		 * Ruudun näkymistä voi pidentää kasvattamalla for-loopin countteria.
		 * Ruutu tullaan ehkä korvaamaan tervetulodialogilla tai animaatiolla. */
		
		String startupMsg = "KelaSim Starting In "; 
		startupScreenWriter.setForegroundColor(Terminal.Color.WHITE);
		startupScreenWriter.setBackgroundColor(Terminal.Color.CYAN);
		for (int i = 1; i > 0; i--){
			startupScreenWriter.drawString(screenSize.getColumns()/2-startupMsg.length()/2, screenSize.getRows()/2, startupMsg+i);
			gui.getScreen().refresh();
			Thread.sleep(1000);
		}
		
		/* Uutta ikkunaa/valikkoa varten täytyy luoda luokka, 
		 * joka käyttää Lanternan Window-interfacea. Siitä
		 * luodaan uusi objekti, joka saadaan näkymään kutsumalla
		 * gui.showWindow-metodia seuraavasti: */
		
		MainMenu newMainMenu = new MainMenu(); // Luodaan päävalikko
		gui.showWindow(newMainMenu, GUIScreen.Position.CENTER); // Avataan päävalikko
		
		gui.getScreen().stopScreen(); // Suljetaan graafinen näkymä
		System.out.println("Screen "+startupScreen.toString()+" stopped");
		
	}	
}
