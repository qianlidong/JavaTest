package com.qian.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.qian.service.MyProjectAdminHandler;

public class MyProjectAdminController {

	
	
	
	@RequestMapping(value= "/login.do")
    public ModelAndView login(){
        return new ModelAndView("mytest");
    }

	
	@RequestMapping("/services")
	public String getMessage(){
		
		System.out.println("hhhh");
		
		return "yes";
	}
	
	
	MyProjectAdminHandler myProjectAdminHandler;
	
	public void setMyProjectAdminHandler(MyProjectAdminHandler myProjectAdminHandler) {
		this.myProjectAdminHandler = myProjectAdminHandler;
	}

	

	
	
	
}
