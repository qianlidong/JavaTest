package com.qian.service.gopay.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qian.dao.MyPrjProjectDao;
import com.qian.service.gopay.trans01200Manager;


@Service
public class trans01200ServiceImpl implements
		com.qian.service.gopay.trans01200Service {

	@Autowired
	trans01200Manager trans01200Manager;
	
	@Autowired
	private MyPrjProjectDao myPrjProjectDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insert() {
		
		System.out.println("开始试验....");
		
		myPrjProjectDao.isRight();
		trans01200Manager.insertinto();
		
		
		
	   
		
	}

}
