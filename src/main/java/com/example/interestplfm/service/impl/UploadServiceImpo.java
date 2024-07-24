package com.example.interestplfm.service.impl;

import com.example.interestplfm.service.UploadService;
import com.example.interestplfm.service.UserService;
import com.example.interestplfm.tools.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * @author xiaohongbin
 * @since 2024/07/20
 **/
@Service
public class UploadServiceImpo implements UploadService {

    @Autowired
    private UserService userService;
    //头像上传路径
    @Value("${weibo.profile}")
    private String defaultBaseDir;

    @Override
    public Boolean avatarUpload(MultipartFile file, HttpServletRequest request) {
        //获取当前头像上传路径
        String avatar = defaultBaseDir;
        //获取当前用户id并且修改用户的头像地址

        // 文件名称 用户id
        // 获取文件的名称
        String originalFilename = file.getOriginalFilename();
        // 文件后缀 例如：.png
        assert originalFilename != null;
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // uuid 生成文件名
        String uuid = String.valueOf(UUID.randomUUID());
        // 根路径，
        String basePath = avatar + uuid;
        // 新的文件名，使用uuid生成文件名
        String fileName = uuid + fileSuffix;
        // 创建新的文件
        File fileExist = new File(basePath);
        // 文件夹不存在，则新建
        if (!fileExist.exists()) {
            fileExist.mkdirs();
        }
        // 获取文件对象
        File newfile = new File(basePath, fileName);
        try {
            // 完成文件的上传
            file.transferTo(newfile);
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败");
        }
        //判断文件是否上传成功并保存到数据库
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/image/" + uuid + "/" + fileName;
        return userService.updateAvatar(123L, url);
    }
}
