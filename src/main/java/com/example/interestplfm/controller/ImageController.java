package com.example.interestplfm.controller;

import com.example.interestplfm.entity.User;
import com.example.interestplfm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class ImageController {
    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "http://localhost:8080") // 允许 Vue.js 前端端口 8080 的跨域请求
    @GetMapping("/image")
    public void getImage(@RequestParam("userId") Long userId, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("image/jpeg");
         User user=userService.selectByUserId(userId);
        // 这里使用文件路径作为示例，实际项目中可能需要从数据库或文件系统中获取图片
        String imagePath = user.getHeadPortrait();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(imagePath));
             OutputStream out = response.getOutputStream()) {

            byte[] buf = new byte[1024];
            int bytesRead;

            // 读取图片文件，并写入响应输出流
            while ((bytesRead = in.read(buf)) != -1) {
                out.write(buf, 0, bytesRead);
            }
        }
    }
}
