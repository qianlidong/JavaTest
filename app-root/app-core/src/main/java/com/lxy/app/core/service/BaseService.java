package com.lxy.app.core.service;

import java.util.List;

public interface BaseService {
	void save(Object entity);

	<T> T getById(Class<T> clazz, Object id);

}
