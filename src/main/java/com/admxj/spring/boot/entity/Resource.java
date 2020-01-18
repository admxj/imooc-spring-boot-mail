package com.admxj.spring.boot.entity;

import org.springframework.stereotype.Component;

@Component
public class Resource {

    private String name = "admxj";
    private String website = "www.admxj.com";
    private String language = "zh_CN";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
