package com.example.interestplfm.service;

/**
 * @author xiaohongbin
 * @since 2024/07/23
 **/
public interface AccountService {
    void registerUser(String username, String password);

    boolean verifyPassword(String username, String password);
}
