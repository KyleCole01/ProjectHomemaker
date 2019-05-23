package com.example.projecthomemaker;

import java.util.Comparator;

public class StarRatingComparator implements Comparator<Recipe> {
    @Override
    public int compare(Recipe o1, Recipe o2) {
        int first = Integer.parseInt(o1.getStarRating());
        int second = Integer.parseInt(o2.getStarRating());
        return Integer.compare(second,first);
    }
}
