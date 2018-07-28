package com.tencent.threadpool;

/**
 * Created by andy on 2018/7/28.
 */
public interface MyThreadPool {
    void execute(Runnable task);    //执行任务

    void destroy();    //销毁线程
}
