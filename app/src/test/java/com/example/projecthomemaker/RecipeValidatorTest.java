package com.example.projecthomemaker;

import com.example.projecthomemaker.util.RecipeValidator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecipeValidatorTest {
//check recipe name
    @Test
    public void recipeNameValidator_hasNumbersInName_ReturnsTrue(){
        assertTrue(RecipeValidator.isValidRecipeName("beef1"));
    }
    @Test
    public void recipeNameValidator_EmptyString_Returns_False(){
        assertFalse(RecipeValidator.isValidRecipeName(""));
    }
    @Test
    public void recipeNameValidator_HasUsableCharacters_ReturnsTrue(){
        assertTrue(RecipeValidator.isValidRecipeName("beef%wellington_32"));
    }
    @Test
    public void recipeNameValidator_allowsSpaces_ReturnsTrue(){
        assertTrue(RecipeValidator.isValidRecipeName("My apple Pie"));
    }
    @Test
    public void recipeNameValidator_allowsSpacesAndUsableCharacters_ReturnsTrue(){
        assertTrue(RecipeValidator.isValidRecipeName("My apple Pie %3 + 29"));
    }
    @Test
    public void recipeNameValidator_NullValue_ReturnsFalse(){
        assertFalse(RecipeValidator.isValidRecipeName(null));
    }


    //checking ingredient list
    @Test
    public void recipeIngredientListValidator_hasNumbersInName_ReturnsTrue(){
        assertTrue(RecipeValidator.isValidRecipeIngredientList("beef1987"));
    }
    @Test
    public void recipeIngredientListValidator_EmptyString_Returns_False(){
        assertFalse(RecipeValidator.isValidRecipeIngredientList(""));
    }
    @Test
    public void recipeIngredientListValidator_HasUsableCharacters_ReturnsTrue(){
        assertTrue(RecipeValidator.isValidRecipeIngredientList("beef%wellington_32"));
    }
    @Test
    public void recipeIngredientListValidator_allowsSpaces_ReturnsTrue(){
        assertTrue(RecipeValidator.isValidRecipeIngredientList("My apple Pie"));
    }
    @Test
    public void recipeIngredientListValidator_allowsSpacesAndUsableCharacters_ReturnsTrue(){
        assertTrue(RecipeValidator.isValidRecipeIngredientList("My apple Pie %3 + 29"));
    }
    @Test
    public void recipeIngredientListValidator_NullValue_ReturnsFalse(){
        assertFalse(RecipeValidator.isValidRecipeIngredientList(null));
    }
    @Test
    public void recipeIngredientListValidator_MultipleLines_ReturnsFalse(){
        assertFalse(RecipeValidator.isValidRecipeIngredientList("milk\neggs\ncheese"));

    }

}
