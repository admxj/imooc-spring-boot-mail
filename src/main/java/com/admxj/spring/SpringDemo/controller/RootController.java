package com.admxj.spring.SpringDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class RootController {

    @GetMapping("")
    public String index(){

        return "梦德租号网站！";
    }

}
