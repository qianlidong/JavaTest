package com.qian.quartzJob;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OneJob {
	
	
	public final void doJob() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal=Calendar.getInstance();
		System.out.println("时间:"+sdf.format(cal.getTime())+"线程的名称:"+Thread.currentThread().getName());
		try {
			Thread.sleep(70000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("结束了第一个");
	}

}
