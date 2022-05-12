package com.stefan.array.practice20220512;

/**
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class SubArrayPro2 {
    public static void main(String[] args) {
        int[] nums = {7, 2, 3, 1, 2, 4, 3};
        int target = 7;
        int result = searchMinLenSubArray(nums, target);
        System.out.println(result);
    }

    private static int searchMinLenSubArray(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int fastIndex;
        int slowIndex = 0;
        int sum = 0;
        for (fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            sum += nums[fastIndex];
            while (sum >= target) {
                int count = fastIndex - slowIndex + 1;
                result = Math.min(result, count);
                sum -= nums[slowIndex++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
