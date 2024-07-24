package com.example.interestplfm.service;

import com.example.interestplfm.entity.Picture;
import com.example.interestplfm.mapper.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
    @Autowired
    private PictureMapper pictureMapper;

    public void createPicture(Picture picture) {
        pictureMapper.insertPicture(picture);
    }
}