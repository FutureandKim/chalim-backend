package com.chalim.backend.dto.translate;


import java.util.List;

public class ResponseDto {
    private String imageName;
    private List<TextData> translatedTxt;

    // Constructor, getters, and setters
    public ResponseDto(String imageName, List<TextData> translatedTxt) {
        this.imageName = imageName;
        this.translatedTxt = translatedTxt;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<TextData> getTranslatedTxt() {
        return translatedTxt;
    }

    public void setTranslatedTxt(List<TextData> translatedTxt) {
        this.translatedTxt = translatedTxt;
    }
}

