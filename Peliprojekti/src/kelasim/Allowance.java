package kelasim;

import java.io.Serializable;

public class Allowance implements Serializable {
	private static final long serialVersionUID = 1L;
	private String allowanceType;
	private int amount;
	private int cycle;
	private int cycleCounter;
	private int dateCounter;
	private int payments;
	public boolean isApproved;

	public Allowance(TprApplication tprApplication, Player player) {
		this.allowanceType = "Työttömyyspäivärahatuki";
		this.isApproved = true;
		this.cycleCounter = 0;
		this.cycle = 30;
		this.amount = 300;
		this.payments = 6;
	}

	public Allowance(TttApplication tttApplication, Player player) {
		this.allowanceType = "Toimeentulotuki";
		this.isApproved = true;
		this.cycleCounter = 0;
		this.cycle = 30;
		this.amount = 150;
		this.payments = 1;
	}
	
	public Allowance(AtApplication atApplication, Player player) {
		this.allowanceType = "Asumistuki";
		this.isApproved = true;
		this.cycleCounter = 0;
		this.cycle = 30;
		this.amount = 250;
		this.payments = 12;
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
			player.changePlayerMoney(amount); /* Maksu */
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
