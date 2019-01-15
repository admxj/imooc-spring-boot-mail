package com.admxj.spring.SpringDemo.service;

import com.admxj.spring.SpringDemo.common.HttpGetUtils;
import com.admxj.spring.SpringDemo.common.VideoUrlUtils;
import com.admxj.spring.SpringDemo.entity.ImageInfo;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @auther admxj
 * @create 2019-01-05 22:30
 */
@Service
public class PPXVideoService {

    private static final String PPX_COMMENT_URL = "https://h5.hulushequ.cn/bds/webapi/cell/detail/?cell_id=%s&cell_type=8";
    private static final String PPX_PUBLISH_URL = "https://h5.hulushequ.cn/bds/webapi/item/detail/?item_id=%s";

    public ImageInfo getCommentVideo(String url){

        VideoUrlUtils.UrlEntity parse = VideoUrlUtils.parse(url);
        String id = parse.params.get("cell_id");
        ImageInfo imageInfo = null;
        try {
            String s = HttpGetUtils.get(String.format(PPX_COMMENT_URL, id));
            JsonObject asJsonObject = new JsonParser().parse(s).getAsJsonObject();
            JsonObject data = asJsonObject.getAsJsonObject("data");
            JsonObject comment = data.getAsJsonObject("comment");
            JsonObject video = comment.getAsJsonObject("video");
            JsonArray url_lists = video.getAsJsonArray("url_list");
            JsonObject url_list = url_lists.get(0).getAsJsonObject();
            String videoPath = url_list.get("url").getAsString();

            JsonObject cover_image = comment.getAsJsonObject("cover");
            url_lists = cover_image.getAsJsonArray("url_list");
            url_list = url_lists.get(0).getAsJsonObject();
            String imagePath = url_list.get("url").getAsString();

            imageInfo = new ImageInfo(imagePath, videoPath);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageInfo;
    }

    public ImageInfo getPublishVideo(String url){
        String id = StringUtils.substringBetween(url, "hulushequ.cn/item/", "?app_id=");

        try {
            String s = HttpGetUtils.get(String.format(PPX_PUBLISH_URL, id));
            JsonObject asJsonObject = new JsonParser().parse(s).getAsJsonObject();
            JsonObject data = asJsonObject.getAsJsonObject("data");
            JsonObject item = data.getAsJsonObject("item");
            JsonObject video = item.getAsJsonObject("video");
            JsonObject video_low = video.getAsJsonObject("video_low");

            JsonArray url_lists = video_low.getAsJsonArray("url_list");
            JsonObject url_list = url_lists.get(0).getAsJsonObject();
            String videoPath = url_list.get("url").getAsString();

            JsonObject cover_image = video_low.getAsJsonObject("cover");
            url_lists = cover_image.getAsJsonArray("url_list");
            url_list = url_lists.get(0).getAsJsonObject();
            String imagePath = url_list.get("url").getAsString();


            System.out.println(video_low);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
