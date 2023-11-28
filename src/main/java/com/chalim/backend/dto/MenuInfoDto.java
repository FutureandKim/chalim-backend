package com.chalim.backend.dto;


public class MenuInfoDto {
    private String description;
    private String history;
    private String ingredients;

    // 생성자
    public MenuInfoDto(String description, String history, String ingredients) {
        this.description = description;
        this.history = history;
        this.ingredients = ingredients;
    }

    // 게터와 세터
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}


