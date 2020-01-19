package com.admxj.spring.boot.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author admxj
 */
public class ThreadPoolOom {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            executorService.execute(new SubThread());
        }
    }
}

class SubThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(50000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("启动线程: "+ Thread.currentThread().getName());
    }
}


