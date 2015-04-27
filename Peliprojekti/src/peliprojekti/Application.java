package peliprojekti;

public class Application {
		//private Player player;
		private Calendar newCalendar = new Calendar();
		private int kasittelypaiva = 0;
		private int x = 0;

		public void fillApplication() {
			// lomakkeen täyttäminen
			x = (int) (Math.random()*20) + 10; // testausta varten
			kasittelypaiva = newCalendar.dateCounter + x; // testausta varten
			System.out.println("Lomake on täytetty, odota "+x+" päivää.");
		}

		/* public int getKasittelypaiva() {
			return kasittelypaiva;
		} */

		public void checkApplication() {
		// tehdään GameEnginen while looppissa
			if (kasittelypaiva == newCalendar.dateCounter) {
				// tuet tulee
				// player.changePlayerMoney(100); 
				System.out.println("Hakemuksesi on käsitelty!");
				System.out.println("Raha: +100");
			} else {
				// tuet eivät tule
				System.out.println("Ei rahaa kelasta");
		}
	}

}
