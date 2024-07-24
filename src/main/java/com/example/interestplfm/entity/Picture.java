package com.example.interestplfm.entity;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Picture implements Serializable {
    private Long pictureId;
    private Long blogId;
    private LocalDateTime uploadTime;
    private String pictureContent;

    // 添加 setPictureContent 方法，接受一个 byte[] 类型的参数
    public void setPictureContent(byte[] pictureContent) {
        this.pictureContent = new String(pictureContent);
    }
}

