package com.qian.quartzJob;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TwoJob {

	public final void doJob() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal=Calendar.getInstance();
		
		System.out.println("时间2:"+sdf.format(cal.getTime())+"线程的名称2:"+Thread.currentThread().getName());
		
	}
	
}
