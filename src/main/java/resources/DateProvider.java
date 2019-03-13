package resources;

import java.util.Calendar;

public class DateProvider {
	private static final Calendar c;

	static {
		c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 15);
	}

	public static int getMonth() {
		return c.get(Calendar.MONTH);
	}

	public static int getDate() {
		return c.get(Calendar.DATE);
	}

}
