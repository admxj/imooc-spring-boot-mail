package com.admxj.spring.SpringDemo.controller;

import com.admxj.spring.SpringDemo.entity.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JsonController {

    @PostMapping("/json")
    public String json(@RequestBody Resource resource){

        return resource.toString();
    }

}
