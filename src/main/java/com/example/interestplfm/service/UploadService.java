package com.example.interestplfm.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaohongbin
 * @since 2024/07/20
 **/
public interface UploadService {
    Boolean avatarUpload(MultipartFile file, HttpServletRequest request);
}
