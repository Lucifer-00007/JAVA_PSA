package com.example.blogger;

import java.util.Comparator;

public class MovieComparator implements Comparator<MovieComparable> {

    @Override
    public int compare(MovieComparable o1, MovieComparable o2) {
        return o1.getYear()- o2.getYear();
    }
}
