package com.lxy.app.domain.test;

import com.lxy.app.core.test.HelloWord;

public class SayHello {
	private String say;

	public String getSay() {
		return say;
	}

	public void setSay(String say) {
		this.say = say;
	}

	public String toString() {
		return HelloWord.sayHello();
	}

}
