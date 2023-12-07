package com.chalim.backend.dto;

public class TranslateResponse {
    private String translatedText;

    // 생성자
    public TranslateResponse(String translatedText) {
        this.translatedText = translatedText;
    }

    // getter
    public String getTranslatedText() {
        return translatedText;
    }

}

