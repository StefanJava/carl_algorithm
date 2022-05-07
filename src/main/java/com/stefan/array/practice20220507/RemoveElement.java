package com.stefan.array.practice20220507;

/**
 * 27.给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int index = removeElement(nums, val);
        System.out.println(index);
        for (int i = 0; i < index; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static int removeElement(int[] nums, int val) {

        int fastIndex;
        int slowIndex = 0;
        for (fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex ++;
            }
        }
        return slowIndex;
    }
}
