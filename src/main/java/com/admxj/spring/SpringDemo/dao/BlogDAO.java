package com.admxj.spring.SpringDemo.dao;

import com.admxj.spring.SpringDemo.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BlogDAO {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valueOperations;


    public void save(Blog blog){
        valueOperations.set("blog" + blog.getId(), blog);
    }

    public Blog getBlogById(String id){
        return (Blog) valueOperations.get("blog" + id);
    }

}
