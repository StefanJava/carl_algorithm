package com.stefan.array.practice20220621;

import java.util.*;

/**
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class Question349ArrayIntersection {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersectionArr = intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersectionArr));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> result = new HashSet<>();

        Set<Integer> intersection = new HashSet<>();

        for (int i : nums1) {
            intersection.add(i);
        }

        for (int i : nums2) {
            if (intersection.contains(i)) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
