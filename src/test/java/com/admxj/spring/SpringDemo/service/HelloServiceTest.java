package com.admxj.spring.SpringDemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by admxj on 2018/10/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {

    @Resource
    private HelloService helloService;

    @Test
    public void sayHello() {
        System.out.println(helloService.sayHello());
    }
}