package com.example.projecthomemaker.util;

import com.example.projecthomemaker.Recipe;

import java.util.regex.Pattern;

public class RecipeValidator {

    public static final Pattern USABLE_TEXT = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\ \\-\\+]{1,256}");

    public static boolean isValidRecipeName(CharSequence recipename){
        return recipename != null &&USABLE_TEXT.matcher(recipename).matches();
    }
    public static boolean isValidRecipeIngredientList(CharSequence recipeIngredient){
        return recipeIngredient != null && USABLE_TEXT.matcher(recipeIngredient).matches();

    }
}
