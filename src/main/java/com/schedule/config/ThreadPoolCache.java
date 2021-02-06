package com.schedule.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author
 * @Date 2021/2/6 下午12:23
 * @Version 1.0
 * @Remarks
 */
public class ThreadPoolCache {


    public static class InitThreadPoolCache{
        public static ExecutorService  executorService = Executors.newCachedThreadPool();
    }
}
