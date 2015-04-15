package peliprojekti;

public class StartMenu {

	public StartMenu() {
	}

	public void choose() {
		// Alkuvalikossa valitaan, luodaanko uusi pelaaja vai avataanko tallennettu peli. 
		System.out.println("Alkuvalikko: new/open/q");
		CommandInterpreter newCommandInterpreter = new CommandInterpreter();
		Player player = new Player(); //tarviiko tätä?
		String startMenuChoice ="";
		do {
			startMenuChoice = newCommandInterpreter.consoleCommand();
			System.out.println("Valitsit: "+startMenuChoice);
			switch (startMenuChoice) {
			case "q":
				break; // lopeta
			case "new":
				player = player.createNewPlayer(); // kutsutaan metodia, joka luo uuden pelaajan
				GameEngine newGameEngine = new GameEngine(player); // luodaan pelimoottori uudelle pelaajalle
				newGameEngine.gameLoop(); // kutsutaan pelimoottorin pelilooppia
				break;
			case "open":
				player = player.openPlayer(); // kutsutaan metodia, joka avaa tallennetun pelin
				GameEngine openGameEngine = new GameEngine(player); // luodaan pelimoottori tallennetulle pelaajalle
				openGameEngine.gameLoop(); // kutsutaan pelimoottorin pelilooppia
				break;
			}
		} while (startMenuChoice != "q");
		System.out.println("Exit Start menu");
	}
}
