package com.chalim.backend.dto.openAi;

public class MenuDetailsDto {
    private String explanation;
    private String history;
    private String ingredients;

    public MenuDetailsDto(String explanation, String history, String ingredients) {
        this.explanation = explanation;
        this.history = history;
        this.ingredients = ingredients;
    }

    // Getters and Setters
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
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
