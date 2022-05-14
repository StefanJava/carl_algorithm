package com.stefan.array.practice20220514;

public class KMP {
    public static void main(String[] args) {
        String mainStr = "ababcabcacbab";
        String patternStr = "";
        int[] next = NextArray.getNext(patternStr);
        int index = getKMPIndex(mainStr, patternStr, next);
        System.out.println(index);
    }

    private static int getKMPIndex(String mainStr, String patternStr, int[] next) {

        if (patternStr.length() == 0) {
            return -1;
        }

        int j = 0;
        for (int i = 0; i <= mainStr.length() - patternStr.length(); ) {

            if (mainStr.charAt(i + j) != patternStr.charAt(j)) {
                if (j > 0) {
                    i = i + j - next[j - 1];
                    j = next[j - 1];
                } else {
                    i++;
                }
            }

            if (mainStr.charAt(i + j) == patternStr.charAt(j)) {
                if (j == patternStr.length() - 1) {
                    return i;
                }
                j++;
            }

        }

        return -1;
    }
}
