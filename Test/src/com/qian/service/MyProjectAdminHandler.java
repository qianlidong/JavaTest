package com.qian.service;

import java.util.HashMap;
import java.util.List;

import com.qian.model.CorpInfo;
import com.qian.model.MyUser;


public interface MyProjectAdminHandler {

	public int ccUsers();
	
	public List<MyUser> getUser(String sex);
	
	public List<CorpInfo> getCorp(String custId);
}
