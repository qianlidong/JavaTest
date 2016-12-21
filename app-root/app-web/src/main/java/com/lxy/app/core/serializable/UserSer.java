package com.lxy.app.core.serializable;

import java.io.Serializable;

public class UserSer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private int age;

	private int sex;

	public UserSer() {
	}

	public UserSer(String id, String name, int age, int sex) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String toString() {
		return "[id=" + this.id + ",name=" + this.name + ",age=" + this.age+"]";
	}

}
