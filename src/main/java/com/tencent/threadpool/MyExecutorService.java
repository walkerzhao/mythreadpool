package com.tencent.threadpool;

import java.util.List;

/**
 * Created by andy on 2018/7/28.
 */
public interface MyExecutorService extends MyExecutor {

    void shutdown();

    List<Runnable> shutdownNow();

    boolean isShutdown();

    boolean isTerminated();
}
