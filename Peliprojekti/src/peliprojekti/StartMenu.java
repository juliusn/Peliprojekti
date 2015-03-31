package peliprojekti;

public class StartMenu {

	public StartMenu() {
	}

	public void choose() {
		// Alkuvalikossa valitaan, luodaanko uusi pelaaja vai avataanko tallennettu peli. 
		System.out.println("Alkuvalikko: new/open/q");
		CommandInterpreter newCommandInterpreter = new CommandInterpreter();
		Player player = new Player();
		GameEngine newGameEngine = new GameEngine(player); // luodaan pelimoottori uudelle pelaajalle
		String startMenuChoice = newCommandInterpreter.consoleCommand();
		System.out.println("Valitsit: "+startMenuChoice);
		switch (startMenuChoice) {
		case "q":
			break; // lopeta
		case "new":
			newGameEngine.gameLoop(); // kutsutaan pelimoottorin pelilooppia
			break;
		case "open":
			player.openPlayer(); // kutsutaan metodia, joka avaa tallennetun pelin
			newGameEngine.gameLoop();
			break;
		}
		System.out.println("Exit Start menu");
	}
}
