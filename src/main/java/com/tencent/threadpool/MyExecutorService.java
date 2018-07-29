package com.tencent.threadpool;

import java.util.List;

/**
 * 继承了 顶层接口--Executor
 * 并声明了几个方法 submit/invokeall/invokeany/shutdown等;
 * Created by andy on 2018/7/28.
 */
public interface MyExecutorService extends MyExecutor {

    void shutdown();

    List<Runnable> shutdownNow();

    boolean isShutdown();

    boolean isTerminated();
}
