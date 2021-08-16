package com.lance.mybatisplus.base.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: mybatisplus  ThreadPoolTest
 * @description:
 * @author: flchen
 * @create: 2021-07-07 11:58
 **/

public class ThreadPoolTest {
    private static ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("线程-demo-%d").build();

    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new
            ArrayBlockingQueue<>(10), namedFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 1; i <= 14; i++) {
            Callable<Boolean> task = createTask(i);
            pool.submit(task);
            System.out.println("after task:" + i + " submitted, current active count: "
                    + pool.getActiveCount() + ", size of queue: " + pool.getQueue().size());
        }
        pool.shutdown();
    }

    /**
     * @Author Xu hao
     * @Description 创建任务
     * @Date 2019/3/19 0:08
     * @param i
     * @return java.util.concurrent.Callable<java.lang.Boolean>
     **/
    private static Callable<Boolean> createTask(int i){

        Callable<Boolean> callable = () -> {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("thread: " + Thread.currentThread().getName() + " execute task: " + i);
            return true;
        };

        return callable;
    }
}
