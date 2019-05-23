package com.example.projecthomemaker;

public class AppetizerRecipe extends Recipe {
    int howFilling;

    public AppetizerRecipe(String name, String category, String starRating, String feedPerBatch, String costRating, String ingredientList, String directions) {
        super(name, category, starRating, feedPerBatch, costRating, ingredientList, directions);
    }

    public int getHowFilling() {
        return howFilling;
    }

    public void setHowFilling(int howFilling) {
        this.howFilling = howFilling;
    }
}
