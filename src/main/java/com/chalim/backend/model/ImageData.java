package com.chalim.backend.model;

import org.springframework.web.multipart.MultipartFile;

public class ImageData {
    private String imageName;
    private MultipartFile imageFile; // 이미지 파일

    public ImageData() {
    }

    public ImageData(String imageName, MultipartFile imageFile) {
        this.imageName = imageName;
        this.imageFile = imageFile;
    }

    public String getImageName() {
        return imageName;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    // Setters
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}

