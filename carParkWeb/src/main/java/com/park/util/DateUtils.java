/**  

* @Title: DateUtil.java  

* @Package com.carsystem.util  

* @Description: TODO(用一句话描述该文件做什么)  

* @author Administrator  

* @date 2020年2月3日   

*/  
package com.park.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String dateToString(){
		Date date = new Date(); //获取当前时间
        System.out.println(date.getClass().getName());  //打印date数据类型
        System.out.println(date);           //打印当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        return sdf.format(date);       //将Date类型转换成String类型    
	}


	public static long getDayTime(String time1,String time2){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date d1 = df.parse(time1);
            Date d2 = df.parse(time2);
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是毫秒级别
            long days = diff / (1000 * 60 * 60 * 24);

            //long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            //long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
            //System.out.println(""+diff+"天"+hours+"小时"+minutes+"分");
            return days;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}