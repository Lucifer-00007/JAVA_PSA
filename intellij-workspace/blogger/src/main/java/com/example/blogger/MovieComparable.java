package com.example.blogger;

public class MovieComparable implements Comparable<MovieComparable>{
    private String name;
    private int rating;
    private int year;

    public MovieComparable(String name, int rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(MovieComparable o) {
        //return this.year-o.year;
        return this.name.compareTo(o.name);
    }
}
