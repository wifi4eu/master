package wifi4eu.wifi4eu.common.helper;

import wifi4eu.wifi4eu.common.Constant;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

final public class ConversionHelper {

    public static String dateToString(Date dateToConvert) {

        if (dateToConvert == null) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_FORMAT);
        String date = sdf.format(dateToConvert);

        return date;
    }

    public static String timestampToString(Date timestampToConvert) {

        if (timestampToConvert == null) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATETIME_FORMAT);
        String date = sdf.format(timestampToConvert);

        return date;
    }


    public static Long bigDecimalToLong(BigDecimal value) {
        return value.longValue();
    }

    public static BigDecimal longToBigDecimal(Long value) {
        return new BigDecimal(value);
    }

}
