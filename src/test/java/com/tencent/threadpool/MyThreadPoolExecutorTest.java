package com.tencent.threadpool;

import com.tencent.threadpool.impl.MyThreadPoolExecutor;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by andy on 2018/7/30.
 */
public class MyThreadPoolExecutorTest {

    /**
     * corepoolsize:5, maxpoolsize:10,任务队列为5
     * 当任务个数小于5时,创建新的线程去处理;当 任务个数大于5时, 添加到任务队列;当任务队列满的时候,创建新的线程,到maxpoolsize; 当任务再多的时候,丢弃任务.
     */
    @Test
    public void test() {
        System.out.println("hello,world");
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5,10, 200 , TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));


        // 可以调整任务的个数,来做测试
        for(int i=0 ; i< 16; i++) {
            MyTask myTask = new MyTask(i);
            myThreadPoolExecutor.execute(myTask);
            System.out.println("线程池中线程数目："+ myThreadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    myThreadPoolExecutor.getQueue().size()+"，已执行完的任务数目："+myThreadPoolExecutor.getCompletedTaskCount());

        }

        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程池中线程数目："+ myThreadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                myThreadPoolExecutor.getQueue().size()+"，已执行完的任务数目："+myThreadPoolExecutor.getCompletedTaskCount());

    }
}

class MyTask implements  Runnable {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("task start.taskNum:" + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+" end.");

    }
}
