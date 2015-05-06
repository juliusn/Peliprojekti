package kelasim;

public class Allowance {
	private String allowanceType;
	private int amount;
	private int cycle;
	private int cycleCounter;
	private int dateCounter;
	private int payments;
	public boolean isApproved;

	public Allowance(String name, Player player) {
		this.allowanceType = name;
		this.isApproved = true;
		this.cycleCounter = 0;
		switch (name) {
		case "Työttömyyspäivärahahakemus":
			this.cycle = 30;
			this.amount = 300;
			this.payments = 6;
			break;
		case "Toimeentulotukihakemus":
			this.cycle = 30;
			this.amount = 150;
			this.payments = 1;
			break;
		case "Asumistukihakemus":
			this.cycle = 30;
			this.amount = 250;
			this.payments = 12;
			break;
		}
	}

	public String getAllowanceType() {
		return this.allowanceType;
	}

	public void increaseDate(Player player) {
		this.dateCounter++;
		if (this.cycleCounter < this.cycle) {
			this.cycleCounter++;
		} else {
			this.cycleCounter = 0;
			player.changePlayerMoney(amount);
			this.payments--;
			if (this.payments == 0) {
				this.isApproved = false;
				player.getAllowances().remove(this);
			}
		}
		
	}
	public int getAmount() {
		return this.amount;
	}
	public int getCycle() {
		return this.cycle;
	}
	public int getDateCounter() {
		return this.dateCounter;
	}
}
