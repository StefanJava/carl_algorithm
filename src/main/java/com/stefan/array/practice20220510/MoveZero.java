package com.stefan.array.practice20220510;

import java.util.Arrays;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 */
public class MoveZero {
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
                int temp = nums[slowIndex];
                nums[slowIndex] = nums[fastIndex];
                nums[fastIndex] = temp;
                slowIndex++;
            }
        }
    }
}
