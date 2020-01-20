package com.admxj.spring.boot.nginx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntity {

    /**
     * 主键ID
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * 客户端IP
     */
    @JsonProperty("ip")
    private String ip;
    /**
     * 访问时间
     */
    @JsonProperty("time")
    private LocalDateTime time;
    /**
     * 请求方式 GET/POST/PUT 等
     */
    @JsonProperty("request")
    private String request;
    /**
     * 访问的url地址
     */
    @JsonProperty("url")
    private String url;
    /**
     * http协议
     */
    @JsonProperty("protocol")
    private String protocol;
    /**
     * 请求结果响应码
     */
    @JsonProperty("code")
    private Integer code;
    /**
     * 请求访问的字节数量
     */
    @JsonProperty("sendByteSize")
    private Integer sendByteSize;
    /**
     * 访问者访问渠道来源
     */
    @JsonProperty("refferer")
    private String refferer;
    /**
     * 访问者的用户代理
     */
    @JsonProperty("useAgent")
    private String useAgent;
    /**
     * 访问者是不是爬虫或机器人
     */
    @JsonProperty("isBot")
    private boolean isBot;
    /**
     * 访问的是不是静态资源文件，例如：css、js、图片等文件
     */
    @JsonProperty("isResource")
    private boolean isResource;
    /**
     * 当前项目名称
     */
    @JsonProperty("project")
    private String project;

}