package com.bwsk.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: jenkinwang
 * @date: 2018/9/28 15:51
 * @description:
 */
public class DateUtil {

    /**
     * 获取当前时间 年月日 时分秒
     *
     * @return
     */
    public static String getCurrentDatetime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 获取当前时间 年月日
     *
     * @return
     */
    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 日期转换
     *
     * @param date
     * @return
     */
    public static String getStringDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static Date parseStringToDate1(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(time);
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
     * 获取当月的工作日的次数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDates(int year, int month) {
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
        return dates.size();
    }

    public static String requestHoliday(String httpArg) {
        String httpUrl = "http://tool.bitefu.net/jiari/";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?d=" + httpArg;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //获取是否是工作日以及周几
    public static Map<String, String> getWeeKMsg(String httpArg) throws Throwable {
        String jsonResult = requestHoliday(httpArg);
        Map<String, String> map = new HashMap<String, String>();
        // 0 上班  1周末 2节假日
        if ("0".equals(jsonResult)) {
            map.put("data", dayForWeek(httpArg));
            map.put("msg", "上班");
        }
        if ("1".equals(jsonResult)) {
            map.put("data", dayForWeek(httpArg));
            map.put("msg", "周末");
        }
        if ("2".equals(jsonResult)) {
            map.put("data", dayForWeek(httpArg));
            map.put("msg", "节假日");
        }
        return map;
    }

    public static String getHour(String startTime, String endTime, String format) throws Throwable {
        //按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
        long nh = 1000 * 60 * 60;//一小时的毫秒数
        long nm = 1000 * 60;//一分钟的毫秒数
        long ns = 1000;//一秒钟的毫秒数
        long diff;
        //获得两个时间的毫秒时间差异
        diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
        long day = diff / nd;//计算差多少天
        long hour = diff % nd / nh;//计算差多少小时
        long min = diff % nd % nh / nm;//计算差多少分钟
        long sec = diff % nd % nh % nm / ns;//计算差多少秒//输出结果
        if (day > 0) {
            hour = day * 24 + hour;
        }
        if (hour > 0) {
            min = hour * 60 + min;
        }
        // System.out.println("时间相差：" + day + "天" + hour + "小时" + min + "分钟" + sec + "秒。");
        return min + "";
    }


    public static List<String> getWorkDays(String date1, String date2) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //首先得到两个日期之间的所有日期信息
        List<String> allDays = new ArrayList<>();
        int dayTime = 24 * 60 * 60 * 1000;
        long d1 = format.parse(date1).getTime();
        long d2 = format.parse(date2).getTime();
        while (d2 >= d1) {
            String time = format.format(d1);
            allDays.add(time);
            d1 += dayTime;
        }

        //将得到的所有日期遍历，将每个日期的星期信息取出，然后将周日和周六的过滤掉即可
        Calendar calendar = Calendar.getInstance();
        List<String> workdays = new ArrayList<>();
        for (String str : allDays) {
            calendar.setTime(format.parse(str));
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (week != 1 && week != 7) {
                workdays.add(str);
            }
        }
        return workdays;
    }


    public static void main(String[] args) throws Throwable {

//        String a = dayForWeek("2020-07-06");
//
//        System.out.println(a);
//        List<Date> dates = getDates(2020, 7);
//        for (Date date : dates) {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            System.out.println(format.format(date));
//        }

//        String httpArg = "2020-05-01";
//        System.out.println(getWeeKMsg(httpArg));
//        String min = getHour("2014-05-27 17:00:00", "2014-05-27 18:40:58", "yyyy-MM-dd HH:mm");
//        System.out.println("---------相隔分钟数： " + min);
//        List<String> result = getWorkDays("2020-07-01", "2020-07-23");
//        System.out.println(result);

        String sr = getStringDate(parseStringToDate1("2020-7-23"));
        System.out.println(sr);
    }
}
