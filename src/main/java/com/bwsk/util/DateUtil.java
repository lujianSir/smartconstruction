package com.bwsk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: jenkinwang
 * @date: 2018/9/28 15:51
 * @description:
 */
public class DateUtil {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDatetime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 将字符串转换成日期
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date parseStringToDate(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(time);
    }

    /**
     * 获取当前时间的毫秒数
     *
     * @return
     */
    public static long getCurrentMillis() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    /**
     * 获取自定义时间的毫秒数
     *
     * @return
     */
    public static long getCustomDateMillis(String datetime) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(parseStringToDate(datetime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getTimeInMillis();
    }


    /**
     * 查询当前是星期几
     *
     * @param pTime
     * @return
     * @throws Throwable
     */
    public static String dayForWeek(String pTime) throws Throwable {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date tmpDate = format.parse(pTime);

        Calendar cal = Calendar.getInstance();

        String[] weekDays = {"星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        try {

            cal.setTime(tmpDate);

        } catch (Exception e) {

            e.printStackTrace();

        }

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。

        if (w < 0)

            w = 0;

        return weekDays[w];

    }


    /**
     * 获取当月的工作日
     *
     * @param year
     * @param month
     * @return
     */
    public static List<Date> getDates(int year, int month) {
        List<Date> dates = new ArrayList<Date>();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);


        while (cal.get(Calendar.YEAR) == year &&
                cal.get(Calendar.MONTH) < month) {
            int day = cal.get(Calendar.DAY_OF_WEEK);

            if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
                dates.add((Date) cal.getTime().clone());
            }
            cal.add(Calendar.DATE, 1);
        }
        return dates;
    }

    public static void main(String[] args) throws Throwable {

        String a = dayForWeek("2020-07-06");

        System.out.println(a);
        List<Date> dates = getDates(2020, 7);
        for (Date date : dates) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(format.format(date));
        }

    }
}
