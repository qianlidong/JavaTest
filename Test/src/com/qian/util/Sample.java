package com.qian.util;



import org.junit.Before;
import org.junit.Test;

public class Sample {


	
	@Test public  void m1(){
		System.out.println("m1");
	}
	
	
	 public static void m2(){
		 
		System.out.println("m2");
	}
	
	@Test public  void m3(){
		System.out.println("m3");
		throw new RuntimeException("m3");
	}
	
	@Before 
	public void before(){
	   	Integer i ;
		System.out.println();
		System.out.println("测试开始之前");
	}
}
