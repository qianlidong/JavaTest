package com.qian.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.qian.log.handler.DBContextHolder;

public class DynamicDataSource extends AbstractRoutingDataSource{  
	  
    @Override  
    protected Object determineCurrentLookupKey() {  
        return DBContextHolder.getDBType();  
    }  
}  
