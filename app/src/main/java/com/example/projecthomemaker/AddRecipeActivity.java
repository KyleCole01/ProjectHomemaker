package com.example.projecthomemaker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRecipeActivity extends AppCompatActivity {
    EditText etName, etStarRating, etCostRating, etFeeds, etCategory, etIngredientList, etDirections;
    String name,category,ingredientList,directions,starRating, costRating, feeds;
    Button saveButton;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        etName = findViewById(R.id.et_name);
        etStarRating = findViewById(R.id.et_star_rating);
        etCostRating = findViewById(R.id.et_cost_rating);
        etFeeds = findViewById(R.id.et_feeds);
        etCategory = findViewById(R.id.et_category);
        etIngredientList = findViewById(R.id.et_ingredient_list);
        etDirections = findViewById(R.id.et_directions);
        saveButton = findViewById(R.id.nr_save_button);
        context = this;
        Intent receiveIntent = getIntent();
        if ((receiveIntent.getSerializableExtra(RecipeListActivity.TAG)!= null)){
            Recipe editRecipe = (Recipe) receiveIntent.getSerializableExtra(RecipeListActivity.TAG);
            etName.setText(editRecipe.getName());
            etStarRating.setText(editRecipe.getStarRating());
            etCostRating.setText(editRecipe.getStarRating());
            etFeeds.setText(editRecipe.getFeedPerBatch());
            etCategory.setText(editRecipe.getCategory());
            etIngredientList.setText(editRecipe.getIngredientList());
            etDirections.setText(editRecipe.getDirections());

        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                category = etCategory.getText().toString();
                ingredientList = etIngredientList.getText().toString();
                directions = etDirections.getText().toString();
                starRating = etStarRating.getText().toString();
                costRating = etCostRating.getText().toString();
                feeds = etFeeds.getText().toString();
                Recipe savedRecipe = new Recipe(name,category,starRating,feeds,costRating,
                        ingredientList,directions);
                RecipeDbDao.createRecipe(savedRecipe);
                Intent recipeListIntent = new Intent(context,RecipeListActivity.class);
                startActivity(recipeListIntent);
//                 public Recipe(String name, String category, int starRating, int feedPerBatch, int costRating, String ingredientList, String directions)


            }
        });

    }
}
