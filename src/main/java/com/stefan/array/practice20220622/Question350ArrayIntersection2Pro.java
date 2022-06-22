package com.stefan.array.practice20220622;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 *
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 */
public class Question350ArrayIntersection2Pro {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersectionArr = intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersectionArr));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums1) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        for (int v : nums2) {
            if (map.containsKey(v) && map.get(v) > 0) {
                result.add(v);
                map.put(v, map.get(v) - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
