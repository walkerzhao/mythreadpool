package com.tencent.threadpool;

import com.tencent.threadpool.impl.MyThreadPoolExecutor;


/**
 * Created by andy on 2018/7/30.
 */
public interface MyRejectedExecutionHandler {

    void rejectedExecution(Runnable r, MyThreadPoolExecutor executor);
}
