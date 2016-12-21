package com.qian.hessian.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qian.hessian.HessianService;
import com.qian.service.MyProjectAdminHandler;
import com.qian.user.User;


@Service(value = "hessianService")
public class HessianServiceImpl implements HessianService {

	
	@Autowired
	MyProjectAdminHandler myProjectAdminHandler;
	
	
	@Override
	public void sayNimei() {
		
		System.err.println("你妹的，原来这么简单");
		
		myProjectAdminHandler.ccUsers();
		String str=null;
	   // int t=str.indexOf(1);
		

	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		//我们可以在这个方法中与数据库打交道

		List<User> list=new ArrayList<User>();
	
		list.add(new User(1,"Mary","123456"));
		
		list.add(new User(2,"Jack","236547"));
	
		list.add(new User(3,"Joy","362541"));
	
		return list;
	}

}
