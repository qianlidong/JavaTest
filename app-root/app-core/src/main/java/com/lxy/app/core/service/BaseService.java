package com.lxy.app.core.service;

import java.util.List;

public interface BaseService {
	void save(Object entity);

	//我来修改下 qld 20161221 121212  HHHHH 111 s

	<T> T getById(Class<T> clazz, Object id);
	
	
	<E> E someOne();

}
