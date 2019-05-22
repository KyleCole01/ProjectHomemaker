package com.example.projecthomemaker;

import android.net.Uri;

public class FavoriteRecipe extends Recipe {
    boolean isfavorite;
    public FavoriteRecipe(String name, String category, String starRating, String feedPerBatch, String costRating, String ingredientList, String directions) {
        super(name, category, starRating, feedPerBatch, costRating, ingredientList, directions);
    }

    public boolean isIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(boolean isfavorite) {
        this.isfavorite = isfavorite;
    }
}
