package peliprojekti;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean keepPlaying;
	private int money = 0;
	private int health = 0;
	private int sanity = 0;
	public int age = 0;
	public Calendar calendar;
	Player player = null;

	public Player() {
		money = 100;
		health = 100;
		sanity = 100;
		age = 0;
		System.out.println("New player "+this.toString()+" initialized:");
		System.out.println("Money: "+money);
		System.out.println("Health: "+health);
		System.out.println("Sanity: "+sanity);
		System.out.println("Age: "+age);
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
	public int getPlayerMoney() {
		return this.money;
	}
	public int getPlayerHealth() {
		return this.health;
	}
	public int getPlayerSanity() {
		return this.sanity;
	}
	public int getPlayerAge() {
		return this.age;
	}
	public void changePlayerMoney(int i) {
		this.money = this.money + i;
		System.out.println(this.player.toString()+" money changed to "+this.money);
	}
	public void changePlayerHealth(int i) {
		this.health = this.health + i;
		System.out.println(this.player.toString()+" health changed to "+this.health);
	}
	public void changePlayerSanity(int i) {
		this.sanity = this.sanity+ i;
		System.out.println(this.player.toString()+" sanity changed to "+this.sanity);
	}
	public void changePlayerAge(int i) {
		this.age = this.age + i;
		//System.out.println(this.player.toString()+" age changed to "+this.age);
	}
	public void stopPlaying() {
		this.keepPlaying = false;
	}
}
