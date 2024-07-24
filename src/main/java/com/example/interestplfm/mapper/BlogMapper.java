package com.example.interestplfm.mapper;

import com.example.interestplfm.entity.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper {
    @Select("SELECT * FROM Blog WHERE blogStatus = #{status}")
    List<Blog> findBlogsByStatus(String status);

    @Insert("INSERT INTO Blog (userId, flavorId, thumbsNumber, commentNumber, issueTime, blogContent, blogStatus) " +
            "VALUES (#{userId}, #{flavorId}, #{thumbsNumber}, #{commentNumber}, #{issueTime}, #{blogContent}, #{blogStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "blogId")
    void insertBlog(Blog blog);

    @Update("UPDATE Blog SET blogStatus = #{blogStatus} WHERE blogId = #{blogId}")
    void updateBlogStatus(@Param("blogId") Long blogId, @Param("blogStatus") String blogStatus);
}