package com.qian.test;

import java.util.HashMap;
import java.util.UUID;

/**
 * 测试在大并发下hashmap的线程不安全引起死循环
 * @author qld
 *
 */
public class HashMapTest {

    final static HashMap<String, String> map=new HashMap<>(2);
    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        long stime=System.currentTimeMillis();
       Thread t=new Thread(new Runnable() {
        
        @Override
        public void run() {
            // TODO Auto-generated method stub
            for (int i = 0; i < 10000; i++) {
                new Thread(new Runnable() {
                    
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        map.put(UUID.randomUUID().toString(), "");
                    }
                },"ftf"+i).start();
            }
        }
    },"ftf");

       t.start();
       t.join();
       System.out.println("map的长度:"+map.size());
       System.out.println("结束时间:"+(System.currentTimeMillis()-stime));
    }

}
