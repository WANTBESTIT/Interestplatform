package com.example.interestplfm.mapper;

import com.example.interestplfm.entity.Picture;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface PictureMapper {
    @Insert("INSERT INTO Picture (blogId, uploadTime, pictureContent) VALUES (#{blogId}, #{uploadTime}, #{pictureContent})")
    @Options(useGeneratedKeys = true, keyProperty = "pictureId")
    void insertPicture(Picture picture);
}
