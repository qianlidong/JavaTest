package com.qian.service;




import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qian.dao.MyPrjProjectDao;
import com.qian.util.DateUtil;


    @Service
	public class MyProjectUserHandlerImpl implements MyProjectUserHandler,InitializingBean {
		
		public MyProjectUserHandlerImpl(){
			System.out.println("看看谁先被调用吧");
		}
		
	@Autowired
	private MyPrjProjectDao myPrjProjectDao;
	
	//来接list形式的，看看效果
	private String[] definitions;

	public String[] getDefinitions() {
		return definitions;
	}
	public void setDefinitions(String[] definitions) {
		this.definitions = definitions;
	}

	private String configLocation;
	
	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}
	
	
	private DateUtil dateUtil;
	
	public DateUtil getDateUtil() {
		return dateUtil;
	}
	public void setDateUtil(DateUtil dateUtil) {
		this.dateUtil = dateUtil;
	}
	@Override
	public int addUser() {
		// TODO Auto-generated method stub
		return myPrjProjectDao.isRight();
	}
	@Override
	public void getDef() {
		//dateUtil.dateFor();
		for (String str : definitions) {
			System.out.println("+++++++++++++++++++:"+str);
		}
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("必须在改bean初始化时就调用的");
		
	}
	
	
	
	}


