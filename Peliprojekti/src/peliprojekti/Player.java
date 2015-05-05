package peliprojekti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	public boolean keepPlaying = true;
	private String foreName = "";
	private String surName = "";
	private ArrayList<String> foreNames = new ArrayList<String>();
	private ArrayList<String> surNames = new ArrayList<String>();
	private ArrayList<Application> applications;
	private ArrayList<Allowance> allowances;
	private int money = 0; /* Raha */
	private int health = 0; /* Hyvinvointi, pudotessa nollaan pelaaja kuolee */
	private int sanity = 0; /* Mielenterveys, pudotessa nollaan pelaaja kuolee */
	private int hunger = 0; /* Nälkä, kasvaessa sataan pelaaja kuolee */
	private int food = 0; /* Ruoka == Ruokaan käytetyn rahan määrä */
	private int age = 0; /* Ikä mitataan päivissä ja kasvaa yöunien perusteella */
	private String ssn = ""; /* sosiaaliturvatunnus */
	public boolean isApplicant = false;
	Player player = null;
	Random rng = new Random(); /* randomisoija */

	public Player() {
		this.keepPlaying = true;
		applications = new ArrayList<Application>(); /* Lista käsittelyssä olevista hakemuksista */
		allowances = new ArrayList<Allowance>(); /* Lista tuista*/
		foreNames.add("Aapo");
		foreNames.add("Juha");
		foreNames.add("Pirkko");
		surNames.add("Asikainen");
		surNames.add("Asikainen");
		surNames.add("Pettersson");
		this.foreName = foreNames.get(rng.nextInt(foreNames.size()));
		this.surName = surNames.get(rng.nextInt(surNames.size()));
		this.money = 100;
		this.health = 100;
		this.sanity = 100;
		this.hunger = 0;
		this.food = 0;
		this.age = 0;
		this.isApplicant = false;
		for (int i = 0; i < 6; i++) {
			this.ssn = this.ssn + Integer.toString(rng.nextInt(9));
		}

		System.out.println("New player "+this.toString()+" initialized (SSN: "+ssn+")");

	}
	public String getPlayerForeName() {
		return this.foreName;
	}
	public String getPlayerSurName() {
		return this.surName;
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
	public String getPlayerSsn() {
		return this.ssn;
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
	public void addApplication(Application application) {
		this.applications.add(application);
	}
	public ArrayList<Application> getApplications() {
		return this.applications;
	}
	public void removeApplication(String name) {
		for (int i=0; i < applications.size(); i++) {
			if (applications.get(i).getApplicationType() == name) {
				applications.remove(i);
			}
		}
	}
	public void addAllowance(Allowance allowance) {
		this.allowances.add(allowance);
	}
	public ArrayList<Allowance> getAllowances() {
		return this.allowances;
	}
	public void removeAllowance(String name) {
		for (int i=0; i < allowances.size(); i++) {
			if (allowances.get(i).getAllowanceType() == name) {
				allowances.remove(i);
			}
		}
	}
	public void stopPlaying() {
		this.keepPlaying = false;
	}

}
