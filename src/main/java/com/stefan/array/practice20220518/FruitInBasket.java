package com.stefan.array.practice20220518;

import java.util.HashMap;
import java.util.Map;

public class FruitInBasket {
    public static void main(String[] args) {
        int[] fruits = {0, 1, 6, 6, 4, 4, 6};
        int result = pick(fruits);
        System.out.println(result);
    }

    private static int pick(int[] fruits) {

        if (fruits == null) {
            return 0;
        }

        if (fruits.length < 2) {
            return fruits.length;
        }

        int j = 0;
        int sum = 0;
        int i;
        Map<Integer, Integer> basket = new HashMap<>();
        for (i = 0; i < fruits.length; i++) {

            basket.put(fruits[i], basket.getOrDefault(fruits[i], 0) + 1);
            while (basket.size() > 2) {
                basket.put(fruits[j], basket.get(fruits[j]) - 1);
                if (basket.get(fruits[j]) == 0) {
                    basket.remove(fruits[j]);
                }
                j++;
            }
            sum = Math.max(sum, i - j + 1);
        }

        return sum;
    }

}
