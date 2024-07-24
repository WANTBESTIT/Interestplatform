package com.example.interestplfm.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.interestplfm.entity.User;
import com.example.interestplfm.mapper.UserMapper;
import com.example.interestplfm.repository.UserRepository;
import com.example.interestplfm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 *  userService实现类
 *
 * @author xhb
 * @since 2024/07/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * 更新用户头像
     *
     * @param userid 用户id
     * @param headPortrait 头像
     * @return boolean
     */
    @Override
    public boolean updateAvatar(Long userid, String headPortrait) {

        return userRepository.updateAvatar(userid, headPortrait) == 1;
    }


    /**
     * 根据用户id查找用户信息
     *
     * @param userId 用户id
     * @return User
     */
    @Override
    public User selectByUserId(Long userId) {
        return userRepository.selectByUserId(userId);
    }

    /**
     * 功能描述： 查找所有用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return User
     * @author xhb
     * @since 2024/07/23
     */
    @Override
    public User verifyPassword(String username, String password)  {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        String hashedPassword = hashPassword(password, user.getSalt());
        if (hashedPassword.equals(user.getPasswordHash())) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 功能描述： 注册用户
     *
     * @param username 用户名
     * @param password 密码
     * @return boolean
     * @author xhb
     * @since 2024/07/23
     */
    @Override
    public boolean registerUser(String username, String password) {
        User existuser = userRepository.findByUsername(username);
        if (existuser != null) {
            return false;
        }
        User user = new User();
        user.setUsername(username);
        // 设置盐值
        user.setUserid(IdWorker.getId());
        user.setUsername(username);
        String salt = generateSalt();
        user.setSalt(salt);
        user.setPasswordHash(hashPassword(password, salt));
        user.setPassword(password);
        Random random = new Random();
        user.setName("用户" + random.nextInt(100000));
        user.setRegisterTime(new Date());
        userRepository.save(user);
        return true;
    }

    /**
     * 功能描述：设置盐值
     *
     * @return {@code String }
     * @author xhb
     * @since 2024/07/23
     */
    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * 功能描述：使用MD5算法加密密码
     *
     * @param password 密码
     * @param salt 盐值
     * @return {@code String }
     * @author xhb
     * @since 2024/07/23
     */
    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(Base64.getDecoder().decode(salt));
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}
