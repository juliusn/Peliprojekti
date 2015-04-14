package peliprojekti;

import java.io.Serializable;

public class Calendar implements Serializable {
	private static final long serialVersionUID = 1L;
	private int dateCounter = 0;
	
	public int getDateCounter() {
		return dateCounter;
	}
	public void increaseDateCounter() {
		dateCounter++;
	}

}
