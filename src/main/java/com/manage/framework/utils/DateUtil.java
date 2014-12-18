package com.manage.framework.utils;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * 日期工具类
 * 
 */
public class DateUtil {
	/**
	 * 获取当前时间，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String nowTime(){
		String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		return nowTime;
	}
	/**
	 * 获取当前日期，格式：yyyy-MM-dd
	 * @return
	 */
	public static String getDate(){
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		return date;
	}
	
	/**
	 * 此方法现在未使用
	 * @return
	 */
	public static String dateForJavaScript(){
		String nowTime=new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss").format(Calendar.getInstance().getTime());
		return nowTime;
	}
	
	public static Calendar setStartDay(Calendar cal)
    {
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        return cal;
    }

    public static Calendar setEndDay(Calendar cal)
    {
        cal.set(11, 23);
        cal.set(12, 59);
        cal.set(13, 59);
        return cal;
    }

    public static void copyYearMonthDay(Calendar destCal, Calendar sourceCal)
    {
        destCal.set(1, sourceCal.get(1));
        destCal.set(2, sourceCal.get(2));
        destCal.set(5, sourceCal.get(5));
    }

    public static String formatEnDate(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        return sdf.format(date).replaceAll("\u4E0A\u5348", "AM").replaceAll("\u4E0B\u5348", "PM");
    }

    public static Date parseDate(String dateString)
    {
        Date date = null;
        try
        {
            date = DateUtils.parseDate(dateString, new String[] {
                "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"
            });
        }
        catch(Exception ex)
        {
            
        }
        return date;
    } 
    
    public static int getTheMonth() {
    	Calendar c = Calendar.getInstance();
		 int month = c.get(Calendar.MONTH);//获取是本月的第几周
		 return (month+1);
    }
    
    /*
     * 本月第几周
     */
    public static int getTheWeek() {
    	Calendar c = Calendar.getInstance();
		 int week = c.get(Calendar.WEEK_OF_MONTH);//获取是本月的第几周
		 return week;
    }
    
    /*
     * 某天为当月第几周
     */
    public static int getWeek(Date date) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
		 int week = c.get(Calendar.WEEK_OF_MONTH);//获取是本月的第几周
		 return week;
    }
    
    /*
     *  某天为周几
     */
    public static int getDayInWeek(Date date) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
		  int day = c.get(Calendar.DAY_OF_WEEK);//获致是本周的第几天地, 1代表星期天...7代表星期六
		  return (day-1);
    }
    
    /*
     * 本周周几
     */
    public static int getTheDayInWeek() {
    	Calendar c = Calendar.getInstance();
		  int day = c.get(Calendar.DAY_OF_WEEK);//获致是本周的第几天地, 1代表星期天...7代表星期六
		  return (day-1);
    }
    
}
