package com.qian.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.qian.model.CorpInfo;
import com.qian.model.MyUser;


@Service
public class MyPrjProjectDaoImpl  extends SqlMapClientDaoSupport implements MyPrjProjectDao{

	
	
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public MyPrjProjectDaoImpl(){
     sqlMapClientTemplate=this.getSqlMapClientTemplate();
	}
	
	
	
	
	@Override
	public int isRight() {
		Map map=new HashMap();
		map.put("id", 2008);
		map.put("name", "北京奥运");
		map.put("sex", "3");
		
		sqlMapClientTemplate.insert("Project.insertUser", map);
		
		int a=0;
	return a;	
	}




	@Override
	public void savePerson(MyUser person) {
		
		Map map=new HashMap();
		map.put("name", "北京北京");
		map.put("sex", "1");
		
		sqlMapClientTemplate.insert("Project.saveUser", map);
	}




	@Override
	public List<MyUser> getUser(String sex) {
		Map map=new HashMap();
		
		map.put("sex", sex);
		return (List<MyUser>) sqlMapClientTemplate.queryForList("Project.getUser", map);
	}




	@Override
	public List<CorpInfo> getCorp(String custId) {
    Map map=new HashMap();
		
		map.put("custId", custId);
		return (List<CorpInfo>) sqlMapClientTemplate.queryForList("Project.getCorp", map);
	}

	
	
}
