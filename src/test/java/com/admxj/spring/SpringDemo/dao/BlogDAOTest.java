package com.admxj.spring.SpringDemo.dao;

import com.admxj.spring.SpringDemo.entity.Blog;
import com.admxj.spring.SpringDemo.SpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class BlogDAOTest {

    @Autowired
    BlogDAO blogDAO;

    @Test
    public void save() {

        Blog blog = new Blog();
        blog.setId("123");
        blog.setTitle("test");
        blog.setContent("内容");

        blogDAO.save(blog);
    }

    @Test
    public void getBlogById() {
        Blog blog = blogDAO.getBlogById("123");
        System.out.println(blog);
    }
}