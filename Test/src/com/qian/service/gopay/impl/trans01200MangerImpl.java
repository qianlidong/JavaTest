package com.qian.service.gopay.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qian.dao.MyPrjProjectDao;
import com.qian.model.MyUser;
import com.qian.service.gopay.trans01200Manager;

@Service(value="trans01200Manger")
public class trans01200MangerImpl implements trans01200Manager {

	@Autowired
	private MyPrjProjectDao myPrjProjectDao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { Exception.class })
	public void insertinto() {
		System.out.println("进入manager里面了");

		myPrjProjectDao.savePerson(new MyUser());
		System.out.println("manager结束了");
		String	str=null;
		   str.indexOf(1);
	}

}
