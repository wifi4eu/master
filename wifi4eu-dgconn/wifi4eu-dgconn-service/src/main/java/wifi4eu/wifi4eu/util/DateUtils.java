package wifi4eu.wifi4eu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtils {

	public LocalDate getLocalTimeFromDate(Date datedef) {
		java.sql.Date sDate = new java.sql.Date(datedef.getTime());
		return sDate.toLocalDate();
	}

	public Long convertDate2Long(Date date) {
		return Long.valueOf(date.getTime());
	}

	public Date convertLong2Date(Long date) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);
		return cal.getTime();
	}

	public String convertDate2String(Date date) {
		// SimpleDateFormat is not thread-safe
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	private Date convertString2Date(String date) throws ParseException {
		// SimpleDateFormat is not thread-safe
		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}

	public String convertLong2String(Long date) {
		Date newDate = convertLong2Date(date);
		return convertDate2String(newDate);
	}

	public Long convertString2Long(String date) throws ParseException {
		Date newDate = convertString2Date(date);
		return convertDate2Long(newDate);
	}

}
