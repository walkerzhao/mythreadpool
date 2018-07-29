# mythreadpool
* just a demo for my thread pool
* 目的在于更加深刻的理解线程池.


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

### 重要的成员变量
* corePoolSize:核心线程池的大小;
* maximumPoolSize:最大线程池大小;
* largestPoolSize: 线程池的最大记录,仅做记录使用.


##  实现问题记录,以及解决方案

FAQ:
## 为什么需要线程池?
* 避免反复创建线程对象,带来的性能开销(创建线程/销毁线程),节省系统的资源;
* 当然是线程框架使用起来更加便捷.


