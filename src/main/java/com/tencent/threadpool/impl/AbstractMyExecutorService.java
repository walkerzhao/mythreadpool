package com.tencent.threadpool.impl;

import com.tencent.threadpool.MyExecutorService;

import java.util.List;

/**
 * Created by andy on 2018/7/29.
 */
public class AbstractMyExecutorService implements MyExecutorService {
    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public void execute(Runnable command) {

    }
}
