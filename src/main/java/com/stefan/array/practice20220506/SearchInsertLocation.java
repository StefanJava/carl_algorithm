package com.stefan.array.practice20220506;

/**
 * 35.给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsertLocation {
    public static void main(String[] args) {
        int[] arr = {1, 3};
        int target = 2;
        System.out.println(search(arr, target));
    }

    private static int search(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        if (target < arr[left]) {
            return 0;
        }

        if (target > arr[right]) {
            return right + 1;
        }

        while (left <= right) {

            int middle = (left + right) / 2;

            if (arr[middle] == target) {
                return middle;
            } else if (target < arr[middle]) {
                if (arr[middle - 1] < target) {
                    return middle;
                }
                right = middle - 1;
            } else {
                if (arr[middle + 1] > target) {
                    return middle + 1;
                }
                left = middle + 1;
            }

        }

        return right + 1;
    }
}
