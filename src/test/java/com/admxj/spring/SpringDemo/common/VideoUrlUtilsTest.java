package com.admxj.spring.SpringDemo.common;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @auther admxj
 * @create 2019-01-05 22:26
 */
public class VideoUrlUtilsTest {

    @Test
    public void getId() {
        String id = VideoUrlUtils.getId("https://h5.hulushequ.cn/item/6642666596252784903?user_id=6505708652&cell_type=8&cell_id=1621745387536413");
        System.out.println(id);
    }
}