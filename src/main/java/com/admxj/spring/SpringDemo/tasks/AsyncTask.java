package com.admxj.spring.SpringDemo.tasks;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    public Future<Boolean> doTask11() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();

        logger.info("任务1耗时: "+(end-start)+"毫秒");

        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask22() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();

        logger.info("任务1耗时: "+(end-start)+"毫秒");

        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask33() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();

        logger.info("任务1耗时: "+(end-start)+"毫秒");

        return new AsyncResult<>(true);
    }
}
