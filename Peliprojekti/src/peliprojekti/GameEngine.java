package peliprojekti;

public class GameEngine {
	private Player player;
	private CommandInterpreter newCommandInterpreter = new CommandInterpreter(); 
	private Calendar newCalendar = new Calendar();
	private Grocery newGrocery = new Grocery();

	public GameEngine(Player player) {
		this.player = player;
	}

	public void gameLoop() {
		boolean quit = false;
		System.out.println("KelaSim");
		while (quit == false) { // Tässä loopissa pelaaminen tapahtuu. 
			System.out.println("Day "+newCalendar.getDateCounter());
			String command = newCommandInterpreter.consoleCommand();
			System.out.println("Valitsit: " + command);
			switch (command) {
			case "q":
				quit = true;
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
			case "save": // Tallentaa pelin
				player.savePlayer();
				break;	
			case "buy food":
				newGrocery.buyFood();
				break;
			default:
				System.out.println("Nothing happens.");
				break;
			}
		}
		System.out.println("Exit gameloop");
	}
}
