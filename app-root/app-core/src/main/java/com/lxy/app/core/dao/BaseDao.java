package com.lxy.app.core.dao;

public interface BaseDao {
	
	void save(Object entity);

	<T> T getById(Class<T> clazz, Object id);
}
