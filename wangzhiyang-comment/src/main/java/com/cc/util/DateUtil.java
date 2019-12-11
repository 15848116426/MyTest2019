package com.cc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author:王校长
 * 2019年12月11日
 * :封装一个工具类DateUtil
 */
public class DateUtil {

//	方法1：根据传入的日期获取年龄

	public static int getAge (Date date) {
		
		Calendar bir = Calendar.getInstance();
		bir.setTime(date);
		Calendar now = Calendar.getInstance();
		if(date == null || bir.after(now)){
			throw new IllegalArgumentException("日期参数异常");
		}
		int age = now.get(Calendar.YEAR) - bir.get(Calendar.YEAR);
		if(bir.get(Calendar.MONTH) <= now.get(Calendar.MONTH)){
			if(bir.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH) && bir.get(Calendar.MONTH) == now.get(Calendar.MONTH)){
				age--;
			}
		}else{
			age--;
		}
		
		return age;
	}
	
//	方法2：根据传入的参数获取该日期的月初日期，
//	例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-01 00:00:00”

	public static String getDateByMonthInit (Date date){
		
		if(date == null){
			throw new IllegalArgumentException("日期参数异常");
		}
		Calendar instance = Calendar.getInstance();
		try {
			instance.setTime(date);
		} catch (Exception e) {
			System.out.println("日期参数异常");
		}
		instance.set(Calendar.DAY_OF_MONTH, 01);
		instance.set(Calendar.HOUR_OF_DAY, 00);
		instance.set(Calendar.MINUTE, 00);
		instance.set(Calendar.SECOND, 00);
		
		Date time = instance.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		
		return sdf.format(time);
	}
	
//	根据传入的参数获取该日器的月末日期，
//	例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-30 23:59:59”，
//	注意月大月小以及闰年。
	public static Date getDateByMonthLast(Date date) {
		if(date == null){
			throw new IllegalArgumentException("日期参数异常");
		}
		Calendar instance = Calendar.getInstance();
		try {
			instance.setTime(date);
		} catch (Exception e) {
			System.out.println("日期参数异常");
		}
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH) + 1;
		switch (month) {
		case 1:;
		case 3:;
		case 5:;
		case 7:;
		case 8:;
		case 10:;
		case 12:
			instance.set(Calendar.DAY_OF_MONTH, 31);
			break;
		case 2:
			if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
				instance.set(Calendar.DAY_OF_MONTH, 29);
			}else{
				instance.set(Calendar.DAY_OF_MONTH, 28);
			}
			break;
		default:
			instance.set(Calendar.DAY_OF_MONTH, 30);
			break;
		}
		instance.set(Calendar.HOUR_OF_DAY, 23);
		instance.set(Calendar.MINUTE, 59);
		instance.set(Calendar.SECOND, 59);
		
		return instance.getTime();
	}
	
//	方法4：求未来日期离今天还剩的天数
	public static int getDaysByFuture (Date future) {
		
		if(future == null || future.before(new Date())){
			throw new IllegalArgumentException("日期参数异常");
		}
		
		long thisTime = new Date().getTime();
		long futureTime = future.getTime(); 
		
		return (int)((futureTime - thisTime) / 1000 / 60 / 60 / 24) + 1;
	}
	
//	方法5：求过去日期离今天过去的天数
	public static int getDaysByDeparted (Date departed) {
		if(departed == null || departed.after(new Date())){
			throw new IllegalArgumentException("日期参数异常");
		}
		
		long thisTime = new Date().getTime();
		long departedTime = departed.getTime(); 
		
		return (int)((thisTime - departedTime) / 1000 / 60 / 60 / 24);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
