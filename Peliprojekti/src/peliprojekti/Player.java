package peliprojekti;

public class Player implements Serializable {
	private double money = 0;
	private double health = 0;
	private double sanity = 0;
	
	public static Player createNewPlayer() {
		// uusi pelaaja
		return null;
	}

	private void openPlayer() { // tallennetun pelin avaaminen, kesken. 
		this.money = 10; // testiarvoja
		this.health = 100; // testiarvoja
		this.sanity = 100; // testiarvoja
	}
	private void savePlayer() { //kesken
		try {
			FileOutputStream out = new FileOutputStream("player.ser");
			ObjectOutputStream obout = new ObjectOutputStream(out);
			obout.writeObject(Player);
			obout.close();
		} catch (FileNotFoundException e) {
			System.out.println("player.ser ei löytynyt.");
			e.printStackTrace();
		}
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
