package com.stefan.array.practice20220505;

public class SearchNumberPro1 {
    public static void main(String[] args) {
        int[] arr = {-100, -99, -10, -1, 0, 1, 10, 21, 32, 99, 100};
        int target = 11;

        int index = search(arr, target);
        System.out.println(index);
    }

    private static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if (target < arr[0] || target > arr[right]) {
            return -1;
        }
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == arr[middle]) {
                return middle;
            }
            if (target > arr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
