package com.example.projecthomemaker;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class OnlineRecipeSearch {
    private static final String BASE_URL = "https://www.food2fork.com/api/search?";
//    private static final String API_KEY = "key=3562a08f27bdf4d5e74e809b98c308bc";
    private static final String API_KEY = "key=13e5260b8975c0207d4f7f70a2911c92";
    private static final String SEARCH_PARAM = "&q=";
    private static final String SEARCH_RECIPE = BASE_URL+API_KEY+SEARCH_PARAM;
    private static final String JPG = ".jpg";
    private static final String JSON = ".json";

    public static ArrayList<Recipe> searchRecipes(String searchParam){

        ArrayList<Recipe> onlineRecipeList = new ArrayList<>();
        searchParam = searchParam.replace(" ","%20");

            try{
                String result = NetworkAdapter.httpRequest(SEARCH_RECIPE+searchParam);
                JSONObject dataObject = new JSONObject(result);
                JSONArray dataJsonArray = dataObject.getJSONArray("recipes");
                for(int i = 0;i <dataJsonArray.length();++i){
                    JSONObject recipeObject = dataJsonArray.getJSONObject(i);
                    InputStream URLcontent = (InputStream) new URL(recipeObject.getString("image_url")).getContent();
                    Drawable image = Drawable.createFromStream(URLcontent,recipeObject.getString("image_url"));
                    Recipe recipe = new Recipe(recipeObject);
                    recipe.setImageDrawable(image);


                    onlineRecipeList.add(recipe);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return  onlineRecipeList;
    }

}
