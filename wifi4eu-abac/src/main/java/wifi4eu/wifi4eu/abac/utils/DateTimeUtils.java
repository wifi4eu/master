package wifi4eu.wifi4eu.abac.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jlopezri
 *
 */
public class DateTimeUtils {

	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private final static Logger log = LoggerFactory.getLogger(DateTimeUtils.class);

	/**
	 * Private constructor
	 */
	private DateTimeUtils() {

	}

	public static Date parseDate(String date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			log.error("ERROR parsing date {}",date,e);
		}
		return parsedDate;
	}
}
