package com.example.projecthomemaker;

import android.net.Uri;

public class DessertRecipe extends Recipe {
    String sweetness;


    public DessertRecipe(String name, String category, String starRating, String feedPerBatch, String costRating, String ingredientList, String directions) {
        super(name, category, starRating, feedPerBatch, costRating, ingredientList, directions);
    }
}
