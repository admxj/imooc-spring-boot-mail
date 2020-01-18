package com.admxj.spring.boot.controller;

import com.admxj.spring.boot.tasks.AsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/tasks")
public class DoTaskController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/index")
    public String index() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<Boolean> task11 = asyncTask.doTask11();
        Future<Boolean> task22 = asyncTask.doTask22();
        Future<Boolean> task33 = asyncTask.doTask33();

        while (!task11.isDone() || !task22.isDone() || !task33.isDone()){
            if (task11.isDone() && task22.isDone() && task33.isDone()){
                break;
            }
        }

        long end = System.currentTimeMillis();
        String times = "任务全部完成, 总耗时: " + (end - start) +"毫秒";
        logger.info(times);

        return times;
    }

}
