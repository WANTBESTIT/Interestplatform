package com.example.interestplfm.vo;

import lombok.Data;

@Data
public class FileSaveDTO {
    private String actualName = "";/*文件名字*/
    private String saveName = "";/*保存在本地时文件名*/
    private Boolean isImage = false;/*是否是图片文件*/

    public FileSaveDTO() {
    }

    public FileSaveDTO(String actualName, String saveName, Boolean isImage) {
        this.actualName = actualName;
        this.saveName = saveName;
        this.isImage = isImage;
    }
}
