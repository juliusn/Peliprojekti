package kelasim;

import java.io.Serializable;

public class DateCounter implements Serializable {
	private static final long serialVersionUID = 1L;
	public static int dateCounter = 0;
	public int getDateCounter() {
		return dateCounter;
	}
}
