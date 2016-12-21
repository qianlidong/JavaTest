package com.qian.test;

public class WaitNotify {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.out.println("开始测试吧");
        
        WaitNotify wn=new WaitNotify();
    
        synchronized (wn) {
            
          wn.wait(1000);
        }
//        synchronized (wn) {
//            System.out.println("这能进来吗");
//            wn.notify();
//          }
        System.out.println("在等待吗");
       
        
      
    }

    
    
    
    
}
