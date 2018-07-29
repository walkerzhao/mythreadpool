package com.tencent.threadpool;

/**
 * 顶层接口--定义一个任务,用来执行任务
 * Created by andy on 2018/7/28.
 */
public interface MyExecutor {
    void execute(Runnable command);
}
