package com.admxj.spring.SpringDemo.controller;

import com.admxj.spring.SpringDemo.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "/index")
    public String index(ModelMap map){
        map.addAttribute("resource", resource);

        return "thymeleaf/index";
    }
}
