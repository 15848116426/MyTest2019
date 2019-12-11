package com.cc.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.cc.util.DateUtil;

/**
 * @author:王校长
 * 2019年12月11日
 * 编写对应的Junit测试类进行测试
 */
public class MyTest {

	@Test
	public void testDateUtil() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2018-12-11");
//		根据传入的日期获取年龄
//		System.out.println(DateUtil.getAge(date));
		
//		根据传入的参数获取该日期的月初日期
//		System.out.println(DateUtil.getDateByMonthInit(date));
		
//		根据传入的参数获取该日器的月末日期
//		System.out.println(DateUtil.getDateByMonthLast(date));
		
//		求未来日期离今天还剩的天数
//		System.out.println(DateUtil.getDaysByFuture(date));
		
//		求过去日期离今天过去的天数
//		System.out.println(DateUtil.getDaysByDeparted(date));
	}
}
