package wifi4eu.wifi4eu.common.utils;

import java.time.LocalDate;
import java.util.Date;

public class Utils {

    public static boolean contains(int[] arr, int item) {
        for (int n : arr) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }

    public static long getHoursBetweenDates(Date startDate, Date endDate){
        long different = endDate.getTime() - startDate.getTime();
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long elapsedHours = different / hoursInMilli;
        return elapsedHours;
    }
}
