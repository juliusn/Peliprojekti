package peliprojekti;

public class Calendar implements Serializable {
	private int dateCounter = 0;
	
	public int getDateCounter() {
		return dateCounter;
	}
	public void increaseDateCounter() {
		dateCounter++;
	}

}
