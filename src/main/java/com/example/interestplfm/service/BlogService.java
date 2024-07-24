package com.example.interestplfm.service;

import com.example.interestplfm.entity.Blog;
import com.example.interestplfm.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public List<Blog> getBlogsByStatus(String status) {
        return blogMapper.findBlogsByStatus(status);
    }

    public void createBlog(Blog blog) {
        blogMapper.insertBlog(blog);
    }

    public void updateBlogStatus(Long blogId, String blogStatus) {
        blogMapper.updateBlogStatus(blogId, blogStatus);
    }
}