package com.admxj.spring.SpringDemo.service;

import com.admxj.spring.SpringDemo.entity.ImageInfo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @auther admxj
 * @create 2019-01-05 23:18
 */
public class PPXVideoServiceTest {

    private PPXVideoService ppxVideoService = new PPXVideoService();

    @Test
    public void getCommentVideo() {
        String url = "https://h5.hulushequ.cn/bds/webapi/cell/detail/?cell_id=1621745387536413&cell_type=8";
        ImageInfo video = ppxVideoService.getCommentVideo(url);
        System.out.println(video);
    }

    @Test
    public void getPublishVideo() {
        String url = "https://h5.hulushequ.cn/item/6642991889677031684?app_id=1411&app=super_explore&utm_source=weixin&timestamp=1546700592&user_id=6505708652";
        ppxVideoService.getPublishVideo(url);
    }
}