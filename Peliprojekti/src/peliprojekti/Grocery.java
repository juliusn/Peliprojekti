package peliprojekti;

public class Grocery {

	public void buyFood(Player player) {
		if (player.getPlayerMoney() >= 10) { // Katsotaan onko pelaajalla tarpeeksi rahaa
			player.changePlayerMoney(-10);
			player.changePlayerHealth(10);
			System.out.println("Money: -10, health: +10");
		} else {
			System.out.println("Not enough money!");
		}	
	}
}