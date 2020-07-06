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

    public static void main(String[] args) throws Throwable {

//        String a = dayForWeek("2020-07-06");
//
//        System.out.println(a);
//        List<Date> dates = getDates(2020, 7);
//        for (Date date : dates) {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            System.out.println(format.format(date));
//        }

        String httpArg = "2020-05-01";
        System.out.println(getWeeKMsg(httpArg));
    }
}
