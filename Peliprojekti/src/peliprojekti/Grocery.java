package peliprojekti;

public class Grocery {
	
	public void buyFood() {
		if (Player.money >= 10) { // Katsotaan onko pelaajalla tarpeeksi rahaa
			Player.money = Player.money - 10;
			Player.health = Player.health + 10;
			System.out.println("Money: -10, health: +10");
		} else {
			System.out.println("Not enough money!");
		}	
	}
}