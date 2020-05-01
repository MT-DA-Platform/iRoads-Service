package com.codemo.iroads.Util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class Utils {

    public static Date timeStampToDate(Long unixTime){
        Date date = new Date(unixTime*1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT-5.30"));
        String java_date = jdf.format(date);
        StringTokenizer st = new StringTokenizer(java_date,"-");

        date.setYear(Integer.parseInt(st.nextToken()));
        date.setMonth(Integer.parseInt(st.nextToken()));
        date.setDate(Integer.parseInt(st.nextToken()));
        date.setHours(Integer.parseInt(st.nextToken()));
        date.setMinutes(Integer.parseInt(st.nextToken()));
        date.setSeconds(Integer.parseInt(st.nextToken()));

        return date;
    }

    public static Long DateToTimeStamp(Date date){
        return date.getTime()/1000;
    }
}
