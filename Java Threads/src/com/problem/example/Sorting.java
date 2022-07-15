package com.problem.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sorting {
    public static void main(String[] args) {
        String[] arr = {"0","a","1", "c"};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);

        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 100);
        map.put("banana", 30);
        map.put("orange", 60);
        map.put("apple", 150);
        System.out.println("map.size() = " + map.size());
        System.out.println("map.size() = " + map.get("apple"));

        
    }
}

