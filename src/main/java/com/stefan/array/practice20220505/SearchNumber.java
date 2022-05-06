package com.stefan.array.practice20220505;

public class SearchNumber {
    public static void main(String[] args) {
        int[] arr = {-100, -99, -10, -1, 0, 1, 10, 21, 32, 99, 100};
        int target = -99;

        int length = arr.length;
        int left = 0;
        int right = length - 1;

        if (target < arr[0] || target > arr[length - 1]) {
            System.out.println(-1);
            return;
        }
        int index = search(arr, target, left, right);
        System.out.println(index);
    }

    private static int search(int[] arr, int target, int left, int right) {

        if (left == right - 1) {
            return -1;
        }

        int middle = (left + right) / 2;

        if (target > arr[middle]) {
            left = middle;
        } else if (target < arr[middle]){
            right = middle;
        } else {
            return middle;
        }
        return search(arr, target, left, right);
    }
}
