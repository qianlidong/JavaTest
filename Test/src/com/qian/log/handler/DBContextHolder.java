package com.qian.log.handler;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class DBContextHolder {

	 public static final String DATA_SOURCE_FROM = "dataSource";  
	    public static final String DATA_SOURCE_TO = "mysqlDataSource";  
	      
	    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
	    private static final ThreadLocal<Map<String,DataSource>> transactionMap = new ThreadLocal<Map<String,DataSource>>();    
	    public static void setDBType(String dbType) {  
	        contextHolder.set(dbType);  
	    }  
	      
	    public static String getDBType() {  
	        return contextHolder.get();  
	    }  
	      
	    public static void clearDBType() {  
	        contextHolder.remove();  
	    } 
	
	    
	    /**
		  * 回收资源 
		  */
		 public static void releaseAllTransaction(){
			 Map<String,DataSource> dbMap=transactionMap.get();
			 if(dbMap!=null && dbMap.size()>0){
				Set<String> dbKeys=dbMap.keySet();
			 for (String dbkey : dbKeys) {
				 try {
					 DataSource ds=dbMap.get(dbkey);
					 DataSourceUtils.getConnection(ds).setAutoCommit(true);
					DataSourceUtils.releaseConnection(DataSourceUtils.getConnection(ds), ds);//回收资源 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//dbMap.remove(dbkey);
			}
			 transactionMap.remove();
			 clearDbType();
			 }
			  
		 }
		 
		 public static void clearDbType() {  
			  contextHolder.remove();  
			 } 
		 
		 /**
		  * 提交所有 事物 
		  */
		 public static void commitAllTransaction(){
			 
			 Map<String,DataSource> dbMap=transactionMap.get();
			 if(dbMap!=null && dbMap.size()>0){
				Set<String> dbKeys=dbMap.keySet();
			 for (String dbkey : dbKeys) {
				 try {
					 DataSource ds=dbMap.get(dbkey);
					 DataSourceUtils.getConnection(ds).commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//dbMap.remove(dbkey);
			}
			 }
		 }
		 
		 /**
		  * 回滚所有事物 
		  */
		 public static void rollbackAllTransaction(){
			 Map<String,DataSource> dbMap=transactionMap.get();
			 if(dbMap!=null && dbMap.size()>0){
				Set<String> dbKeys=dbMap.keySet();
			 for (String dbkey : dbKeys) {
				 try {
					 DataSource ds=dbMap.get(dbkey);
					 DataSourceUtils.getConnection(ds).rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 }
		 }
}
