package com.example.interestplfm.controller;

import com.example.interestplfm.annotation.TokenListener;
import com.example.interestplfm.config.JwtUtils;
import com.example.interestplfm.entity.User;
import com.example.interestplfm.service.UserService;
import com.example.interestplfm.tools.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户相关接口
 *
 * @author xhb
 * @since 2024/07/23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/register")
    public RestResult<String> register(@RequestParam String username, @RequestParam String password) {
        if (userService.registerUser(username, password)) {
            return RestResult.build("User registered successfully");
        } else {
            Map<String, Object> extension = new HashMap<>();
            extension.put("error", "User already exists");
            return RestResult.buildFailure(extension);
        }
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/login")
    public RestResult<String> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.verifyPassword(username, password);
        if (user != null) {
            String token = JwtUtils.generateToken(user.getUsername());
            return RestResult.build(token);
        } else {
            Map<String, Object> extension = new HashMap<>();
            extension.put("error", "Invalid username or password");
            return RestResult.buildFailure(extension);
        }
    }

    @CrossOrigin(origins = "http://localhost:8080") // 允许 Vue.js 前端端口 8080 的跨域请求
    @GetMapping("/getById")
    @TokenListener
    public RestResult<User> uploadPicture(@RequestParam("userId") Long userId) {

        return RestResult.build(userService.selectByUserId(userId));
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        // 清空当前用户的Token
        response.setHeader("Authorization", "");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
