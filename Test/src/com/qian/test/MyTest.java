package com.qian.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.test.AssertThrows;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import com.qian.log.handler.DBContextHolder;
import com.qian.model.CorpInfo;
import com.qian.model.MyUser;
import com.qian.other.MyThread;
import com.qian.service.MyProjectAdminHandler;
import com.qian.service.MyProjectUserHandler;
/**
 * 
 * @author qld
 *hessian的客户端吧
 */
import com.qian.service.PersonService;
import com.qian.service.gopay.trans01200Service;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class MyTest  {



	@Autowired
	MyProjectAdminHandler myProjectAdminHandler;
	
    
    @Autowired
  	MyProjectUserHandler myProjectUserHandler;

    @Autowired
  	trans01200Service trans01200Service;
    
	@Test
	public void test() throws Exception {
		
		//trans01200Service.insert();
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmdd hhmmss");
//		System.out.println("现在时间:"+sdf.format(new Date()));
		myProjectAdminHandler.ccUsers();
		// System.out.println(sdf.format(new Date(str)));
		//myProjectUserHandler.getDef();
		//MyThread t=new MyThread();
		//t.run();
//		InputStream in=null;
//		try {
//			Properties pt=new Properties();
//			File file=new File("src/mongodb.properties");
//			
//			in=new FileInputStream(file);
//			pt.load(in);
//	String prdName=pt.getProperty("mongo.prd.dbName");
//	System.out.println(prdName);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//		in.close();
//		}
//		String filePath="D:\\apache-tomcat-7.0.6\\webapps\\portal\\upload\\cert\\2015054\\0000001793";
//	    File f = new File(filePath);
//        if (!f.exists()) {
//            f.mkdirs();
//        }
		
	
		
		
				
		//myProjectAdminHandler.ccUsers();
		
     	//myProjectUserHandler.addUser();
		
//		 File file = new File("d://temp");
//		 boolean flag=file.exists();
//		 if(!flag){
//			 file.mkdir();
//			 
//		 }
//		 System.out.println(flag);
//		FileInputStream inputStream = new FileInputStream(file);  
//		
		
}



	
}
