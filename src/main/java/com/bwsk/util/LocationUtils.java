package com.bwsk.util;

import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author sc
 * @version V1.0
 * @createTime 2020/6/26 17:21
 * @description
 */
public class LocationUtils {
    // 平均半径,单位：m
    private static final double EARTH_RADIUS = 6371393;

    /**
     * 通过AB点经纬度获取距离 整数
     *
     * @param pointA A点(经，纬)
     * @param pointB B点(经，纬)
     * @return 距离(单位 ： 米)
     */
    public static long getDistance(Point2D pointA, Point2D pointB) {
        // 经纬度（角度）转弧度。弧度用作参数，以调用Math.cos和Math.sin
        // A经弧度
        double radiansAX = Math.toRadians(pointA.getX());
        // A纬弧度
        double radiansAY = Math.toRadians(pointA.getY());
        // B经弧度
        double radiansBX = Math.toRadians(pointB.getX());
        // B纬弧度
        double radiansBY = Math.toRadians(pointB.getY());
        // 公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
        // 反余弦值
        double acos = Math.acos(cos);
        // 最终结果
        double h = EARTH_RADIUS * acos;

        //四舍五入
        long f1 = Math.round(h);
        //保留小数后两位
       /* BigDecimal b = new BigDecimal(h);
        double f1 = b.setScale(2, RoundingMode.HALF_UP).doubleValue();*/
        return f1;
    }


    /**
     * 通过AB点经纬度获取距离  真实距离
     *
     * @param pointA A点(经，纬)
     * @param pointB B点(经，纬)
     * @return 距离(单位 ： 米)
     */
    public static double getDistanceDouble(Point2D pointA, Point2D pointB) {
        // 经纬度（角度）转弧度。弧度用作参数，以调用Math.cos和Math.sin
        // A经弧度
        double radiansAX = Math.toRadians(pointA.getX());
        // A纬弧度
        double radiansAY = Math.toRadians(pointA.getY());
        // B经弧度
        double radiansBX = Math.toRadians(pointB.getX());
        // B纬弧度
        double radiansBY = Math.toRadians(pointB.getY());
        // 公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
        // 反余弦值
        double acos = Math.acos(cos);
        // 最终结果
        double h = EARTH_RADIUS * acos;
        return h;
    }

    /**
     * 通过AB点经纬度获取距离  小数后俩位
     *
     * @param pointA A点(经，纬)
     * @param pointB B点(经，纬)
     * @return 距离(单位 ： 米)
     */
    public static double getDistanceDoubleBy2(Point2D pointA, Point2D pointB) {
        // 经纬度（角度）转弧度。弧度用作参数，以调用Math.cos和Math.sin
        // A经弧度
        double radiansAX = Math.toRadians(pointA.getX());
        // A纬弧度
        double radiansAY = Math.toRadians(pointA.getY());
        // B经弧度
        double radiansBX = Math.toRadians(pointB.getX());
        // B纬弧度
        double radiansBY = Math.toRadians(pointB.getY());
        // 公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
        // 反余弦值
        double acos = Math.acos(cos);
        // 最终结果
        double h = EARTH_RADIUS * acos;
        //保留小数后两位
        BigDecimal b = new BigDecimal(h);
        double f1 = b.setScale(2, RoundingMode.HALF_UP).doubleValue();
        return f1;
    }

    //判断两点的距离是否满足要求
    public static boolean checkDistance(double x1, double y1, double x2, double y2, int distance) {
        Point2D pointDD = new Point2D.Double(x1, y1);
        Point2D pointXD = new Point2D.Double(x2, y2);
        boolean flag = getDistance(pointDD, pointXD) < distance;
        return flag;
    }

    public static void main(String[] args) {
        //中煤大厦西门
        // Point2D pointDD = new Point2D.Double( 116.414735,39.963634);
        // 北京 将宅口
        //Point2D pointDD = new Point2D.Double(116.414942,39.963859);
        // 北京  将宅十字路口
        //Point2D pointDD = new Point2D.Double(116.414775,39.965553);
        //北京 将宅十字路口东门116.417304,39.9652
        Point2D pointDD = new Point2D.Double(116.417304, 39.9652);
        // 北京 将宅口
        Point2D pointXD = new Point2D.Double(116.414942, 39.963859);

//        double distanceDouble = getDistanceDouble(pointDD, pointXD);
//        System.out.println(distanceDouble);
//        System.out.println(distanceDouble < 200);
//        System.out.println();
//
//        double distanceDouble2 = getDistanceDoubleBy2(pointDD, pointXD);
//        System.out.println(distanceDouble2);
//        System.out.println(distanceDouble2 < 200);
//        System.out.println();

        Long distance = getDistance(pointDD, pointXD);
        System.out.println(distance);
        System.out.println(distance < 300);



       /* // 北京 东单地铁站
        Point2D pointDD = new Point2D.Double(116.425249, 39.914504);
        // 北京 西单地铁站
        Point2D pointXD = new Point2D.Double(116.382001, 39.913329);
        System.out.println(getDistance(pointDD, pointXD));
        System.out.println();*/

      /*  // 北京 天安门
        Point2D pointTAM = new Point2D.Double(116.403882, 39.915139);
        // 广州 越秀公园
        Point2D pointGZ = new Point2D.Double(113.272422, 23.147387);
        System.out.println(getDistance(pointTAM, pointGZ));
        System.out.println();*/

      /*  // 四川大学
        Point2D pointSCDX = new Point2D.Double(104.090539, 30.636951);
        // 成都南站
        Point2D pointCDNZ = new Point2D.Double(104.074238, 30.612572);
        System.out.println(getDistance(pointSCDX, pointCDNZ));
        System.out.println();*/
        boolean flag = checkDistance(116.417304, 39.9652, 116.414942, 39.963859, 300);
        System.out.println(flag);

    }
}