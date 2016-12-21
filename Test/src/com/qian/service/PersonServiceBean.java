package com.qian.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.qian.dao.MyPrjProjectDao;
import com.qian.model.MyUser;

@Service
public class PersonServiceBean implements PersonService{

	
	@Autowired
	private MyPrjProjectDao myPrjProjectDao;
	 
	     public void save(MyUser person) {
	    	
	    	 //myPrjProjectDao.savePerson(person);
	     }

		@Override
		public void getSome() {
			 System.out.println("我要看看");
		}

        @Override
        public <User> User doSome(User u) {
            // TODO Auto-generated method stub
            u.hashCode();
            return u;
        }

}
