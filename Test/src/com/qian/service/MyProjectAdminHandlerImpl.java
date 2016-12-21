package com.qian.service;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qian.dao.MyPrjProjectDao;
import com.qian.log.handler.DBContextHolder;
import com.qian.model.CorpInfo;
import com.qian.model.MyUser;



	public class MyProjectAdminHandlerImpl implements MyProjectAdminHandler {
		
		public MyProjectAdminHandlerImpl(){
			
		}
		private Map<String,String> qianMap=null;

		public Map<String,String> getQianMap() {
			return qianMap;
		}
		@Autowired
		public void setQianMap(Map<String,String> qianMap) {
			this.qianMap = qianMap;
		}
		
		
		 @Autowired
		    PersonService personService;	
		
	@Autowired
	private MyPrjProjectDao myPrjProjectDao;
	
	
	@Value("#{mongodbProperties['mongo.reserve.connectionIp']}")
	protected  String ip;
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 这里的cc开头的方法没有事务，add开头就有事务，有事务时回滚的是所有的数据源，刚好transactionManager是这样的
	 * <bean id="transactionManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dynamicDataSource" />
	</bean>
	动态数据源依赖的，所以可以回滚所有的
	 */
	
	public int ccUsers(){
		myPrjProjectDao.isRight();
		MyUser person=new MyUser();
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_TO);
		personService.save(person);
		System.out.println(qianMap.get("2002")+ip);

		return 0;
		}
	@Override
	public List<MyUser> getUser(String sex) {
		
		// TODO Auto-generated method stub
		return myPrjProjectDao.getUser(sex);
	}
	@Override
	public List<CorpInfo> getCorp(String custId) {
		// TODO Auto-generated method stub
		return myPrjProjectDao.getCorp(custId);
	}
	}


