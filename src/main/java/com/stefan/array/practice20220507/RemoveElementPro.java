package com.stefan.array.practice20220507;

public class RemoveElementPro {
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

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            if (val == nums[leftIndex]) {
                nums[leftIndex] = nums[rightIndex];
                rightIndex --;
            } else {
                leftIndex ++;
            }

        }
        return leftIndex;
    }
}
