package com.stefan.array.practice20220519;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  59. 螺旋矩阵 II
 *
 *  给你一个正整数n ，生成一个包含 1 到n*n所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 */
public class Matrix2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数:");
        int n = scanner.nextInt();
        int[][] matrix = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int loop = n / 2;

        // 定义每次循环起始量
        int startX = 0;
        int startY = 0;

        int count = 1;

        int mid = n / 2;

        while (loop > 0) {

            int i = startX;
            int j = startY;

            // 从左到右
            for (; i < n - startX - 1; i++) {
                matrix[j][i] = count++;
            }

            // 从上到下
            for (; j < n - startY - 1; j++) {
                matrix[j][i] = count++;
            }

            // 从右到左
            for (; i > startX; i--) {
                matrix[j][i] = count++;
            }

            // 从下到上
            for (; j > startY; j--) {
                matrix[j][i] = count++;
            }

            startX++;
            startY++;

            loop--;
        }

        if (n % 2 == 1) {
            matrix[mid][mid] = count;
        }

        return matrix;
    }
}
