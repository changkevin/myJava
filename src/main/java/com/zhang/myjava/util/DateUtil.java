package com.zhang.myjava.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtil {
	private static final String YEAR_MONTH_PATTERN = "yyyyMM";
	private static final String DATE_KEY_PATTERN = "yyyyMMdd";
	
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
    
    /**
     * 获得某月的之前或之后某几个月的月份
     * @param date 月份，格式为yyyyMM
     * @param diff  相差的月份
     * @return 月份，格式为yyyyMM
     * @throws ParseException
     */
    public static String getMonth(String date, int diff) throws ParseException {
    		SimpleDateFormat format = new SimpleDateFormat(YEAR_MONTH_PATTERN);
        Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(date));
        calendar.add(Calendar.MONTH, diff);
        Date time = calendar.getTime();
        String month = format.format(time);
        return month;
    }
    
    public static String getDiffday(int diff) {
	 	Date date=new Date();//取时间
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(date);
	    calendar.add(Calendar.DATE, diff);
	    date=calendar.getTime(); 
	    SimpleDateFormat formatter = new SimpleDateFormat(DATE_KEY_PATTERN);
	    String dateString = formatter.format(date);
	    
	    return dateString;
}
    
    
    
    public static void main(String[] args) throws ParseException {
//    		String date1 = DateUtil.getPreviousMonth("201801", 2);
//    		String begin = DateUtil.getMonthBeginDate(date1);
//    		
//    		String date2 = DateUtil.getPreviousMonth("201801", 1);
//    		String end = DateUtil.getMonthEndDate(date2);   		
//    		int days = daysBetween("20171101", "20171130");
//    		
//    		System.out.println(begin);
//    		System.out.println(end);
//    		System.out.println(days);
    		
    		String month = "201803";
    		month = month.replace("/", "");
    		month = month.replace("-", "");
    		month = month.replace(".", "");
    		String startDate = DateUtil.getMonthBeginDate(DateUtil.getMonth(month, -2));
    		String endDate = DateUtil.getMonthEndDate(DateUtil.getMonth(month, -1));	
    		
    		System.out.println(startDate);
    		System.out.println(endDate);
    		
    		Date d = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    		String today = sdf.format(d);
    		System.out.println("当前时间：" + sdf.format(d));
    		
    		if(today.compareTo("20180101") <=0) {
    			System.out.println("不足两月");
    		}
    		
    		System.out.println(getDiffday(-1));
    		
    }
}
