package com.qian.test;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.qian.user.User;

public class MongoDbTest {
	
	 private static Mongo m = null;  
	    private static DB db = null;  
	
	    //数据集合名称  
	    private static final String COLLECTION_NAME = "loginlogs";  
	  
	    /* 
	     * 测试java处理mongodb的增、删、改、查操作 
	     */  
	    public static void main(String[] args) throws Exception{  
	    	  String dateTime="2015-06-01 101010";  
		       	
		       Calendar c = Calendar.getInstance();  
		        
		    c.setTime(new SimpleDateFormat("yyyy-MM-dd HHmmss").parse(dateTime));  
		      
		    System.out.println("时间转化后的毫秒数为："+c.getTimeInMillis()); 
	        //获取数据库连接  
	        startMongoDBConn();  
	        //保存数据  
	      createColData(c.getTimeInMillis());  
	        //读取数据  
	       // readColData();  
	        //更新数据  
	      // updateColData();  
	        //读取数据  
	      // readColData();  
	        //删除数据  
	      // deleteColData();  
	        //读取数据  
	      //  readColData();  
	        //删除数据集  
	       // db.getCollection(COLLECTION_NAME).drop();  
	        //关闭数据库连接  
	        //stopMondoDBConn();  
	     
	         SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      // System.out.println(sf.format(new Date().getTime()));   
	    }  
	      
	    /** 
	     * 数据插入 
	     * *测试数据： 
	     * 【name:小李、age:30、address:江苏南京】 
	     * 【name:小张、age:25、address:江苏苏州】 
	     * @return  
	     */  
	    private static void createColData(long time){  
	        DBCollection dbCol = db.getCollection(COLLECTION_NAME); 
	        System.out.println("向数据集中插入数据开始：");  
	        List<DBObject> dbList = new ArrayList<DBObject>();  
	        BasicDBObject doc1 = new BasicDBObject(); 
	        doc1.put("custId", "0000001028");
	        doc1.put("username", "张三公司");  
	        doc1.put("merName", "张三公司"); 
	        doc1.put("loginTime", time);
	        doc1.put("ip", "10.10.6.50");
	        doc1.put("eorm", "qianlidong@163.com");
	        doc1.put("oprId", "001");
	        doc1.put("userType", "20");
	        dbList.add(doc1);  
	          
//	        BasicDBObject doc2 = new BasicDBObject();  
//	        doc2.put("name", "小张");  
//	        doc2.put("age", 25);  
//	        doc2.put("address", "江苏苏州");  
//	        dbList.add(doc2);  
	          
	        dbCol.insert(dbList);  
	        System.out.println("向数据集中插入数据完成！");  
	        System.out.println("------------------------------");
//	        String str=null;
//	        str.indexOf(1);
	    }  
	      
	    /** 
	     * 数据读取 
	     */  
	    private static void readColData() throws Exception{  
	    	String startTime="2015-05-01 000000";
	    	String endTime="2015-05-08 235959";
	    	 SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	 Calendar cs = Calendar.getInstance();  
		        
	 	    cs.setTime(new SimpleDateFormat("yyyy-MM-dd HHmmss").parse(startTime));
	 	   Calendar cd = Calendar.getInstance();  
	        
	 	    cd.setTime(new SimpleDateFormat("yyyy-MM-dd HHmmss").parse(endTime));
	    	User u=new User(1, "","");
	    	List<User> list=new ArrayList<User>();
	        DBCollection dbCol = db.getCollection(COLLECTION_NAME);
	        BasicDBList condList = new BasicDBList();
	        BasicDBObject searchCond = new BasicDBObject();
	        String ip="";
	        String merName="qq";
	        String eorm="";
	        BasicDBObject cond =  new BasicDBObject();
	        BasicDBObject cond1 =  new BasicDBObject();
	        if(!("").equals(ip)){
	        	cond.append("ip",ip);
	        }
	        if(!"".equals(merName)){
	        	cond.append("eorm", getLikeStr(merName));
	        }
	        if(!("").equals(eorm)){
	        	cond.append("eorm",eorm);
	        }
	        //时间的选项
	       // cond.append("loginTime",new BasicDBObject("$gt",cs.getTimeInMillis()));
	       // cond1.append("loginTime",new BasicDBObject("$lte",cd.getTimeInMillis()));
	        condList.add(cond);
	        //condList.add(cond1);
	        searchCond.put("$and", condList);
	        DBCursor ret = dbCol.find(new BasicDBObject(searchCond)).sort(new BasicDBObject("loginTime", -1));
	       
	        System.out.println("从数据集中读取数据：");
	        while(ret.hasNext()){  
	            BasicDBObject bdbObj = (BasicDBObject) ret.next();  
	            if(bdbObj != null){  
	            	String time=bdbObj.getString("loginTime");
	            	long l = Long.parseLong(time);
	            	Date date = new Date(l); // long类型转成Date类型
	               // System.out.println("name:"+bdbObj.getString("eorm"));  
	               // System.out.println(sf.format(date));
	                System.out.println("name:"+bdbObj.getString("eorm")); 
	               // u.setUserName(bdbObj.getString("name"));	
	                
	               // System.out.println("eorm:"+bdbObj.getString("eorm"));
	               // System.out.println("userType:"+bdbObj.getString("userType")); 
	               // list.add(u);
	            }  
	        }  
	    }  
	      
	    private static BasicDBObject getLikeStr(String findStr) {
	        Pattern pattern = Pattern.compile("^.*" + findStr + ".*$", Pattern.CASE_INSENSITIVE);
	     return new BasicDBObject("$regex", pattern);
	    }
	    /** 
	     * 数据更新 
	     * update(q, o, upsert, multi) 
	     * update(q, o, upsert, multi, concern) 
	     * update(arg0, arg1, arg2, arg3, arg4, arg5) 
	     * updateMulti(q, o) 
	     */  
	    private static void updateColData(){  
	        System.out.println("------------------------------");  
	        DBCollection dbCol = db.getCollection(COLLECTION_NAME);  
	        DBCursor ret = dbCol.find();  
	        BasicDBObject doc = new BasicDBObject();  
	        BasicDBObject res = new BasicDBObject();  
	        res.put("loginTime", "0000001557");  
	       // System.out.println("将数据集中的所有文档的age修改成40！");  
	        doc.put("$set", res);  
	        dbCol.update(new BasicDBObject("merName","王刚商户测试公司"),doc,false,true);  
	        System.out.println("更新数据完成！");  
	        System.out.println("------------------------------");  
	    }  
	      
	    /** 
	     * 数据删除 
	     */  
	    private static void deleteColData(){  
	        System.out.println("------------------------------");  
	        DBCollection dbCol = db.getCollection(COLLECTION_NAME);  
	        System.out.println("删除【小李】！");  
	        BasicDBObject doc = new BasicDBObject();  
	        doc.put("loginTime", "1428183790730");  
	        dbCol.remove(doc);  
	        System.out.println("------------------------------");  
	    }  
	      
	    /** 
	     * 关闭mongodb数据库连接 
	     */  
	    private static void stopMondoDBConn(){  
	        if (null != m) {  
	            if (null != db) {  
	                // 结束Mongo数据库的事务请求  
	                try {  
	                    db.requestDone();  
	                } catch(Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            try  
	            {  
	                m.close();  
	            } catch(Exception e) {  
	                e.printStackTrace();  
	            }  
	            m = null;  
	            db = null;  
	        }  
	    }  
	      
	    /** 
	     * 获取mongodb数据库连接 
	     */  
	    private static void startMongoDBConn(){  
	        try {  
	            //Mongo(p1, p2):p1=>IP地址     p2=>端口  
	            m = new Mongo("211.88.2.246", 11811);  
	            //根据mongodb数据库的名称获取mongodb对象  
	            db = m.getDB("logstest");  
	            //校验用户密码是否正确  
	        
	        } catch (UnknownHostException e) {  
	            e.printStackTrace();  
	        } catch (MongoException e) {  
	            e.printStackTrace();  
	        }  
	    }  


	    
	  	// date类型转换为String类型
	 	// formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
	 	// data Date类型的时间
	 	public static String dateToString(Date data, String formatType) {
	 		return new SimpleDateFormat(formatType).format(data);
	 	}
	 
	 	// long类型转换为String类型
	 	// currentTime要转换的long类型的时间
	 	// formatType要转换的string类型的时间格式
	 	public static String longToString(long currentTime, String formatType)
	 			throws ParseException {
	 		Date date = longToDate(currentTime, formatType); // long类型转成Date类型
	 		String strTime = dateToString(date, formatType); // date类型转成String
	 		return strTime;
	 	}
	 
	 	// string类型转换为date类型
	 	// strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
	 	// HH时mm分ss秒，
	 	// strTime的时间格式必须要与formatType的时间格式相同
	 	public static Date stringToDate(String strTime, String formatType)
	 			throws ParseException {
	 		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
	 		Date date = null;
	 		date = formatter.parse(strTime);
	 		return date;
	 	}
	 
	 	// long转换为Date类型
	 	// currentTime要转换的long类型的时间
	 	// formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
	 	public static Date longToDate(long currentTime, String formatType)
	 			throws ParseException {
	 		Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
	 		String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
	 		Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
	 		return date;
	 	}
	 
	 	// string类型转换为long类型
	 	// strTime要转换的String类型的时间
	 	// formatType时间格式
	 	// strTime的时间格式和formatType的时间格式必须相同
	 	public static long stringToLong(String strTime, String formatType)
	 			throws ParseException {
	 		Date date = stringToDate(strTime, formatType); // String类型转成date类型
	 		if (date == null) {
	 			return 0;
	 		} else {
	 			long currentTime = dateToLong(date); // date类型转成long类型
	 			return currentTime;
	 		}
	 	}
	 
	 	// date类型转换为long类型
	 	// date要转换的date类型的时间
	 	public static long dateToLong(Date date) {
	 		return date.getTime();
	 	}
	    
}
