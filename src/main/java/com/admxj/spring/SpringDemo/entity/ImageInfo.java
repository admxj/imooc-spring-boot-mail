package com.admxj.spring.SpringDemo.entity;

import org.springframework.stereotype.Component;

@Component
public class ImageInfo {

    private Integer id = 0;
    private String imagePath;
    private String videoPath;

    public ImageInfo() {
    }

    public ImageInfo(String imagePath, String videoPath) {
        this.imagePath = imagePath;
        this.videoPath = videoPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ImageInfo{");
        sb.append("id=").append(id);
        sb.append(", imagePath='").append(imagePath).append('\'');
        sb.append(", videoPath='").append(videoPath).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
