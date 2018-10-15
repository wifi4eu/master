package wifi4eu.wifi4eu.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class DateUtils {

    private static final Logger _log = LoggerFactory.getLogger(DateUtils.class);

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

    public Date convertToDate(String source) {
        if (source != null) {
            // SimpleDateFormat is not thread-safe
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(source);
            } catch (ParseException e) {
                _log.error("Error parsing a date " + source, e);
                // Do nothing, return an empty date
            }
        }
        return null;
    }

}
