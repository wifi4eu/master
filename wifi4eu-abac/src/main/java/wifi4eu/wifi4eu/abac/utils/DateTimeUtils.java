package wifi4eu.wifi4eu.abac.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jlopezri
 *
 */
public class DateTimeUtils {

	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/**
	 * Private constructor
	 */
	private DateTimeUtils() {

	}

	public static String getCurrentDateTime() {
		return dateFormat.format(new Date());
	}

	public static Date parseDate(String date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return null;
	}
}
