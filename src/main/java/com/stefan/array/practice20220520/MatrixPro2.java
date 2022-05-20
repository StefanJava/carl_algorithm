package com.stefan.array.practice20220520;

import java.util.ArrayList;
import java.util.List;

public class MatrixPro2 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
//        int[][] matrix = {{6, 9, 7}};
//        int[][] matrix = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
        List<Integer> lists = traverseMatrix(matrix);
        System.out.println(lists);
    }

    private static List<Integer> traverseMatrix(int[][] matrix) {

        List<Integer> nums = new ArrayList<>();

        if (matrix == null) {
            return nums;
        }

        int column = matrix[0].length;
        int row = matrix.length;

        int left = 0, right = column - 1;
        int top = 0, down = row - 1;

        while (true) {

            for (int i = left; i <= right; i++) {
                nums.add(matrix[top][i]);
            }
            top++;
            if (top > down) break;
            for (int i = top; i <= down; i++) {
                nums.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            for (int i = right; i >= left; i--) {
                nums.add(matrix[down][i]);
            }
            down--;
            if (top > down) break;
            for (int i = down; i >= top; i--) {
                nums.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;

        }

        return nums;
    }
}
