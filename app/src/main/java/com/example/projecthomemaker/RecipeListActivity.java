package com.example.projecthomemaker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class RecipeListActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Context context;
    ArrayList<Recipe> recipeList;
    ListAdapter sampleListAdapter;
    public static final String TAG = "receive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        recipeList = RecipeDbDao.readAllRecipes();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        drawerLayout = findViewById(R.id.drawer_layout_view);
        toolbar.setTitle(getTitle());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //TODO 12.) Create new instance of your list adapter (ListAdapter here is the name of the class I made)
        sampleListAdapter = new ListAdapter(recipeList);

        //TODO 13.) Get a handle to your id for the recycler view.
        RecyclerView recyclerView = findViewById(R.id.recycler_view_layout);
        recyclerView.setAdapter(sampleListAdapter);
        LinearLayoutManager sampleLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(sampleLayoutManager);









        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newRecipeIntent = new Intent(context, AddRecipeActivity.class);
                startActivity(newRecipeIntent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

}
