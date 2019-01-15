package com.admxj.spring.SpringDemo.controller;

import com.admxj.spring.SpringDemo.common.HttpGetUtils;
import com.admxj.spring.SpringDemo.common.VideoUrlUtils;
import com.admxj.spring.SpringDemo.entity.ImageInfo;
import com.admxj.spring.SpringDemo.service.PPXVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/download")
public class DownloadController {

    @Autowired
    private PPXVideoService ppxVideoService;

    @PostMapping("")
    public ImageInfo index(@RequestParam("url") String url){

        ImageInfo video = ppxVideoService.getCommentVideo(url);
        return video;
    }

}
