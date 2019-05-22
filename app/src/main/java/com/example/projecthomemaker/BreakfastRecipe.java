package com.example.projecthomemaker;

import android.net.Uri;

public class BreakfastRecipe extends Recipe {
    String breakfastDrink;
    public BreakfastRecipe(String name, String category, String starRating, String feedPerBatch, String costRating, String ingredientList, String directions) {
        super(name, category, starRating, feedPerBatch, costRating, ingredientList, directions);
    }

    public String getBreakfastDrink() {
        return breakfastDrink;
    }

    public void setBreakfastDrink(String breakfastDrink) {
        this.breakfastDrink = breakfastDrink;
    }
}
