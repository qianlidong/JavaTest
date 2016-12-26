package com.qian.test;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qian.model.CorpInfo;
import com.qian.model.MyUser;
import com.qian.service.MyProjectAdminHandler;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestCache {

	@Autowired
	MyProjectAdminHandler myProjectAdminHandler;
	
	
    //User列表缓存
    @Resource(name = "userCacheManager")
    private Cache userListCache;
    
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCache() throws Exception{
		
		
		
		  List<CorpInfo> userList = null;
	        Element element = (Element) userListCache.get("userList");
	        if(element == null){
	        	userList  = myProjectAdminHandler.getCorp("0000000642");
	            Element newElement = new Element("userList", (Serializable) userList);
	            userListCache.put(newElement);
	        }else{
	            userList = (List<CorpInfo>)element.getValue();
	           System.err.println("读的是缓中的");
	        }
		System.out.println("看看大小吧:"+userList.size());
		//输出是有环境才行的
		
	}

//	@SuppressWarnings("unchecked")
//	@Test
//	public void testCache1() throws Exception{
//		
//		  List<MyUser> userList = null;
//	        Element element = (Element) userListCache.get("userList");
//	        if(element == null){
//	        	userList  = myProjectAdminHandler.getUser("1");
//	            Element newElement = new Element("userList", (Serializable) userList);
//	            userListCache.put(newElement);
//	        }else{
//	            userList = (List<MyUser>)element.getValue();
//	           System.err.println("读的是缓中的2");
//	        }
//		System.out.println("看看大小吧2:"+userList.size());
//		
//		
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void testCache3() throws Exception{
//		
//		  List<MyUser> userList = null;
//	        Element element = (Element) userListCache.get("userList2");
//	        if(element == null){
//	        	userList  = myProjectAdminHandler.getUser("3");
//	            Element newElement = new Element("userList2", (Serializable) userList);
//	            userListCache.put(newElement);
//	        }else{
//	            userList = (List<MyUser>)element.getValue();
//	           System.err.println("读的是缓中的3");
//	        }
//		System.out.println("看看大小吧3:"+userList.size());
//		
//		
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void testCache4() throws Exception{
//		
//		  List<MyUser> userList = null;
//	        Element element = (Element) userListCache.get("userList2");
//	        if(element == null){
//	        	userList  = myProjectAdminHandler.getUser("3");
//	            Element newElement = new Element("userList2", (Serializable) userList);
//	            userListCache.put(newElement);
//	        }else{
//	            userList = (List<MyUser>)element.getValue();
//	           System.err.println("读的是缓中的4");
//	        }
//		System.out.println("看看大小吧4:"+userList.size());
//		
//		
//	}
	
	
}
