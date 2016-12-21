package com.lxy.app.service.test.impl;

import com.lxy.app.dao.test.HelloDao;
import com.lxy.app.dao.test.impl.HelloDaoImpl;
import com.lxy.app.domain.test.SayHello;
import com.lxy.app.service.test.HelloService;

public class HelloServiceImpl implements HelloService {

	private HelloDao helloDao = new HelloDaoImpl();

	public SayHello getSayHello() {
		return helloDao.getSayHello();
	}

}
