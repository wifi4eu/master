package wifi4eu.wifi4eu.abac.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author jlopezri
 *
 */
public class DateTimeUtils {

	private final static Logger log = LoggerFactory.getLogger(DateTimeUtils.class);

	/**
	 * Private constructor
	 */
	private DateTimeUtils() {

	}

	public static Date parseDate(String date, String format) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			//try an alternative format just in case the user has edited the file via MS Excel and it has altered the date format
			try {
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				parsedDate = dateFormat.parse(date);
			} catch (ParseException e2) {
				log.error("ERROR parsing date {}",date,e);
				throw e2;
			}
		}
		return parsedDate;
	}

	public static String format(Date date, String pattern) {
		String stringDate = new String();
		if (date != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			LocalDateTime localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			stringDate = localDate.format(formatter);
		}
		return stringDate;
	}
}
