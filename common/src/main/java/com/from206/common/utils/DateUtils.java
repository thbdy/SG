package com.from206.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期处理工具类
 *
 * @author suyx
 */
public class DateUtils extends android.text.format.DateUtils {

    /**
     * 获取一个日期到今天的天数
     *
     * @param dayCount
     * @return
     */
    public static Date getDateFromToday(int dayCount) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayCount);
        return calendar.getTime();
    }

    /**
     * 获取一个日期的相对时间的日期
     *
     * @param date
     * @param dayCount
     * @return
     */
    public static Date getDateFromOneDate(Date date, int dayCount) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayCount);
        return calendar.getTime();
    }

    /**
     * 获取一天的开始时间
     *
     * @param date
     * @return
     */
    public static Date getOneDateBegin(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取一天的结束时间
     *
     * @param date
     * @return
     */
    public static Date getOneDateEnd(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);

        return calendar.getTime();
    }

    /**
     * 获取一个日期到今天的天数
     *
     * @param dayCount
     * @param pattern
     * @return
     */
    public static String getDateFromToday(int dayCount, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(getDateFromToday(dayCount));
    }

    /**
     * 将一个时间字符串转成另一种格式的字符串
     *
     * @param dateStr
     * @param from
     * @param to
     * @return
     */
    public static String format(String dateStr, String from, String to) {
        String result = "";
        try {
            Date date = new SimpleDateFormat(from).parse(dateStr);
            result = new SimpleDateFormat(to).format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将日期类型转化为指定格式的字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 将日期字符串转化为日期类型
     *
     * @param time
     * @param pattern
     * @return
     */
    public static Date formatToDate(String time, String pattern) {
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将日期转化为+0800格式的字符串
     *
     * @param date
     * @return
     */
    public static String formatTimestamp(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date).replace(" ", "T") + "+0800";
    }

    public static String formatTimestampToString(String timestamp) {
        return timestamp.replace("T", " ").replace("+0800", "")
                .replace("+08:00", "");
    }

    /**
     * 将+0800格式的日期字符串转为日期
     *
     * @param timestamp
     * @return
     */
    public static Date formatTimestampToDate(String timestamp) {
        String time = formatTimestampToString(timestamp);
        return formatToDate(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取指定时间的经过指定秒数的时间
     *
     * @param date
     * @param second
     * @return
     */
    public static Date getDateFromSecond(Date date, int second) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 获取两个日期的天数差
     *
     * @param from
     * @param to
     * @return
     */
    public static int getDayBetweenTwoDate(Date from, Date to) {
        Calendar calendarFrom = new GregorianCalendar();
        calendarFrom.setTime(from);
        calendarFrom.set(Calendar.HOUR_OF_DAY, 0);
        calendarFrom.set(Calendar.MINUTE, 0);
        calendarFrom.set(Calendar.SECOND, 0);
        calendarFrom.set(Calendar.MILLISECOND, 0);

        Calendar calendarTo = new GregorianCalendar();
        calendarTo.setTime(to);
        calendarTo.set(Calendar.HOUR_OF_DAY, 0);
        calendarTo.set(Calendar.MINUTE, 0);
        calendarTo.set(Calendar.SECOND, 0);
        calendarTo.set(Calendar.MILLISECOND, 0);

        int dayCount = (int) ((to.getTime() - from.getTime()) / 1000 / 60 / 60 / 24);
        calendarFrom.add(Calendar.DATE, dayCount);
        while (!calendarFrom.equals(calendarTo)) {
            if (calendarFrom.before(calendarTo)) {
                dayCount++;
                calendarFrom.add(Calendar.DATE, 1);
            } else {
                dayCount--;
                calendarFrom.add(Calendar.DATE, -1);
            }
        }
        return dayCount;
    }

    /**
     * 指定年月日是否超出指定日期
     *
     * @param year
     * @param month
     * @param day
     * @param date
     * @param after
     * @return
     */
    public static boolean outOfDate(int year, int month, int day, Date date,
                                    boolean after) {
        Calendar calendar = getCalendar(year, month, day);
        String input = DateUtils.format(calendar.getTime(), "yyyy-MM-dd");
        String dateStr = DateUtils.format(date, "yyyy-MM-dd");
        if ((after && input.compareTo(dateStr) > 0)
                || (!after && input.compareTo(dateStr) < 0)) {
            return true;
        }
        return false;
    }

    /**
     * 获取Calendar
     *
     * @param date
     * @return
     */
    public static Calendar getCalendar(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 获取Calendar
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Calendar getCalendar(int year, int month, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar;
    }

    /**
     * 获取两个时间之间的时间差文本
     *
     * @param from
     * @param to
     * @return
     */
    public static String getTimeTextBetweenTwoDate(Date from, Date to) {
        String text = "";
        long minus = (to.getTime() - from.getTime()) / 1000 / 60;
        if (minus < 60) {
            text = Math.max(minus, 1) + "分钟前";
        } else if (minus < 60 * 24) {
            text = minus / 60 + "小时前";
        } else {
            text = minus / 60 / 24 + "天前";
        }

        return text;
    }

    /**
     * 根据传入的毫秒数获取分秒文本
     *
     * @param ms 毫秒数
     * @return MM:ss
     */
    public static String getTimeTextHHMM(int ms) {
        ms = ms + 500;
        int time = ms / 1000;
        String ss = String.format("%02d", time % 60);
        time = time / 60;
        String mm = String.format("%02d", time % 60);
        return mm + ":" + ss;
    }

    public static int getWeekOfMonth(Date date) {
        Calendar calendar = getCalendar(date);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 转换字符串日期
     * @param time
     * @return
     */
    public static String getDateToString(long time) {
        long newTime = time*1000L;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date(time);
        return sdf.format(newTime);
    }
    /**
     * 转换字符串日期
     * @return
     */
    public static String getDateToString(String date) {

        return date.substring(0,4)+"年"+date.substring(4,6)+"月"+date.substring(6)+"日";
    }
}
