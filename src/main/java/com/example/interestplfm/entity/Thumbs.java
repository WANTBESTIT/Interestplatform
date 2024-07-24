package com.example.interestplfm.entity;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Thumbs implements Serializable {
    private Long thumbsId;
    private Long userId;
    private Long blogId;
    private LocalDateTime likeTime;

    // Getters and Setters
}
