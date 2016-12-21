package com.qian.service;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;

public class UserActiveManager extends TransactionSynchronizationAdapter{

	@Override
	public void afterCompletion(int status) {
		// TODO Auto-generated method stub
		super.afterCompletion(status);
	}

	@Override
	public void beforeCompletion() {
		// TODO Auto-generated method stub
		super.beforeCompletion();
	}
	
	
	

}
