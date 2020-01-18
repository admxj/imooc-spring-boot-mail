package com.admxj.spring.boot.controller;

import com.admxj.spring.boot.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "/index")
    public Model index(ModelMap map, HttpServletRequest request) {
        ModelMap modelMap;
        ModelAndView modelAndView;

        map.addAttribute("resource", resource);

//        return "thymeleaf/index";
        return null;
    }
}
