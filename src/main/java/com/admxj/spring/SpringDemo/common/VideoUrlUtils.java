package com.admxj.spring.SpringDemo.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther admxj
 * @create 2019-01-05 22:25
 */
public class VideoUrlUtils {


    public static String getId(String url){
        /**
         * https://h5.hulushequ.cn/item/6642666596252784903?user_id=6505708652&cell_type=8&cell_id=1621745387536413
         */
        String[] split = url.split("cell_id=");
        return split[1];
    }

    public static class UrlEntity {
        /**
         * 基础url
         */
        public String baseUrl;
        /**
         * url参数
         */
        public Map<String, String> params;
    }

    public static UrlEntity parse(String url) {
        UrlEntity entity = new UrlEntity();
        if (url == null) {
            return entity;
        }
        url = url.trim();
        if (url.equals("")) {
            return entity;
        }
        String[] urlParts = url.split("\\?");
        entity.baseUrl = urlParts[0];
        //没有参数
        if (urlParts.length == 1) {
            return entity;
        }
        //有参数
        String[] params = urlParts[1].split("&");
        entity.params = new HashMap<>();
        for (String param : params) {
            String[] keyValue = param.split("=");
            entity.params.put(keyValue[0], keyValue[1]);
        }

        return entity;
    }

}
