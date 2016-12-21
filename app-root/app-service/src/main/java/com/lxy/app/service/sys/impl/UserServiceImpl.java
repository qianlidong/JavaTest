package com.lxy.app.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lxy.app.dao.sys.UserDao;
import com.lxy.app.domain.sys.User;
import com.lxy.app.service.sys.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/*
	 * public User getById(Class<T> clazz, Object id) { //return
	 * userDao.getById(clazz, id);
	 * 
	 * }
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(User entity) {
		userDao.save(entity);
	}

	public User findById(Long id) {
		return userDao.findById(id);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

}
