package com.stefan.array.practice20220615;

import java.util.Arrays;

public class Question242Anagram3 {
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

        int[] tables = new int[26];
        for (int i = 0; i < s.length(); i++) {
            tables[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (tables[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            tables[t.charAt(i) - 'a']--;
        }
        return true;
    }
}
