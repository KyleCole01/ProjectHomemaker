package com.example.projecthomemaker;

import android.content.Intent;
import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class AddRecipeActivityTest {

    private Recipe recipe;

    @Rule
    public ActivityTestRule<AddRecipeActivity> activityTestRule = new ActivityTestRule<>(AddRecipeActivity.class,false,false);

    @Before
    public void setUp(){
        Intent intent = new Intent();
        recipe = new Recipe("SampleTestRecipe","Breakfast","3","3","3","food","cook");
        intent.putExtra(RecipeListActivity.TAG,recipe);
        activityTestRule.launchActivity(intent);
    }
    @Test
    public void AddRecipeActivity_DisplayName_ReturnsTrue(){
        onView(withId(R.id.et_name)).check(matches(withText(recipe.getName())));
    }
    @Test
    public void AddRecipeActivity_DisplayCostRating_ReturnsTrue() {
        onView(withId(R.id.et_cost_rating)).check(matches(withText(recipe.getCostRating())));
    }
    @Test
    public void AddRecipeActivity_DisplayStarRating_ReturnsTrue() {
        onView(withId(R.id.et_star_rating)).check(matches(withText(recipe.getStarRating())));
    }
    @Test
    public void AddRecipeActivity_DisplayFeeds_ReturnsTrue() {
        onView(withId(R.id.et_feeds)).check(matches(withText(recipe.getFeedPerBatch())));
    }
    @Test
    public void AddRecipeActivity_DisplayIngredientList_ReturnsTrue() {
        onView(withId(R.id.et_ingredient_list)).check(matches(withText(recipe.getIngredientList())));
    }
    @Test
    public void AddRecipeActivity_Directions_ReturnsTrue() {
        onView(withId(R.id.et_directions)).check(matches(withText(recipe.getDirections())));
    }




}
