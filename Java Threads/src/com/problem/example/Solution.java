package com.problem.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String str = "Spring Boot Application";
        List<Character> chars = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        chars.add(' ');
        List<String> strs = new ArrayList<>();
        final String[] s = {""};
        chars.forEach(character -> {
            if (character != ' ') {
                s[0] += character.toString();
            } else {
                strs.add(s[0]);
                s[0] = "";
            }
        });
        int size = strs.size();
        while (size > 0) {
            System.out.print(strs.get(size - 1) + " ");
            size--;
        }
    }
}
