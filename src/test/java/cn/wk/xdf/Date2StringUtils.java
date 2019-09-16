package cn.wk.xdf;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class Date2StringUtils {

    private static String time_format_pattern = "yyyy-MM-dd HH:mm:ss";

    public static String getNowDateString() {
        return new SimpleDateFormat(time_format_pattern).format(new Date());
    }

    public static String getDateString(Date date) {
        return new SimpleDateFormat(time_format_pattern).format(date);
    }

    public static String getDatePaseString(Date date,String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String getStrDatePaseString(String date,String pattern){
        try{
            SimpleDateFormat sdf= new SimpleDateFormat(pattern);
            Date date1=sdf.parse(date);
            return  sdf.format(date1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String getStrDatePaseString(String date,String pattern1,String pattern2){
        try{
            SimpleDateFormat sdf= new SimpleDateFormat(pattern1);
            Date date1=sdf.parse(date);
            sdf= new SimpleDateFormat(pattern2);
            return  sdf.format(date1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static Date getDateByString(String date) {
        Date parse = null;
        try {
            parse = new SimpleDateFormat(time_format_pattern).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static Date getEndDate(Date date) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 指定年月得到上月26号到本月25号的日期数组,包括星期几
     * 例如: 2019-06-26:三
     * @return
     */
    public static List<Map<String, Object>> getNatrualMonth(String year, String month) {
        Calendar c = Calendar.getInstance();
        c.set(Integer.valueOf(year),Integer.valueOf(month) - 2, 26);
        Date startT = c.getTime();
        c.set(Integer.valueOf(year),Integer.valueOf(month) - 1, 25);
        Date endT = c.getTime();
        return getDateList(startT, endT);
    }

    public static List<Map<String, Object>> getDateList(Date startT, Date endT) {
        List<String> lDate = new ArrayList<>();
        List<Map<String,Object>> result = new ArrayList<>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> map = new HashMap<>();
        map.put("time",sd.format(startT));
        map.put("week",getWeek(startT));
        result.add(map);
        lDate.add(sd.format(startT)+":"+getWeek(startT));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(startT);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(endT);
        // 测试此日期是否在指定日期之后
        while (endT.after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            String week = getWeek(calBegin.getTime());
            Map<String, Object> m2 = new HashMap<>();
            m2.put("time",sd.format(calBegin.getTime()));
            m2.put("week",week);
            result.add(m2);
            lDate.add(sd.format(calBegin.getTime())+":"+week);
        }
        return result;
    }

    /**
     * 指定日期得到星期几
     * @param date
     * @return
     */
    public static String getWeek(Date date){
        String[] weeks = {"日","一","二","三","四","五","六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<0){
            week_index = 0;
        }
        return weeks[week_index];
    }


    /**
     * 获取一段时间内的分割天数list,每dayNum天一分割。
     * 7天为例：2017-01-01到2017-01-15可分割为[2017-01-01,2017-01-07]和[2017-01-08,2017-01-14]和[2017-01-15,2017-01-15]
     *
     * @param startDateStr
     * @param endDateStr
     * @param dayNum 分割天数,必须为正整数
     * @param pattern 时间字符串格式"yyyy-MM-dd" or "yyyyMMdd" or "yyyy/MM/dd"
     * @return
     * @throws ParseException
     * @author EX-LISHENG001
     */
    public static List<Map<String,String>> getDateMapList(String startDateStr, String endDateStr, int dayNum, String pattern) {
        try{
            if (dayNum < 1) {
                return null;
            }
            List<Map<String, String>> dateList = new ArrayList<>();
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            Date startDate = df.parse(startDateStr);
            Date endDate = df.parse(endDateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            while (true) {
                Map<String, String> dateMap = new HashMap<>();

                cal.add(Calendar.DATE, dayNum - 1);
                if (cal.getTime().getTime() < endDate.getTime()) {
                    dateMap.put("startDate", df.format(startDate));
                    dateMap.put("endDate", df.format(cal.getTime()));
                    dateList.add(dateMap);
                } else {
                    dateMap.put("startDate", df.format(startDate));
                    dateMap.put("endDate", df.format(endDate));
                    dateList.add(dateMap);
                    break;
                }
                cal.add(Calendar.DATE, 1);
                startDate = cal.getTime();
            }
            return dateList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     *
     * @param startDateStr
     * @param endDateStr
     * @param pattern
     * @return
     */
    public static Set<String> getDateDayList(String startDateStr, String endDateStr, String pattern) {
        try {
            Set<String> set = new HashSet<>();
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date date0 = sdf.parse(startDateStr);
            Date date1 = sdf.parse(endDateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date0);
            while (cal.getTime().compareTo(date1) <= 0) {
                cal.add(Calendar.DAY_OF_MONTH, 1);
                set.add(sdf.format(cal.getTime()));
            }
            return set;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *
     * @param startDateStr
     * @param endDateStr
     * @param pattern
     * @return
     */
    public static List<String> getDateDayMap(String startDateStr, String endDateStr, String pattern) {
        try {
            List<String> list = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date date0 = sdf.parse(startDateStr);
            Date date1 = sdf.parse(endDateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date0);
            while (cal.getTime().compareTo(date1) <= 0) {
                list.add(sdf.format(cal.getTime()));
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**

    * 比较两个时间查多少天

     * @param one

     * @param two

     * @return

     */

    public static Integer between(String one, String two, String pattern ) {

        try {
            SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
            Date d1= dateFormat.parse(one);
            Date d2= dateFormat.parse(two);
            int days = (int) ((d2.getTime()-d1.getTime()) / (1000*3600*24));
            return days<0?-1*days:days;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
      /* Integer s= Date2StringUtils.between("2019-02-01","2019-01-03","yyyy-MM-dd");
        System.out.println(s);*/
        SimpleDateFormat fmtrq = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar now = new GregorianCalendar();
        now.add(GregorianCalendar.MONTH, -6); //可以是天数或月数  数字自定 -6前6个月
        GregorianCalendar now1 = new GregorianCalendar();
        now1.add(GregorianCalendar.MONTH, 6);
        List<Map<String, String>> dateMapList = Date2StringUtils.getDateMapList(fmtrq.format(now.getTime()), fmtrq.format(now1.getTime()), 10, "yyyy-MM-dd");
        log.info("{}:返回结果:{}", "", JSON.toJSONString(dateMapList));

    }

    }



