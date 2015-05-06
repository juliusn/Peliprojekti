package kelasim;

import java.io.Serializable;


public class Application implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String applicationType;
	protected String foreName;
	protected String surName;
	protected String ssn;
	protected int dateCounter = 0;
	protected int expDate = 0;
	protected boolean isApproved;
	protected boolean isProcessed;
	protected String explanation;

	public Application(String name, Player player) {
		applicationType = name;
		this.dateCounter = 0;
		this.isApproved = false;
		this.isProcessed = false;
	}
	public String getForeName() {
		return this.foreName;
	}
	public String getSurName() {
		return this.surName;
	}
	public String getSsn() {
		return this.ssn;
	}
	public String getExplanation() {
		return this.explanation;
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
		// empty
	}
	public boolean isApproved() {
		return this.isApproved;
	}
	public boolean isProcessed() {
		return this.isProcessed;
	}
	public void setProcessed() {
		this.isProcessed = true;
	}
}
