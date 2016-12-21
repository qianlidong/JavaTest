package com.lxy.test;


/**
 *  -verbose:gc -Xmx20M -Xms20M -Xmn10M
 *  -XX:MaxPermSize=5M -XX:SurvivorRatio=8  
 *  -XX:+PrintGCDetails -XX:+PrintTenuringDistribution
 *  @author sks
 *
 */
public class Test {
	
	public static void main(String args[]) throws Exception{
		System.out.println("start:");
		Thread.sleep(20000);
		methodA();
		System.out.println("end:");

	}

	public static void methodA() throws InterruptedException {
		System.out.println("method A");
		//Thread.sleep(2000);
		methodB();
	}

	public static void methodB() throws InterruptedException {
		System.out.println("method B");
		//Thread.sleep(2000);
		methodA();
	}

}
