package com.chalim.backend.dto;

public class TranslateRequest {
    private String text;

    // 기본 생성자
    public TranslateRequest() {}

    // text 필드에 대한 getter 메소드
    public String getText() {
        return text;
    }

    // text 필드에 대한 setter 메소드
    public void setText(String text) {
        this.text = text;
    }
}

