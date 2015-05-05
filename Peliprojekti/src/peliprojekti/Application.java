package peliprojekti;

import java.io.Serializable;


public class Application implements Serializable {
	private static final long serialVersionUID = 1L;
	private String applicationType;
	private String foreName;
	private String surName;
	private String ssn;
	private int dateCounter = 0;
	private int expDate = 0;
	private boolean isApproved;
	private String explanation;

	public Application(String name, Player player) {
		applicationType = name;
		this.dateCounter = 0;
		switch (this.applicationType) {
		case "Työttömyyspäivärahahakemus":
			this.expDate = 7;
			break;
		case "Toimeentulotukihakemus":
			this.expDate = 14;
			break;
		case "Asumistukihakemus":
			this.expDate = 21;
			break;
		}
	}
	public void setForeName(String foreName) {
		this.foreName = foreName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getApplicationType() {
		return this.applicationType;
	}
	public void increaseDateCounter(int i) {
		this.dateCounter = this.dateCounter + i;
	}
	public void check(Player player) {
		if (this.dateCounter >= expDate) {
			switch (this.applicationType) {
			case "Työttömyyspäivärahahakemus":
				if (player.isApplicant) {
					this.isApproved = true;
				} else {
					this.explanation = "Tuen hakija ei ollut ilmoittautunut työttömäksi työnhakijaksi määräaikaan mennessä.";
				}
				break;
			case "Toimeentulotukihakemus":
				if (player.isApplicant) {
					this.isApproved = true;
				} else {
					this.explanation = "Tuen hakija ei ollut ilmoittautunut työttömäksi työnhakijaksi määräaikaan mennessä.";
				}
				break;
			case "Asumistukihakemus":
				this.isApproved = true;
				break;
			}
			if (this.isApproved) {
				Allowance allowance = new Allowance(this.getApplicationType(), player);
				player.addAllowance(allowance);
			} else {
				this.isApproved = false;
			}
		}
	}
	public boolean isApproved() {
		return this.isApproved;
	}

}
