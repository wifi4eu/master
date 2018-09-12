package wifi4eu.wifi4eu.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class DateUtils {

	public LocalDate getLocalTimeFromDate(Date datedef) {
		java.sql.Date sDate = new java.sql.Date(datedef.getTime());
		return sDate.toLocalDate();
	}

	public String convertDate2String(Date date) {
		if (date != null) {
			// SimpleDateFormat is not thread-safe
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		}
		return StringUtils.EMPTY;
	}

}
