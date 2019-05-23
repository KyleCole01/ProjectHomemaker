package com.example.projecthomemaker;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Recipe> {
    @Override
    public int compare(Recipe o1, Recipe o2) {
        return o1.getCategory().compareTo(o2.getCategory());

    }


}
