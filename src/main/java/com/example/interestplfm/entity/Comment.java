package com.example.interestplfm.entity;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Comment implements Serializable {
    private Long commentId;
    private Long userId;
    private Long blogId;
    private Long parentId;
    private LocalDateTime commentTime;
    private String commentContent;

    // Getters and Setters
}