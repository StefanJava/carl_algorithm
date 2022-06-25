package com.stefan.array.practice20220625;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 202. 快乐数
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
public class Question202HappyNumber {
    public static void main(String[] args) {
        System.out.println("please input a Integer: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean result = isHappy(n);
        System.out.println(result);
    }

    private static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = rebuild(n);
        }

        return true;
    }

    private static int rebuild(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum = sum + tmp * tmp;
            n = n / 10;
        }
        return sum;
    }
}
