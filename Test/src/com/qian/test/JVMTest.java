package com.qian.test;
/**
 * @param args
 * <p style="color=red">zhzhzhz
 * </p>
 * 
 */
public class JVMTest {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        method();
    }

    
    /**
     * VM参数：-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
   private static final int _1MB = 1024 * 1024;
    
    public static void method(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[22*_1MB];
        try {
            Thread.sleep(1000);
            Thread.sleep(1000);
            Thread.sleep(1000);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("22M之后");
        //allocation2=new byte[7*_1MB];
      //allocation3=new byte[2*_1MB];
        allocation2=new byte[1024*512];
        System.out.println("young gc"+Runtime.getRuntime().freeMemory()/1024);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("2M之后，放在了年轻代");
        allocation3=new byte[2*_1MB];
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("2M之后，放在了年轻代");
        
        allocation4=new byte[3*_1MB];
        System.out.println("4M之后，放在了年老代");
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
    
}
