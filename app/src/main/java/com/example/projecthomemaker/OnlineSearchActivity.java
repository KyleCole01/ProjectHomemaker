package com.example.projecthomemaker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class OnlineSearchActivity extends AppCompatActivity {
    EditText searchText;
    Button searchButton;
    ArrayList<Recipe> onlineRecipes;
    Context context;
    LinearLayout recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_search);
        searchText = findViewById(R.id.online_search_edit_text);
        searchButton = findViewById(R.id.online_search_button);
        recipeList = findViewById(R.id.search_parent);
        context = this;

        //click search and return an arraylist of results (TEXTVIEW GENERATOR)
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        onlineRecipes = OnlineRecipeSearch.searchRecipes(searchText.getText().toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                for(int i = 0;i <onlineRecipes.size();i++){
                                    final TextView tv = new TextView(context);
                                    final Recipe recipe = onlineRecipes.get(i);
                                    tv.setTextSize(20);
                                    tv.setTextColor(getResources().getColor(android.R.color.black));
                                    String recipename = recipe.getName().replace("&#8217;","");
                                    tv.setText(recipename);
                                    tv.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            // what do you want to do with the view
                                            String url = recipe.getSourceUrl();
                                            Intent i = new Intent(Intent.ACTION_VIEW);
                                            i.setData(Uri.parse(url));
                                            startActivity(i);
                                        }
                                    });
                                    recipeList.addView(tv);
                                }
                            }
                        });
                    }
                }).start();
            }
        });
    }
}