package peliprojekti;

public class Allowance {
	private String allowanceType;
	private int amount;
	private int cycle;
	private int dateCounter;
	private int expDate;
	public boolean isApproved;
	
	public Allowance(String name, Player player) {
		this.allowanceType = name;
		this.isApproved = true;
		switch (name) {
		case "Työttömyyspäivärahahakemus":
			this.cycle = 30;
			this.amount = 300;
			break;
		case "Toimeentulotukihakemus":
			this.cycle = 30;
			this.amount = 150;
			break;
		case "Asumistukihakemus":
			this.cycle = 30;
			this.amount = 250;
			break;
		}
	}

	public String getAllowanceType() {
		return this.allowanceType;
	}

	public void increaseDateCounter(int i) {
		this.dateCounter = this.dateCounter + i;
	}
	public int getAmount() {
		return this.amount;
	}
	public int getCycle() {
		return this.cycle;
	}
}
