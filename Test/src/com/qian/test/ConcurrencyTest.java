package com.qian.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;




public class ConcurrencyTest<E> {

    static final int MAXIMUM_CAPACITY = 1 << 30;
    static boolean ALTERNATIVE_HASHING = 123456 <= MAXIMUM_CAPACITY;
    private static final long count=100000000;
    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
//        System.out.println(new Thread().getName());
//        concurreny();
       /**
        * 可以测出direct memory的大小，默认的是64M的
        */
//        Class<?> c = Class.forName("java.nio.Bits");
//        Field maxMemory = c.getDeclaredField("maxMemory");
//        maxMemory.setAccessible(true);
//        Field reservedMemory = c.getDeclaredField("reservedMemory");
//        reservedMemory.setAccessible(true);
//        Long maxMemoryValue = (Long)maxMemory.get(null);
//        Long reservedMemoryValue = (Long)reservedMemory.get(null);
//        System.out.println(ALTERNATIVE_HASHING);
//        System.out.println("maxMemoryValue:"+maxMemoryValue);
//        System.out.println("reservedMemoryValue:"+reservedMemoryValue);
          ConcurrentHashMap<String, String> cmap=new ConcurrentHashMap<>();
           //在你使用的时候可曾想过，这是怎么回事呢，各种散列列表二叉树      
//        System.out.println(Integer.parseInt("0001111",2)&15);
//        System.out.println(Integer.parseInt("0011111",2)&15);
//        System.out.println(Integer.parseInt("0111111",2)&15);
//        System.out.println(Integer.parseInt("0111111",2)&15);
//        System.out.println(Integer.parseInt("0011011",2)&15);
          ConcurrentLinkedQueue<String> link1=new ConcurrentLinkedQueue<>();
        Integer j=452;
        
        System.out.println(23&4);
        System.out.println(hash(j.hashCode()));
        System.out.println(Runtime.getRuntime().availableProcessors());
           poll();
    }

 
    public static  int poll() {
        restartFromHead:
        for (;;) {
                for (int k=0;k<10;k++) {
                    if(k==8){
                        return k;
                    }else{
                        System.out.println("这是什么");
                      continue restartFromHead;  
                    }
                }
            
        }
    }
    
    
    

    private static int hash(Object k) {
        int h = 0;

        h ^= k.hashCode();

        // Spread bits to regularize both segment and index locations,
        // using variant of single-word Wang/Jenkins hash.
        h += (h <<  15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h <<   3);
        h ^= (h >>>  6);
        h += (h <<   2) + (h << 14);
        return h ^ (h >>> 16);
    }
    

    private static void concurreny() throws InterruptedException{
        long start=System.currentTimeMillis();
        Thread thread=new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                int a=0;
                for (int i = 0; i < count; i++) {
                    a+=5;
                }
            }
        });
        
        thread.start();

        synchronized (thread) {
            System.out.println("1111");
        }
        int b=0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long time=System.currentTimeMillis()-start;
        System.out.println("时间:"+time+"当前线程名:"+thread.getName());
        
    }
    
    
    
}
