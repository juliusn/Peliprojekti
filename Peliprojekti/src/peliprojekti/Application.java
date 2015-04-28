package peliprojekti;

import com.googlecode.lanterna.gui.Window;

public class Application extends Window {
	private String name = null;
	
	
	public Application(String title) {
		super(title);
		this.name = title;
		System.out.println("Application "+title+" created");
	}

	private Calendar newCalendar = new Calendar();
	private int kasittelypaiva = 0;
	private int x = 0;


	public void fillApplication(Player player) {





		/*
			// lomakkeen täyttäminen
			x = (int) (Math.random()*20) + 10; // testausta varten
			kasittelypaiva = newCalendar.getDateCounter() + x; // testausta varten
			System.out.println("Lomake on täytetty, odota "+x+" päivää.");*/
		kasittelypaiva = newCalendar.dateCounter + x; // testausta varten
		System.out.println("Lomake on täytetty, odota "+x+" päivää.");
	}

	/* public int getKasittelypaiva() {
			return kasittelypaiva;
		} */

	public void checkApplication(Player player) {
		// tehdään GameEnginen while looppissa
		/*
			if (kasittelypaiva == newCalendar.getDateCounter()) {
=======
			if (kasittelypaiva == newCalendar.dateCounter) {
>>>>>>> branch 'master' of https://github.com/juliusn/Peliprojekti.git
				// tuet tulee
<<<<<<< HEAD
				player.changePlayerMoney(100);
=======
				// player.changePlayerMoney(100); 
>>>>>>> branch 'master' of https://github.com/juliusn/Peliprojekti.git
				System.out.println("Hakemuksesi on käsitelty!");
				System.out.println("Raha: +100");
			} else {
				// tuet eivät tule
<<<<<<< HEAD
		}*/
		System.out.println("Ei rahaa kelasta");
	}

	public void fill() {


	}


	public String getName() {
		return this.name;
	}

}