package com.example.projecthomemaker;

import java.io.Serializable;

public class Recipe implements Serializable {
    private int id;
    private String name, directions, ingredientList,category, favorite,starRating, costRating, feedPerBatch;

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public Recipe(String name, String category, String starRating, String feedPerBatch, String costRating, String ingredientList, String directions) {
        this.starRating = starRating;
        this.costRating = costRating;
        this.feedPerBatch = feedPerBatch;
        this.name = name;
        this.directions = directions;
        this.ingredientList = ingredientList;
        this.category = category;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getCostRating() {
        return costRating;
    }

    public void setCostRating(String costRating) {
        this.costRating = costRating;
    }

    public String getFeedPerBatch() {
        return feedPerBatch;
    }

    public void setFeedPerBatch(String feedPerBatch) {
        this.feedPerBatch = feedPerBatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(String ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
