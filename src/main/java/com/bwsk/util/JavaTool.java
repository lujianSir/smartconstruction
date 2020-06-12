package com.bwsk.util;

import org.apache.commons.lang.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

/**
 * 工具类
 *
 * @author hjy
 */
public class JavaTool {

    /**
     * MD5生成消息摘要算法
     *
     * @param inStr
     * @return
     */
    public static String string2MD5(String inStr) {

        // 申明消息摘要算法
        MessageDigest md5 = null;

        try {
            // 指定MD5算法
            md5 = MessageDigest.getInstance("MD5");

        } catch (Exception e) {

            e.printStackTrace();

            return "不存在的算法！";
        }

        char[] charArray = inStr.toCharArray();

        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)

            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {

            int val = ((int) md5Bytes[i]) & 0xff;

            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * @return
     */
    public static long randomNum() {

        // 此处固定为十一位 可以进行修改
        long min = 1, max = 9;
        for (int i = 1; i < 12; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }

    // 传入logo、二维码 ->带logo的二维码
    public static BufferedImage logoMatrix(BufferedImage matrixImage, String logo) {
        // 在二维码上画logo:产生一个 二维码画板
        Graphics2D g2 = matrixImage.createGraphics();
        // 画logo： String->BufferedImage(内存)
        try {
            BufferedImage logoImg = ImageIO.read(new File(logo));
            int height = matrixImage.getHeight();
            int width = matrixImage.getWidth();
            // 纯logo图片
            g2.drawImage(logoImg, width * 2 / 5, height * 2 / 5, width * 1 / 5, height * 1 / 5, null);
            // 产生一个 画 白色圆角正方形的 画笔
            BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            // 将画板-画笔 关联
            g2.setStroke(stroke);
            // 创建一个正方形
            RoundRectangle2D.Float round = new RoundRectangle2D.Float(width * 2 / 5, height * 2 / 5, width * 1 / 5,
                    height * 1 / 5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            g2.setColor(Color.WHITE);
            g2.draw(round);

            // 灰色边框
            BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            g2.setStroke(stroke2);
            // 创建一个正方形
            RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(width * 2 / 5 + 2, height * 2 / 5 + 2,
                    width * 1 / 5 - 4, height * 1 / 5 - 4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            g2.setColor(Color.GRAY);
            g2.draw(round2);
            g2.dispose();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return matrixImage;
    }

    /**
     * 获取32位UUID
     *
     * @return
     */
    public static String getUserId() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

    // 获取当前时间
    public static String getCurrent() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
        return df.format(new Date());
    }

    // 获取当前时间
    public static String getUserCurrent() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        return df.format(new Date());
    }

    // 获取时间
    public static String getTime(int num) {
        String str = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        switch (num) {
            case 1:// 一个月
                c.setTime(new Date());
                c.add(Calendar.MONTH, 1);
                Date m = c.getTime();
                str = format.format(m);
                break;
            case 2:// 半年
                c.setTime(new Date());
                c.add(Calendar.MONTH, 6);
                Date m3 = c.getTime();
                str = format.format(m3);
                break;
            case 3:// 一年
                c.setTime(new Date());
                c.add(Calendar.YEAR, 1);
                Date y = c.getTime();
                str = format.format(y);
                break;
            case 4:// 永久
                break;
            default:
                break;
        }
        return str;
    }

    /**
     * 文件下载
     *
     * @param path     文件路径
     * @param response
     * @return
     * @author hjy
     */
    public static HttpServletResponse download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    // 两个double相减
    public static double sub(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }

    // 两个字符串相加
    public static BigDecimal add(String str1, String str2) {
        BigDecimal num1 = new BigDecimal(str1);
        BigDecimal num2 = new BigDecimal(str2);
        BigDecimal result = num1.add(num2);
        return result;
    }

    public static BigDecimal f(List<String> arr, int begin) {
        // 找出口
        if (begin == arr.size() - 1) {
            BigDecimal num1 = new BigDecimal(arr.get(begin));
            return num1;
        } else {// 找重复
            BigDecimal str1 = new BigDecimal(arr.get(begin));
            BigDecimal str2 = f(arr, begin + 1);
            BigDecimal result = str1.add(str2);
            return result;
        }

    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    public static String getIp(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if (index != -1) {
                return XFor.substring(0, index);
            } else {
                return XFor;
            }
        }
        XFor = Xip;
        if (StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }

    public static int avg(int a, int b) {
        return (int) Math.ceil((double) (a + b) / 2);

    }

    public static void main(String[] args) {
        System.out.println(avg(1, 6));
    }
}
