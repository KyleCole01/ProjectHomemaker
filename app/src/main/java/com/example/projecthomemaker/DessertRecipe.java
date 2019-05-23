package com.example.projecthomemaker;

import android.net.Uri;

public class DessertRecipe extends Recipe {
    int sweetness;

    public DessertRecipe(String name, String category, String starRating, String feedPerBatch, String costRating, String ingredientList, String directions) {
        super(name, category, starRating, feedPerBatch, costRating, ingredientList, directions);
    }
    public int getSweetness() {
        return sweetness;
    }
    public void setSweetness(int sweetness) {
        this.sweetness = sweetness;
    }
}
