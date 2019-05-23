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
    Intent navIntent;

    //initial onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        recipeList = RecipeDbDao.readAllRecipes();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        tempList = new ArrayList<>();

        //drawerLayout code for nav menu
        drawerLayout = findViewById(R.id.drawer_layout_view);
        toolbar.setTitle(getTitle());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawerLayout, toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //list adapter code
        sampleListAdapter = new ListAdapter(recipeList);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_layout);
        recyclerView.setAdapter(sampleListAdapter);
        final LinearLayoutManager sampleLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(sampleLayoutManager);

       //navigation menu : will navigate to any page in the app
        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId()) {
                    case R.id.nav_add_recipe:
                        navIntent = new Intent(context, AddRecipeActivity.class);
                        break;

                    case R.id.nav_main:
                        navIntent = new Intent(context, MainActivity.class);
                        break;

                    case R.id.nav_online_search:
                        navIntent = new Intent(context, OnlineSearchActivity.class);
                        break;
                    case R.id.nav_recipe_list:
                        navIntent = new Intent(context, RecipeListActivity.class);
                        break;
                }
                drawerLayout.closeDrawers();
                startActivity(navIntent);
                return true;
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
           case R.id.app_bar_sort_category:
               recipeList.sort(new CategoryComparator());
               sampleListAdapter.notifyDataSetChanged();
               break;
           case R.id.app_bar_sort_cost:
               recipeList.sort(new CostRatingComparator());
               sampleListAdapter.notifyDataSetChanged();
               break;
           case R.id.app_bar_sort_name:
               recipeList.sort(new NameComparator());
               sampleListAdapter.notifyDataSetChanged();
               break;
           case R.id.app_bar_sort_star:
               recipeList.sort(new StarRatingComparator());
               sampleListAdapter.notifyDataSetChanged();
               break;
       }
        return super.onOptionsItemSelected(item);
    }
}