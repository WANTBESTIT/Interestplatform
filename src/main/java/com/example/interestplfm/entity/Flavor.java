package com.example.interestplfm.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Flavor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    private Long flavorid;

    /**
     * 名字
     */
    private String sort;

    /**
     * 微博数量，统计用
     */
    private Integer blogNumber;

    /**
     * 订阅数量，统计用
     */
    private Integer takeNumber;

    /**
     * 详情
     */
    private String content;

}
