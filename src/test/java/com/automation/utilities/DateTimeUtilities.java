package com.automation.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {
    /**
     * MM-to specify month like : 01,02,03, etc...
     * MMM-Jan, Feb, Mar
     * <p>
     * dd - to specify day like---- 01, 02,03, etc...
     * <p>
     * yyyy--> to specify year in --- 2010, 2020, etc.. format
     *
     * @param format ---for example : MMM dd, yyyy
     * @return current date as a String
     */

    public static String getCurrentDate(String format) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    /**
     * Returns difference between end and start time
     *
     * @param start
     * @param end
     * @param format
     * @return
     */

    public static long getTimeDifference(String start, String end, String format) {
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format)); // creating LocalTime obj.
        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));

        return ChronoUnit.HOURS.between(startTime, endTime);
    }
}
