package com.stefan.array.practice20220514;

import java.util.Arrays;

public class NextArray {
    public static void main(String[] args) {
        String patternStr = "abaabe";
        int[] next = getNext(patternStr);
        System.out.println(Arrays.toString(next));
    }

    public static int[] getNext(String patternStr) {

        int[] next = new int[patternStr.length()];
        int j = 0;
        for (int i = 1; i < patternStr.length(); i++) {

            while (j >= 0 && patternStr.charAt(j) != patternStr.charAt(i)) {
                if (j == 0) {
                    next[i] = 0;
                    break;
                }
                j = next[j - 1];
            }

            if (patternStr.charAt(j) == patternStr.charAt(i)) {
                if (j == 0) {
                    next[i] = 1;
                } else {
                    next[i] = next[i - 1] + 1;
                }
                j++;
            }
        }

        return next;
    }
}
