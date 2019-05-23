package com.example.projecthomemaker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import java.net.URI;
import java.util.ArrayList;

import static android.os.Environment.DIRECTORY_DCIM;

public class AddRecipeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText etName, etStarRating, etCostRating, etFeeds,  etIngredientList, etDirections;
    String name,category,ingredientList,directions,starRating, costRating, feeds;
    Button saveButton;
    Context context;
    public Snackbar snackbar;
    Uri thumbnail;
    Bitmap bitmap;

    Spinner categorySpinner;
    Recipe savedRecipe;
    private static final int SELECT_PICTURE = 1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        etName = findViewById(R.id.et_name);
        imageView = findViewById(R.id.nr_imageview);
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
            imageView.setImageBitmap(loadImageBitmap(context,(editRecipe.getName()).replace(" ", "_"),".jpg"));

        }


        //spinner code
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,R.array.category,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setOnItemSelectedListener(this);
        categorySpinner.setAdapter(adapter);

        //imageview code
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getPic = new Intent(Intent.ACTION_GET_CONTENT);
                getPic.setType("image/*");
                startActivityForResult(getPic,SELECT_PICTURE);
            }
        });




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
                saveImage(context,bitmap,(etName.getText().toString()).replace(" ","_"),".jpg");
                RecipeDbDao.createRecipe(savedRecipe);

                Intent recipeListIntent = new Intent(context,RecipeListActivity.class);
                startActivity(recipeListIntent);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        category = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveImage(Context context, Bitmap bitmap, String name, String extension){
        name = name + "." + extension;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream= context.openFileOutput(name, Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90,fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Bitmap loadImageBitmap(Context context,String name,String extension){
        name = name + "." + extension;
        FileInputStream fileInputStream;
        Bitmap bitmap = null;
        try{
            fileInputStream = context.openFileInput(name);
            bitmap = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == SELECT_PICTURE && resultCode == RESULT_OK && data != null){
            thumbnail = data.getData();
            imageView.setImageURI(thumbnail);
            bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), thumbnail);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
