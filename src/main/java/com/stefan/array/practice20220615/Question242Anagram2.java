package com.stefan.array.practice20220615;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question242Anagram2 {
    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";
        String s = "rat";
        String t = "car";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    private static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
}
