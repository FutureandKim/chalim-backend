package com.chalim.backend.dto;

public class TranslateRequest {
    private String text;

    // 기본 생성자
    public TranslateRequest() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

