package com.example.interestplfm.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
public class Take implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    private Long takeid;

    /**
     * 用户ID，外键指向User表
     */
    private Long userid;

    /**
     * 风味ID，外键指向Flavor表
     */
    private Long flavorid;

    /**
     * 订阅时间
     */
    private Date takeTime;

}
