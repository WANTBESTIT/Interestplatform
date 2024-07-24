package com.example.interestplfm.controller;

import com.example.interestplfm.entity.Blog;
import com.example.interestplfm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/{status}")
    public List<Blog> getBlogsByStatus(@PathVariable String status) {
        return blogService.getBlogsByStatus(status);
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        blogService.createBlog(blog);
        return blog;
    }

    @PutMapping("/{blogId}/status")
    public void updateBlogStatus(@PathVariable Long blogId, @RequestParam String status) {
        blogService.updateBlogStatus(blogId, status);
    }
}
