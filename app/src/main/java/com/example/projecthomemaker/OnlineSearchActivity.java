package com.example.projecthomemaker;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class OnlineSearchActivity extends AppCompatActivity {
    EditText searchText;
    Button searchButton;
    ListAdapter searchListAdapter;
    ArrayList<Recipe> onlineRecipes;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_search);
        searchText = findViewById(R.id.online_search_edit_text);
        searchButton = findViewById(R.id.online_search_button);
        context = this;
        //click search and return an arraylist of results

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        onlineRecipes = OnlineRecipeSearch.searchRecipes(searchText.getText().toString());
                        for(int i = 0; i <onlineRecipes.size();++i){
                            Recipe temp = onlineRecipes.get(i);
                            Bitmap tempmap = NetworkAdapter.getBitmapFromURL(temp.getImageUrl());
                            temp.setImageBitmap(tempmap);
                        }
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               searchListAdapter = new ListAdapter(onlineRecipes);
                               RecyclerView recyclerView = findViewById(R.id.online_search_recycler_view);
                               recyclerView.setAdapter(searchListAdapter);
                               LinearLayoutManager sampleLayoutManager = new LinearLayoutManager(context);
                               recyclerView.setLayoutManager(sampleLayoutManager);
                           }
                       });

                    }
                }).start();

            }
        });






    }
}
