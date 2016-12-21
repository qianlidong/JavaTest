package com.qian.model;

public enum MyEnum {

	BOY("男");
	
	
	public final String value;
	MyEnum(String value){
		this.value=value;
	}
	
	public static String getName(){
		System.out.println("看看吧");
		return "哈哈";
	}
	
	
}
