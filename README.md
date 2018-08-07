# mythreadpool
* just a demo for my thread pool
* 目的在于更加深刻的理解线程池.

# task list 实现
* Executors;
* ScheduledThreadPoolExecutor;
* ForkJoinPool


https://segmentfault.com/a/1190000011547008

java线程池分析
https://www.cnblogs.com/absfree/p/5357118.html


# 一步一步,实现java线程池
## 需求理解:明白线程池需要实现的功能;
* api:创建线程池,销毁线程池;
* 执行任务的多个线程--worker 线程;
* 动态伸缩/扩容--管理线程;
* 任务队列:添加新任务/队列拒绝策略;

##  需求分析,实现的关键点
### 线程池的5种状态:https://blog.csdn.net/l_kanglin/article/details/57411851
* 线程池的多个状态,状态之间的转换条件;
* 线程池执行任务逻辑:如果核心线程池任务没满,创建线程执行任务;如果核心线程池已满,但是任务队列没满,放进任务队列;如果核心线程池已满,并且任务队列已满,并且线程数小于最大线程数,创建线程执行.如果线程数超了,采用策略,丢弃任务.
* 向线程池提交任务:execute线程池执行任务逻辑,不返回执行结果,submit提交之后,调用execute,并可以 future.get()获取结果.
* 线程池的关闭,shutdown和shutdownNow,关闭的范围不一样,前者是关闭没有执行的任务,后者是关闭所有的任务.
* 线程池的参数配置:CPU密集型还是io密集型;任务的优先级;任务的执行时间;任务的依赖性,比如db连接池.

### 重要的成员变量
* corePoolSize:核心线程池的大小;
* maximumPoolSize:最大线程池大小;
* largestPoolSize: 线程池的最大记录,仅做记录使用.

### Worker的作用
* 对线程和任务的封装.

### 任务提交到线程池之后的处理策略
* 如果当前的线程数目小于 corepoolsize,则新建一个线程去执行任务;
* 如果当前线程数目大于corepoolsize,那么添加到任务队列,如果添加成功,则等待空闲线程来取出执行;否则,尝试创建新的线程去执行任务;
* 如果当前的线程数目大于 maxpoolsize,那么会执行拒绝策略;
* 如果线程数目大于 corepoolsize,那么会检查线程的空闲时间,如果空闲时间大于 keepAliveTime, 线程会被终止.


### 线程的初始化
* 创建线程池的时候, 线程池中是没有线程的, 提交任务之后,才会去创建线程.

### 任务缓存队列以及排队策略
* 阻塞队列 workerqueue, 用来存放队列.
* BlockingQueue 通常有三种实现方式. ArrayBlockingQueue/LinkedBlockingQueue/synchronousQueue

### 任务拒绝策略
* 当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略
* 通常的任务拒绝策略:AbortPolicy/DiscardPolicy/DiscardOldestPolicy/CallerRunsPolicy

### 线程池的关闭
* shutdown()  --执行完队列里的任务,不会接受新的任务;
* shutdownNow() --立即终止线程池.

### 线程池动态容量调整
* setCorePoolSize/setMaximumPoolSize

### 线程池测试demo
* 参见 MyThreadPoolExecutorTest

### 创建线程池的几种推荐方式
实际中，如果Executors提供的三个静态方法能满足要求，就尽量使用它提供的三个方法，因为自己去手动配置ThreadPoolExecutor的参数有点麻烦，要根据实际任务的类型和数量来进行配置。
Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
Executors.newFixedThreadPool(int);    //创建固定容量大小的缓冲池


### 线程池大小的配置
一般需要根据任务的类型来配置线程池大小：

　　如果是CPU密集型任务，就需要尽量压榨CPU，参考值可以设为 NCPU+1

　　如果是IO密集型任务，参考值可以设置为2*NCPU

　　当然，这只是一个参考值，具体的设置还需要根据实际情况进行调整，比如可以先将线程池大小设置为参考值，再观察任务运行情况和系统负载、资源利用率来进行适当调整。

##  实现问题记录,以及解决方案

FAQ:
## 为什么需要线程池?
* 避免反复创建线程对象,带来的性能开销(创建线程/销毁线程),节省系统的资源;
* 当然是线程框架使用起来更加便捷.

## 何为线程切换开销?


## 线程池中用到了哪些设计模式??
* 代理模式:https://www.cnblogs.com/ChaosJu/p/4531795.html   是Thread代理了具体的任务,执行的时候,添加了具体的逻辑.
* 命令模式:https://blog.csdn.net/zerohuan/article/details/50039005   将任务封装成一个个的任务命令,提交到任务队列中,获取到执行结果.
* 工厂模式:ThreadFactory,线程工厂.


## Executors中有哪几种常见的线程池?



## 线程池实现的类图大概是什么样子的?
* Executor/abstractExecutor/ThreadPoolExecutor/ScheduledThreadPoolExecutor/Executors,主要是这几个类

