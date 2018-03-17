package com.admxj.spring.SpringDemo.message;

import com.admxj.spring.SpringDemo.SpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SenderTest {

    @Autowired
    Sender sender;

//    @Test
//    public void send() {
//        sender.send("测试2");
//    }
}