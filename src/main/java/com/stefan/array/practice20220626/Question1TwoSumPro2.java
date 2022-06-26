package com.stefan.array.practice20220626;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class Question1TwoSumPro2 {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // if target - element of nums array exist in nums array and this element can not be itself
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                break;
            }
            map.put(target - nums[i], i);
        }

        return result;
    }
}
