package peliprojekti;

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
	private int hunger = 0;
	private int food = 0;
	private int age = 0;
	Player player = null;

	public Player() {
		money = 100;
		health = 100;
		sanity = 100;
		hunger = 0;
		food = 0;
		age = 0;
		System.out.println("New player "+this.toString()+" initialized:");
		System.out.println("Money: "+money);
		System.out.println("Health: "+health);
		System.out.println("Sanity: "+sanity);
		System.out.println("Age: "+age);
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
	public int getPlayerHunger() {
		return this.hunger;
	}
	public int getPlayerFood() {
		return this.food;
	}
	public int getPlayerAge() {
		return this.age;
	}
	public void changePlayerMoney(int i) {
		this.money = this.money + i;
	}
	public void changePlayerHealth(int i) {
		if (this.health+i <= 0) {
			this.health = 0;
			this.keepPlaying = false;
		} else if (this.health+i >= 100) {
			this.health = 100;
		} else {
			this.health = this.health + i;
		}
	}
	public void changePlayerSanity(int i) {
		if (this.sanity+i <= 0) {
			this.sanity = 0;
			this.keepPlaying = false;
		} else if (this.sanity+i >= 100) {
			this.sanity= 100;
		} else {
			this.sanity= this.sanity + i;
		}
	}
	public void changePlayerHunger(int i) {
		if (this.hunger+i <= 0) {
			this.hunger = 0;
		} else if (this.hunger+i >= 100) {
			this.hunger = 100;
			this.keepPlaying = false;
		} else {
			this.hunger = this.hunger + i;
		}
	}
	public void changePlayerFood(int i) {
		if (this.food+i <= 0) {
			this.food = 0;
		} else {
			this.food= this.food + i;
		}
	}
	public void changePlayerAge(int i) {
		this.age = this.age + i;
	}
	public void stopPlaying() {
		this.keepPlaying = false;
	}

}
