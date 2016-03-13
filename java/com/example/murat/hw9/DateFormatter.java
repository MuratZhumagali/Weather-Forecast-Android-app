package com.example.murat.hw9;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by arman on 08.12.2015.
 */
public class DateFormatter {
    public String formatAMPM(int unixSeconds,int offset) {
        Date date = new Date(unixSeconds*1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a"); // the format of your date
        if (offset<0)
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"+offset)); // give a timezone reference for formating (see comment at the bottom
        else
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+"+offset));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
    public String formatMonthDay(int unixSeconds,int offset) {
        Date date = new Date(unixSeconds*1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d"); // the format of your date
        if (offset<0)
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"+offset)); // give a timezone reference for formating (see comment at the bottom
        else
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+"+offset));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public String getDayOfWeek(int unixSeconds,int offset){
        Date date = new Date(unixSeconds*1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE"); // the format of your date
        if (offset<0)
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"+offset)); // give a timezone reference for formating (see comment at the bottom
        else
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+"+offset));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}
