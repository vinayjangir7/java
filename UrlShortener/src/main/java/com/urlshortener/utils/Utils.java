package com.urlshortener.utils;

import java.util.*;

public class Utils {

    private static HashMap<Character, Integer> charToIndexTable;
    private static List<Character> indexToCharTable;

    public Utils() {
        initializeCharToIndexTableAndIndexToCharTable();
    }

    private void initializeCharToIndexTableAndIndexToCharTable() {
        charToIndexTable = new HashMap<>();
        indexToCharTable = new ArrayList<>();

        // 0->a, 1->b, ..., 25->z, ..., 52->0, 61->9

        for (int i = 0; i < 26; i++) {
            char c = 'a';
            c += i;
            charToIndexTable.put(c, i);
            indexToCharTable.add(c);
        }

        for (int i = 26; i < 52; i++) {
            char c = 'A';
            c += (i - 26);
            charToIndexTable.put(c, i);
            indexToCharTable.add(c);
        }

        for (int i = 52; i < 62; i++) {
            char c = '0';
            c += (i - 52);
            charToIndexTable.put(c, i);
            indexToCharTable.add(c);
        }
    }

    public String createUniqueId(Long id) {
        List<Integer> base62ID = convertBase10ToBase62Id(id);
        StringBuilder uniqueUrlId = new StringBuilder();
        for (int i : base62ID) {
            uniqueUrlId.append(indexToCharTable.get(i));
        }
        return uniqueUrlId.toString();
    }

    private List<Integer> convertBase10ToBase62Id(Long id) {
        List<Integer> digits = new LinkedList<>();
        while (id > 0) {
            int remainder = (int) (id % 62);
            digits.add(remainder);
            id /= 62;
        }
        Collections.reverse(digits);
        return digits;
    }

    public Long getUniqueIdFromString(String base62Id) {
        List<Character> base62Number = new ArrayList<>();
        for (int i = 0; i < base62Id.length(); i++) {
            base62Number.add(base62Id.charAt(i));
        }
        return convertBase62ToBase10(base62Number);
    }

    private Long convertBase62ToBase10(List<Character> base62Number) {
        long id = 0L;
        int exp = base62Number.size() - 1;
        for (int i = 0; i < base62Number.size(); i++, exp--) {
            int base10 = charToIndexTable.get(base62Number.get(i));
            id += base10 * Math.pow(62.0, exp);
        }
        return id;
    }
}
