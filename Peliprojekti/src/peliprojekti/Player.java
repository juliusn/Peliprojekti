package peliprojekti;

public class Player {
	private double money = 0;
	private double health = 0;
	private double sanity = 0;
	
	public static Player createNewPlayer() {
		// uusi pelaaja
		return null;
	}

	public void openPlayer() { // tallennetun pelin avaaminen, kesken. 
		this.money = 10; // testiarvoja
		this.health = 200; // testiarvoja
		this.sanity = 100; // testiarvoja
	}
	
	public double getMoney() {
		return money;
	}
	public double getHealth() {
		return health;
	}
	public double getSanity() {
		return sanity;
	}
}
