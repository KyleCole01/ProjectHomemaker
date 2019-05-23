package com.example.projecthomemaker;

import java.util.Comparator;

public class CostRatingComparator implements Comparator<Recipe> {
    @Override
    public int compare(Recipe o1, Recipe o2) {
        int first = Integer.parseInt(o1.getCostRating());
        int second = Integer.parseInt(o2.getCostRating());
        return Integer.compare(first,second);

    }
}
