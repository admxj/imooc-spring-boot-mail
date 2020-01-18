package com.admxj.spring.boot.utils;

import org.junit.Test;

public class JsonUtilsTest {

    static class TestThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {


        for (int i = 0; i < 100; i++){
            new TestThread().start();
        }

    }

    @Test
    public void objectToJson() {
        JsonUtils.objectToJson(null);
    }

    @Test
    public void jsonToPojo() {
    }

    @Test
    public void jsonToList() {
    }
}
