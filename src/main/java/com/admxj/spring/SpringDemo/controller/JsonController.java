package com.admxj.spring.SpringDemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class Student{

    private String name;

    private Integer age;

}

@RestController
public class JsonController {

    @PostMapping("/json")
    public String json(@RequestBody Student student){


        return student.toString();
    }

}
