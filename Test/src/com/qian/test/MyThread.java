package com.qian.test;

public class MyThread implements Runnable {

    public volatile int abc = 0;
    public String name = "";
    int a=0;
    boolean flag=false;
    private static final int _1MB = 1024 * 1024;
    public MyThread(int abc) {
        super();
        this.abc = abc;
    }

    /**
     * @param args
     */

    public void run() {
        
        byte[]  allocation1=new byte[22*_1MB];
        
//        wirte();
//        reader();
//        for (int i = 0; i < 10; i++) {
//
//            abc++;
//            System.out.println(i + "线程名称" + ":" + abc + "   " + Thread.currentThread().getName());
//        }
//        System.out.println("醒来了");
    }

    public static void main(String[] args) {
        MyThread t=new MyThread(1);
        new Thread(t).start();
        MyThread t1=new MyThread(1);
        new Thread(t1).start();
    }
    
    
    public void wirte(){
        a=1;
        flag=true;
    }
    
    public void reader(){
        if(flag){
            int k=a*a;
            System.out.println("k的值是多少:"+k+"线程名称:"+Thread.currentThread().getName());
        }
    }
}
