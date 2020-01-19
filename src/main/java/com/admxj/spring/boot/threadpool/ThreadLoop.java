package com.admxj.spring.boot.threadpool;

/**
 * @author admxj
 */
public class ThreadLoop {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            Thread thread = new Thread(new Task());
            thread.start();
        }
    }


    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("启动一个线程: " + Thread.currentThread().getId());
        }
    }
}
