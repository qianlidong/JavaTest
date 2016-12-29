package com.qian.task;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 使用Fork/Join框架实现大任务分割成小任务，最后合并结果
 * 并发编程艺术这本书的6.4章节有详细说明
 * @author qld
 *
 */
public class CountTask extends RecursiveTask<Integer>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static int THRESHOLD=10;//设置一个计算的阈值,相当于平均数，越接近，计算次数越少
    private int start;
    private int end;
   // private int inCount=0;
    
    public CountTask(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    /**
     * 这个方法是最终用来返回result.get()方法的结果的
     */
    @Override
    protected Integer compute() {
        // TODO Auto-generated method stub
        int sum=0;
        //inCount+=1;
        //
        boolean canCompute=(end-start)<=THRESHOLD;
        System.out.println("进来了几次:"+canCompute);
        if(canCompute){
         for (int i = start; i <= end; i++) {
            sum+=i;
        }   
            
            
        }else{
            int middle=(start+end)/2;
            CountTask leftTask=new CountTask(start, middle);
            CountTask rightTask=new CountTask(middle+1, end);
            //
            leftTask.fork();
            rightTask.fork();
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            sum=leftResult+rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        
        ForkJoinPool pool=new ForkJoinPool();
        CountTask task=new CountTask(1, 20);
        Future<Integer> result=pool.submit(task);
        System.out.println("计算的结果是:"+result.get());
        
        
    }
    
}
