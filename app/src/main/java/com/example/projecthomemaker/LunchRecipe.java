package com.example.projecthomemaker;

public class LunchRecipe extends Recipe {
    String prepTime;
    public LunchRecipe(String name, String category, String starRating, String feedPerBatch, String costRating, String ingredientList, String directions) {
        super(name, category, starRating, feedPerBatch, costRating, ingredientList, directions);
    }
    public String getPrepTime() {
        return prepTime;
    }
    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }
}
