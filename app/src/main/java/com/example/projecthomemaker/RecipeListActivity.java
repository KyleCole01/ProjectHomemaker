package com.example.projecthomemaker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class RecipeListActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Context context;
    ArrayList<Recipe> recipeList;
    ListAdapter sampleListAdapter;
    public static final String TAG = "receive";
    ArrayList<Recipe> tempList;


    //initial Oncreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        recipeList = RecipeDbDao.readAllRecipes();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        tempList = new ArrayList<>();







/*
        //drawerLayout code for nav menu
        drawerLayout = findViewById(R.id.drawer_layout_view);
        toolbar.setTitle(getTitle());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/


        //list adapter code
        sampleListAdapter = new ListAdapter(recipeList);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_layout);
        recyclerView.setAdapter(sampleListAdapter);
        LinearLayoutManager sampleLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(sampleLayoutManager);

        //todo handle on item selected on nav menu (currently broken, will be implementing after grading due to amount of polish I want to do with it)
       /* final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                tempList = new ArrayList<>();
                switch(menuItem.getItemId()){


                    case R.id.nav_category_appetizer:
                        recipeList = RecipeDbDao.readAllRecipes();

                        for(Recipe item:recipeList){
                            if(item instanceof AppetizerRecipe){
                                tempList.add(item);
                            }

                        }
                        recipeList = tempList;
                        sampleListAdapter.notifyDataSetChanged();
                        navigationView.clearFocus();
                    break;

                    case R.id.nav_category_breakfast:
                        for(Recipe item:recipeList){
                            if(item instanceof BreakfastRecipe){
                                tempList.add(item);

                            }
                        }
                        recipeList = tempList;
                        sampleListAdapter.notifyDataSetChanged();

                        break;

                    case R.id.nav_category_dessert:
                        for(Recipe item:recipeList){
                            if(item.getCategory().equals("Dessert")){
                                tempList.add(item);
                                sampleListAdapter.notifyDataSetChanged();

                            }
                        }
                        break;
                    case R.id.nav_category_dinner:
                        for(Recipe item:recipeList){
                            if(item.getCategory().equals("Dinner")){
                                tempList.add(item);
                                sampleListAdapter.notifyDataSetChanged();

                            }
                        }
                        break;
                    case R.id.nav_category_general:
                        for(Recipe item:recipeList){
                                tempList.add(item);
                                sampleListAdapter.notifyDataSetChanged();

                        }
                        break;
                    case R.id.nav_category_lunch:

                        for(Recipe item:recipeList){
                            if(item.getCategory().equals("Lunch")){
                                tempList.add(item);
                                sampleListAdapter.notifyDataSetChanged();

                            }
                        }
                        break;
                }



                return true;
            }
        });





*/

        //add new recipe button code
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newRecipeIntent = new Intent(context, AddRecipeActivity.class);
                startActivity(newRecipeIntent);
            }
        });

    }
    //actionMenu code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId()) {
           case R.id.app_bar_search_online:
               // launch searching intent
               Intent onlineSearch = new Intent(context, OnlineSearchActivity.class);
               startActivity(onlineSearch);
               return true;
       }
        return super.onOptionsItemSelected(item);
    }
}
