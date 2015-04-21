package peliprojekti;

public class Grocery {

	public void buyFood(Player player) {
		if (player.getPlayerMoney() >= 10) { // Katsotaan onko pelaajalla tarpeeksi rahaa
			player.changePlayerMoney(-10);
			player.changePlayerHealth(10);
			System.out.println("Raha: -10, terveys: +10");
		} else {
			System.out.println("Ei tarpeeksi rahaa!");
		}	
	}
}