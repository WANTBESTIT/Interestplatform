package com.example.interestplfm.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.interestplfm.entity.User;
import com.example.interestplfm.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户Repository
 *
 * @author xiaohongbin
 * @since 2024/07/23
 **/
@Repository
public class UserRepository extends ServiceImpl<UserMapper, User> {
    public int updateAvatar(Long userid, String headPortrait) {
        return lambdaUpdate().set(User::getHeadPortrait, headPortrait).eq(User::getUserid, userid).update() ? 1 : 0;
    }

    public User selectByUserId(Long userId) {
        return lambdaQuery().eq(User::getUserid, userId).one();
    }

    public User findByUsername(String username) {
        return lambdaQuery().eq(User::getUsername, username).one();
    }
}
