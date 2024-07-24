package com.example.interestplfm.entity;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data

public class Blog {
    private Long blogId;
    private Long userId;
    private Long flavorId;
    private Integer thumbsNumber;
    private Integer commentNumber;
    private LocalDateTime issueTime;
    private String blogContent;
    private String blogStatus;

    // Getters and Setters
}
