package com.chalim.backend.dto.translate;

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

