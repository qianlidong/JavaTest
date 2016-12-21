package com.qian.quartzJob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component(value="quazrt")
public class BatchSqlQuartz {
	
	
	 @Scheduled(cron = "0 02 17 * * ?") 
	 public void batchSql(){
		System.out.println("sql批处理开始...........");
		 
		 
		 
		 
		 
		 
		System.out.println("sql批处理结束...........");
		 
	 } 
}
