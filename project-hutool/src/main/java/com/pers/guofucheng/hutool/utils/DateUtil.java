package com.pers.guofucheng.hutool.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 *
 * @author guofucheng
 * @date 2020/12/25
 */
public class DateUtil {

    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    public static final String STR_DATEFORMAT = "yyyyMMddHHmmss";
    public static final String FORMAT_TEMPLATE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期字符串
     *
     * @param date 日期
     * @return {@link String}
     */
    public static String dateToStringForTemplate(@NotNull Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 日期字符串
     *
     * @param date 日期
     * @return {@link String}
     */
    public static String dateToString(@NotNull Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(STR_DATEFORMAT);
        return sdf.format(date);
    }

    /**
     * @Description: 指定格式的字符串转换为另一种指定格式
     * yyyy:年 MM:月 dd:日 D:日 H:24小时制 h:12小时制 m:分钟 s:秒 S毫秒数
     * 常用格式示例: yyyy/MM/dd HH:mm:ss.SSS
     * @Author: guofucheng
     * @Date: 2020/12/29 20:46:11
     * @Version: 1.0
     * @method: dateFormatconVersion()
     * @param: [] 传入的日期字符串, 传入的日期字符串的格式, 传出的日期字符串格式.
     * @return: java.lang.String 传出指定格式的日期字符串
     */
    public static String dateFormatConversion(String inputDateStr, String inputDateFormat, String outDateFormat) {
        SimpleDateFormat sdf1 = new SimpleDateFormat(inputDateFormat);
        SimpleDateFormat sdf2 = new SimpleDateFormat(outDateFormat);
        //转换成Date对象
        Date tempDate = null;
        try {
            tempDate = sdf1.parse(inputDateStr);
        } catch (ParseException e) {
            log.error("dateFormatConversion发生异常",e);
        }
        //Date对象转换成String
        return sdf2.format(tempDate);
    }

    /**
     * 获取开始时间
     *
     * @param date 日期
     * @return {@link Date}
     */
    public static Date getStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取结束时间
     *
     * @param date 日期
     * @return {@link Date}
     */
    public static Date getEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 解析时间
     *
     * @param dateStr 日期Str
     * @param format  格式
     */
    public static Date parseToDate(String dateStr, String format) {
        //字符串转Date类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            log.error("parseToDate发生异常",e);
        }
        return new Date();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(betweenDays));
    }

    /**
     * 字符串的日期格式的计算
     */
    public static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(betweenDays));
    }

    /**
     * 获得指定日期的后一天
     *
     * @param date
     * @return
     */
    public static Date getSpecifiedDayAfter(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);
        return c.getTime();
    }

    /**
     * 计算时间间隔日期
     *
     * @param startDate startDate
     * @param endDate   endDate
     * @return {@link List<Date>}
     */
    public static List<Date[]> calculationIntervalDate(@NotNull Date startDate, @NotNull Date endDate) {
        //1.开始时间转换yyyy-MM-dd,并设置时间时分秒为23:59:59
        //2.取List中数组的第二个元素加1秒存入数组的第一位，第二个元素如果年月日和结束时间年月日相等，则取结束时间
        try {
            Date endDateFormat = getEndTime(endDate);
            //计算相差的天数
            int betweenDays = daysBetween(startDate, endDate);
            List<Date []> list = new ArrayList<>(betweenDays);
            Date endTime = null;
            for (int i = 0; i <= betweenDays; i++) {
                Date startTime;
                if (i == 0) {
                    startTime = new Date(startDate.getTime());
                } else {
                    startTime = new Date(endTime.getTime() + 1000L);
                }
                endTime = getEndTime(startTime);
                if (endTime.equals(endDateFormat)) {
                    endTime = endDate;
                }
                list.add(new Date[]{startTime, endTime});
            }
            return list;
        } catch (ParseException e) {
            log.error("计算时间间隔日期发生异常",e);
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = sdf.parse("2012-09-08 10:10:10");
            Date d2 = sdf.parse("2012-09-10 01:00:00");
            List<Date[]> dates = calculationIntervalDate(d1, d2);
            for (Date[] date : dates) {
                System.out.println("[" + dateToStringForTemplate(date[0], FORMAT_TEMPLATE) + "," + dateToStringForTemplate(date[1], FORMAT_TEMPLATE) + "]");
            }
//            System.out.println(JSONObject.toJSONString(calculationIntervalDate(d1,d2)));
//            System.out.println(daysBetween(d1, d2));
//            System.out.println(daysBetween("2012-09-08 10:10:10", "2012-09-15 00:00:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println(dateToStringForTemplate(getSpecifiedDayAfter(new Date()), FORMAT_TEMPLATE));
//        System.out.println(getStartTime(new Date()));
//        System.out.println(dateFormatConversion("20201229204955",STR_DATEFORMAT,FORMAT_TEMPLATE));;
    }
}
