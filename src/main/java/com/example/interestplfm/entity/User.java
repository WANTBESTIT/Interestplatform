package com.example.interestplfm.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author xhb
 * @since 2024/07/23
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private String passwordHash;

    private String salt;
    /**
     * 自增主键
     */
    private Long userid;

    /**
     * 账号名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private int age;

    /**
     * 邮箱
     */
    private String mailbox;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String username;

    /**
     * 头像
     */
    private String headPortrait;

    /**
     * 注册时间
     */
    private Date registerTime;
    /**
     * introduce
     */
    private String introduce;

}

