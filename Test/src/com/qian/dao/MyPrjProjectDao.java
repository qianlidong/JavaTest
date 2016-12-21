package com.qian.dao;

import java.util.List;

import com.qian.model.CorpInfo;
import com.qian.model.MyUser;

public interface MyPrjProjectDao {

	public int isRight();
	
	public void savePerson(MyUser person);
	
	public List<MyUser> getUser(String sex);
	
	public List<CorpInfo> getCorp(String custId);
	
}
