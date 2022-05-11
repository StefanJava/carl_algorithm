package com.stefan.array.practice20220511;

import java.util.Arrays;

public class Question977 {
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] result = sortedArraySquare(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sortedArraySquare(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int count = nums.length;
        int[] newNums = new int[count];
        while (leftIndex <= rightIndex) {
            count--;
            if (nums[leftIndex] * nums[leftIndex] > nums[rightIndex] * nums[rightIndex]) {
                newNums[count] = nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            } else {
                newNums[count] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            }
        }
        return newNums;
    }
}
