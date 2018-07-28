package com.tencent.threadpool;

/**
 * Created by andy on 2018/7/28.
 */
public interface MyExecutor {
    void execute(Runnable command);
}
