package com.example.projecthomemaker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class OnlineRecipeSearch {
    private static final String BASE_URL = "https://www.food2fork.com/api/search?";
    private static final String API_KEY = "key=3562a08f27bdf4d5e74e809b98c308bc";
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
                    Recipe recipe = new Recipe(dataJsonArray.getJSONObject(i));

                    onlineRecipeList.add(recipe);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        return  onlineRecipeList;
    }

}
