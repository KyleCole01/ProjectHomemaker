package com.example.projecthomemaker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static android.os.Environment.DIRECTORY_DCIM;

public class AddRecipeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText etName, etStarRating, etCostRating, etFeeds,  etIngredientList, etDirections;
    String name,category,ingredientList,directions,starRating, costRating, feeds;
    Button saveButton;
    Context context;
    public Snackbar snackbar;

    Spinner categorySpinner;
    Recipe savedRecipe;
    private static final int SELECT_PICTURE = 1;
    //getting image to set as the imageview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        etName = findViewById(R.id.et_name);
        etStarRating = findViewById(R.id.et_star_rating);
        etCostRating = findViewById(R.id.et_cost_rating);
        etFeeds = findViewById(R.id.et_feeds);
        categorySpinner = findViewById(R.id.et_category);
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
            etIngredientList.setText(editRecipe.getIngredientList());
            etDirections.setText(editRecipe.getDirections());

        }


        //spinner code
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,R.array.category,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setOnItemSelectedListener(this);
        categorySpinner.setAdapter(adapter);






        //saving recipe as whatever inherited type it is
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                checkRecipe();

                name = etName.getText().toString();
                ingredientList = etIngredientList.getText().toString();
                directions = etDirections.getText().toString();
                starRating = etStarRating.getText().toString();
                costRating = etCostRating.getText().toString();
                feeds = etFeeds.getText().toString();

                switch (category){
                    case "Breakfast":
                       savedRecipe = new BreakfastRecipe(name,category,starRating,feeds,costRating,
                                ingredientList,directions);
                        break;
                    case "Lunch":
                        savedRecipe = new LunchRecipe(name,category,starRating,feeds,costRating,
                                ingredientList,directions);
                        break;
                    case "Dinner":
                        savedRecipe = new DinnerRecipe(name,category,starRating,feeds,costRating,
                                ingredientList,directions);
                        break;
                    case "Appetizer":
                        savedRecipe = new AppetizerRecipe(name,category,starRating,feeds,costRating,
                                ingredientList,directions);
                        break;
                    case "Dessert":
                        savedRecipe = new DessertRecipe(name,category,starRating,feeds,costRating,
                                ingredientList,directions);
                        break;
                    default:
                        savedRecipe = new Recipe(name,category,starRating,feeds,costRating,
                                ingredientList,directions);
                        break;



                }
                RecipeDbDao.createRecipe(savedRecipe);
                Intent recipeListIntent = new Intent(context,RecipeListActivity.class);
                startActivity(recipeListIntent);
//                 public Recipe(String name, String category, int starRating, int feedPerBatch, int costRating, String ingredientList, String directions)


            }
        });

    }

    private void checkRecipe() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //TODO: CHECK for valid recipe

                //TODO: SHOW SNACKBAR


            }
        },2000);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        category = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
