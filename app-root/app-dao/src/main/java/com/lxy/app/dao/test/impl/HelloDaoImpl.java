package com.lxy.app.dao.test.impl;

import com.lxy.app.dao.test.HelloDao;
import com.lxy.app.domain.test.SayHello;

public class HelloDaoImpl implements HelloDao {

	public SayHello getSayHello() {
		return new SayHello();
	}

}
