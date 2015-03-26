package peliprojekti;

public class Player {
	private double money = 0;
	private double health = 0;
	
	public static Player createNewPlayer() {
		// uusi pelaaja
		return null;
	}

	public void openPlayer() { // "Avaa pelaaja"
		this.money = 10;
		this.health = 200;
	}
	
	public double getMoney() {
		return money;
	}
	public double getHealth() {
		return health;
	}
}
