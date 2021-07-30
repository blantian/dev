package org.xtj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间处理
 */
public class DateTimeUtil {


    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 2021-06-08T19:20:02+08:00  =》 2021-06-08 19:20:02
     */
    public static String toYMDhms(String dateStr) throws ParseException {

        Date date1 = sdf.parse(dateStr);
        String dateString = sdf2.format(date1);
        return dateString;
    }


    /**
     *  2021-06-08 19:20:02 => 1511688005000
     */
    public static Long toTS(String dateStr) {

        long l = 0;
        try {
            l = sdf2.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l;
    }


    /**
     *  1511688005000 => 2021-06-08 19:20:02
     */
    public static String todateStr(Long l) {

        String dateStr = sdf2.format(new Date(l));
        return dateStr;
    }

}
