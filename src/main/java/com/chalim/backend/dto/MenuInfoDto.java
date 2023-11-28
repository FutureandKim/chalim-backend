package com.chalim.backend.dto;


public class MenuInfoDto {
    private String description;
    private String history;
    private String ingredients;

    // 기본 생성자
    public MenuInfoDto() {
    }

    // 모든 필드를 포함하는 생성자
    public MenuInfoDto(String description, String history, String ingredients) {
        this.description = description;
        this.history = history;
        this.ingredients = ingredients;
    }

    // description에 대한 게터
    public String getDescription() {
        return description;
    }

    // description에 대한 세터
    public void setDescription(String description) {
        this.description = description;
    }

    // history에 대한 게터
    public String getHistory() {
        return history;
    }

    // history에 대한 세터
    public void setHistory(String history) {
        this.history = history;
    }

    // ingredients에 대한 게터
    public String getIngredients() {
        return ingredients;
    }

    // ingredients에 대한 세터
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}


