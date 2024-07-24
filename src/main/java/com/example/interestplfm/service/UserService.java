package com.example.interestplfm.service;

import com.example.interestplfm.entity.User;

/**
 * 用户相关 业务服务层
 *
 * @author: interstplfm
 */
public interface UserService {

    /**
     * 更新用户头像
     *
     * @param userid      用户id
     * @param headPortrait 头像地址
     * @return boolean
     */
    boolean updateAvatar(Long userid, String headPortrait);

    /**
     * 根据用户id查找用户信息
     *
     * @param UserId 用户id
     * @return User
     */
    User selectByUserId(Long UserId);

    /**
     * 功能描述：登录：根据用户名和密码查询用户
     *
     * @param username  用户名
     * @param password  密码
     * @return User
     * @author xhb
     * @since 2024/07/23
     */
    User verifyPassword(String username, String password);

    /**
     * 功能描述：注册：创建新用户
     *
     * @param username 用户名
     * @param password 密码
     * @author xhb
     * @since 2024/07/23
     */
    boolean registerUser(String username, String password);
}

