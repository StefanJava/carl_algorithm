package com.stefan.array.practice20220520;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixError {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
        int[][] matrix = {{6, 9, 7}};
        List<Integer> lists = traverseMatrix(matrix);
        System.out.println(lists);
    }

    private static List<Integer> traverseMatrix(int[][] matrix) {

        List<Integer> nums = new ArrayList<>();

        int column = matrix[0].length;
        int row = matrix.length;

        if (column == 1) {
            for (int i = 0; i < row; i++) {
                nums.add(matrix[i][0]);
            }
            return nums;
        }

        if (row == 1) {
            for (int i = 0; i < column; i++) {
                nums.add(matrix[0][i]);
            }
            return nums;
        }

        // 矩阵元素总个数
        int total = row * column;

        if (matrix == null) {
            return nums;
        }

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
            for (; i < column - startX - 1; i++) {
                nums.add(matrix[j][i]);
                count++;
            }

            // 从上到下
            for (; j < row - startY - 1; j++) {
                nums.add(matrix[j][i]);
                count++;
            }

            // 从右到左
            for (; i > startX; i--) {
                nums.add(matrix[j][i]);
                count++;
            }

            // 从下到上
            for (; j > startY; j--) {
                nums.add(matrix[j][i]);
                count++;
            }

            startX++;
            startY++;
        }

        if (column == row && column % 2 == 1) {
            nums.add(matrix[row / 2][column / 2]);
        }

        return nums;
    }
}
