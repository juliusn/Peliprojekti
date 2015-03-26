package peliprojekti;

import java.util.Scanner;

public class CommandInterpreter {
	public String consoleCommand() {
		System.out.print("Anna komento: ");
		@SuppressWarnings("resource")
		Scanner inputLine = new Scanner (System.in);
		return inputLine.nextLine().toLowerCase();
	}
}
