package com.stefan.array.practice20220520;

import java.util.ArrayList;
import java.util.List;

public class MatrixPro {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
//        int[][] matrix = {{6, 9, 7}};
        int[][] matrix = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
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

        // 矩阵元素总个数
        int total = row * column;

        int startX = 0;
        int startY = 0;

        int count = 0;

        if (column == row && column % 2 == 1) {
            count++;
        }

        while (count < total) {

            int i = startX;
            int j = startY;

            // 从左到右
            for (; i < column - startX - 1 && count < total; i++) {
                nums.add(matrix[j][i]);
                count++;
            }

            // 从上到下
            for (; j < row - startY - 1 && count < total; j++) {
                nums.add(matrix[j][i]);
                count++;
            }

            // 从右到左
            for (; i > startX && count < total; i--) {
                nums.add(matrix[j][i]);
                count++;
            }

            // 从下到上
            for (; j > startY && count < total; j--) {
                nums.add(matrix[j][i]);
                count++;
            }

            startX++;
            startY++;
        }

        if (column == row && column % 2 == 1) {
            nums.add(matrix[column / 2][row / 2]);
        }

        return nums;
    }
}
