package com.example.blogger;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainUtil {
    public static void main(String[] args) {
//        Predicate<Integer> condition = y->y>0;
//        boolean val = condition.test(100);
//        System.out.println(val);

        List<Integer> data = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        List<Integer> newData = data.stream().filter(x -> x>20).collect(Collectors.toList());
        System.out.println(newData); //[30, 40, 50, 60, 70, 80, 90, 100]
    }

}
