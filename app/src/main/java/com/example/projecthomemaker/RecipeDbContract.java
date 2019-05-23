package com.example.projecthomemaker;

import android.provider.BaseColumns;

public class RecipeDbContract implements BaseColumns {
    public static class RecipeEntry implements BaseColumns {

        public final static String TABLE_NAME = "recipe_list";
        public final static String COLUMN_NAME = "recipe_name";
        public final static String COLUMN_CATEGORY = "recipe_category";
        public final static String COLUMN_STAR_RATING = "star_rating";
        public final static String COLUMN_FEED_PER_BATCH = "feed_per_batch";
        public final static String COLUMN_COST_RATING = "cost_rating";
        public final static String COLUMN_INGREDIENT_LIST = "ingredient_list";
        public final static String COLUMN_DIRECTIONS = "directions";
        public final static String COLUMN_FAVORITES = "favorite";
        public final static String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_STAR_RATING + " TEXT," +
                COLUMN_FEED_PER_BATCH + " TEXT, " +
                COLUMN_COST_RATING + " TEXT," +
                COLUMN_INGREDIENT_LIST + " TEXT, " +
                COLUMN_DIRECTIONS + " TEXT, " +
                COLUMN_FAVORITES + " TEXT); ";
        public final static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
    }
}
