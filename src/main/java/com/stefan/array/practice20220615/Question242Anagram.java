package com.stefan.array.practice20220615;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Question242Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
//        String s = "rat";
//        String t = "car";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    private static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // record each character times
        Map<Character, Integer> recordMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (recordMap.containsKey(c)) {
                recordMap.put(c, recordMap.get(c) + 1);
            } else {
                recordMap.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (recordMap.containsKey(c)) {
                Integer n = recordMap.get(c);
                if (n == 0) {
                    return false;
                } else {
                    recordMap.put(c, n - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
