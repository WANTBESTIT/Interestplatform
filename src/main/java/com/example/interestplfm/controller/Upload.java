package com.example.interestplfm.controller;

import com.example.interestplfm.service.UploadService;
import com.example.interestplfm.service.UserService;
import com.example.interestplfm.tools.RestResult;
import com.example.interestplfm.vo.FileSaveDTO;
import com.example.interestplfm.vo.PictureVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/upload")
public class Upload {
    @Autowired
    private UploadService uploadService;

    /**
     * 头像上传
     */
    @PostMapping("/avatar")
    public RestResult<Boolean> avatar(@RequestBody @RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        if (!file.isEmpty()) {
            Boolean b = uploadService.avatarUpload(file, request);
            if (Boolean.TRUE.equals(b)) {
                return RestResult.build(true);
            }
        }
        throw new Exception("头像上传失败");
    }
}
