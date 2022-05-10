package com.stefan.array.practice20220510;

import java.util.Arrays;

public class MoveZeroErrorVersion {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 4, 0, 0, 6};
        moveZero(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZero(int[] nums) {
        int fastIndex;
        int slowIndex = 0;
        for (fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex++] = nums[fastIndex];
                nums[fastIndex] = 0;
            }
        }
    }
}
