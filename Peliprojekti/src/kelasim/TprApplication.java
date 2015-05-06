package kelasim;

public class TprApplication extends Application {

	private static final long serialVersionUID = 1L;

	public TprApplication(String name, Player player) {
		super(name, player);
		this.expDate = 7;
	}
	
	public void check(Player player) {
		if (this.dateCounter >= expDate) {
			if (this.foreName.equalsIgnoreCase(player.getPlayerForeName())  /* Onko hakemuksen tiedot oikein */
					&& this.surName.equalsIgnoreCase(player.getPlayerSurName())
					&& this.ssn.equals(player.getPlayerSsn())) {
					if (player.isApplicant) { /* Onko pelaaja työnhakija */
						this.isApproved = true;
					} else {
						this.isApproved = false; /* Hylätty */
						this.isProcessed = true;
						this.explanation = "Tuen hakija ei ollut ilmoittautunut työttömäksi työnhakijaksi määräaikaan mennessä.";
					}
					
			} else {
				this.isApproved = false; /* Hylätty */
				this.isProcessed = true;
				this.explanation = this.applicationType+" hylätty. Hakemus oli täytetty puutteellisesti.";
			}
			if (this.isApproved) {
				this.isProcessed = true;
				this.explanation = this.applicationType+" hyväksytty.";
				Allowance allowance = new Allowance(this, player); 
				player.addAllowance(allowance); /* Lisää pelaajalle myönnetty tuki */
			} 
		}
	}
}
