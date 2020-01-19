package com.admxj.spring.boot.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author admxj
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i ++){
            executor.execute(new Task());
        }
    }
}
