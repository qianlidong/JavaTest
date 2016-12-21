package com.qian.service;

import com.qian.model.MyUser;

public interface PersonService {
	 public abstract void save(MyUser person);
	 
	 public void getSome();
	 
	 public <T> T doSome(T t);
}
