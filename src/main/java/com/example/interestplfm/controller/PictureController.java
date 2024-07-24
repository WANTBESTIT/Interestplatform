package com.example.interestplfm.controller;

import com.example.interestplfm.entity.Picture;
import com.example.interestplfm.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @CrossOrigin(origins = "http://localhost:8080") // 允许 Vue.js 前端端口 8080 的跨域请求
    @PostMapping("/upload")
    public Picture uploadPicture(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("文件为空");
        }

        // 生成唯一的文件名
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // 将图片的二进制数据存储到数据库中
        Picture picture = new Picture();
        picture.setUploadTime(LocalDateTime.now());
        picture.setPictureContent(file.getBytes());
        pictureService.createPicture(picture);

        return picture;
    }
}