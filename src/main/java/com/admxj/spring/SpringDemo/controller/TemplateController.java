package com.admxj.spring.SpringDemo.controller;

import com.admxj.spring.SpringDemo.properties.JdbcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TemplateController {

    @Autowired
    private JdbcProperties jdbcProperties;

    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){

        System.out.println(jdbcProperties.getJdbc());

        map.put("hello","from TemplateController.helloHtml");
        return"/helloHtml";
    }
}
