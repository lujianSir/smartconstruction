package com.bwsk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public static void main(String[] args) throws Throwable {

        String a = dayForWeek("2020-07-03");

        System.out.println(a);

    }
}
