package com.zhang.myjava.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	// 获得某月的开始日期
    public static String getMonthBeginDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyyMM").parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }
 
    // 获得某月的结束日期
    public static String getMonthEndDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyyMM").parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }
    
    // 获得某月的之前的月份
    public static String getPreviousMonth(String date, int before) throws ParseException {
    		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(date));
        calendar.add(Calendar.MONTH, -1*before);
        Date time = calendar.getTime();
        String month = format.format(time);
        return month;
    }
    
    /** 
     * 字符串日期格式的计算 
     * @param smdate 
     * @param bdate 
     * @return 
     * @throws ParseException 
     */  
    public static int daysBetween(String smdate,String bdate) throws ParseException{    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");    
        Calendar cal = Calendar.getInstance();      
        cal.setTime(sdf.parse(smdate));      
        long time1 = cal.getTimeInMillis();                   
        cal.setTime(sdf.parse(bdate));      
        long time2 = cal.getTimeInMillis();           
        long between_days=(time2-time1)/(1000*3600*24) + 1;    
        return Integer.parseInt(String.valueOf(between_days));       
    }    
    
    public static void main(String[] args) throws ParseException {
    		String date1 = DateUtil.getPreviousMonth("201801", 2);
    		String begin = DateUtil.getMonthBeginDate(date1);
    		
    		String date2 = DateUtil.getPreviousMonth("201801", 1);
    		String end = DateUtil.getMonthEndDate(date2);   		
    		int days = daysBetween("20171101", "20171130");
    		
    		System.out.println(begin);
    		System.out.println(end);
    		System.out.println(days);
    }
}
