package com.admxj.spring.boot.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author admxj
 */
@Component
public class ScheduledDemo {

    @Resource
    private CharlesMetrics charlesMetrics;
    private int count1;
    private int count2;
    private int count3;

    @Async("One")
    @Scheduled(fixedDelay = 1000)
    public void increment1() {
        count1++;
        charlesMetrics.counter1.increment();
        charlesMetrics.map.put("x", Double.valueOf(count1));
        System.out.println("increment1 count: " + count1);

    }

    @Async("Two")
    @Scheduled(fixedDelay = 10000)
    public void increment2() {
        count2++;
        charlesMetrics.counter2.increment();
        charlesMetrics.map.put("x", Double.valueOf(count2));
        System.out.println("increment2 count: " + count2);

    }

    @Async("Three")
    @Scheduled(fixedDelay = 20000)
    public void increment3() {
        count3++;
        charlesMetrics.counter3.increment();
        charlesMetrics.map.put("x", Double.valueOf(count3));
        System.out.println("increment3 count: " + count3);

    }
}
