package peliprojekti;

public class StartMenu {

	public StartMenu() {
	}

	public void choose() {
		// Luo pelaaja tai avaa tallennettu peli
		System.out.println("Alkuvalikko: new/open/q");
		CommandInterpreter newCommandInterpreter = new CommandInterpreter();
		Player player = new Player();
		GameEngine newGameEngine = new GameEngine(player);
		String startMenuChoice = newCommandInterpreter.consoleCommand();
		System.out.println("Valitsit: "+startMenuChoice);
		switch (startMenuChoice) {
		case "q":
			break;
		case "new":
			newGameEngine.gameLoop();
			break;
		case "open":
			player.openPlayer();
			newGameEngine.gameLoop();
			break;
		}
		System.out.println("Exit Start menu");
	}
}
