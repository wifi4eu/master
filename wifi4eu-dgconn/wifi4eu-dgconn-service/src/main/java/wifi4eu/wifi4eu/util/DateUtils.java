package wifi4eu.wifi4eu.util;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class DateUtils {

    public LocalDate getLocalTimeFromDate(Date datedef){
        java.sql.Date sDate = new java.sql.Date(datedef.getTime());
        return sDate.toLocalDate();
    }
}
