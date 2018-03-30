package com.admxj.spring.SpringDemo.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class TestTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //每隔三秒执行任务
//    @Scheduled(fixedRate = 3000)
    //每分钟的第4秒到第40秒 每秒钟执行
    @Scheduled(cron = "4-40 * * * * ? ")
    public void reportCrrentTime(){

        logger.info("现在时间: " + dateFormat.format(new Date()));

    }

}
