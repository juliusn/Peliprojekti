package peliprojekti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Player implements Serializable {
	private double money = 0;
	private double health = 0;
	private double sanity = 0;
	Player player = null;
	public Player createNewPlayer() {
		money = 10;
		health = 100;
		sanity = 100;
		return player;
	}

	public Player openPlayer() { // tallennetun pelin avaaminen, beta. 
		try {
			FileInputStream fileIn = new FileInputStream("/tmp/player.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			player = (Player) in.readObject();
			in.close();
		} catch(IOException i) {
			i.printStackTrace();
			return player;
		} catch(ClassNotFoundException c) {
			System.out.println("Player class not found");
			c.printStackTrace();
			return player;
		}
		return player;
	}
	public void savePlayer() {
		try {
			FileOutputStream fileOut = new FileOutputStream("/tmp/player.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(player);
			out.close();
			fileOut.close();
			System.out.printf("Pelaaja tallennettu /tmp/player.ser");
		} catch(IOException i) {
			i.printStackTrace();
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
