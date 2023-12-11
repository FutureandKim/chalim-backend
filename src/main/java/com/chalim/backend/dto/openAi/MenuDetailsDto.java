package com.chalim.backend.dto.openAi;

public class MenuDetailsDto {
    private String description;
    private String history;
    private String ingredients;

    public MenuDetailsDto(String description, String history, String ingredients) {
        this.description = description;
        this.history = history;
        this.ingredients = ingredients;
    }

    // Getters and Setters
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
