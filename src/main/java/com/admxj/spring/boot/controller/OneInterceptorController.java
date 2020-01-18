package com.admxj.spring.boot.controller;

import com.admxj.spring.boot.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/one")
public class OneInterceptorController {

    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String index(ModelMap map){

        map.put("resource", resource);

        return "thymeleaf/index";
    }

}
