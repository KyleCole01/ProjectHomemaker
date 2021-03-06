package com.example.projecthomemaker;

import android.graphics.Bitmap;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;

public class Recipe implements Serializable, Comparable,JSONable {
    private int id;
    private String name, directions, ingredientList,category, favorite,starRating, costRating, feedPerBatch;
    private String imageUrl, sourceUrl;
    private Bitmap recipeImage;
    public String getFavorite() {
        return favorite;
    }
    public Recipe (String name){
        this.name = name;
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

    public Recipe(JSONObject json){
        try{
            this.name = json.getString("title");
            this.sourceUrl = json.getString("source_url");
            this.imageUrl = json.getString("image_url");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(Bitmap recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
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

    @Override
    public int compareTo(Object o) {
        if(o instanceof Recipe){
            Recipe object = (Recipe) o;
            //sort by name (default sort if no specific comparator used)
            return this.getName().compareTo(object.getName());
        } else{
            return 0;
        }
    }

    //must be implemented due to the interface (will be utilizing with a future implication)
    @Override
    public String toJsonString() {
        try {
            JSONObject json = new JSONObject();
            json.put("name", this.name);
            json.put("source_url", this.sourceUrl);
            json.put("image_url", imageUrl);
            return json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
