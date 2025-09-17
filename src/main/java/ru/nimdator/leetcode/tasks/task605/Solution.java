package ru.nimdator.leetcode.tasks.task605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) return true;

        int count = 0;

        if (flowerbed.length == 1) return flowerbed[0] == 0 && n == 1;

        boolean prevIsEmpty = true;

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] != 0 || !prevIsEmpty || (i != flowerbed.length - 1 && flowerbed[i + 1] != 0)) {
                prevIsEmpty = flowerbed[i] == 0;
                continue;
            }

            if (flowerbed[i] == 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                count++;
                if (count >= n) return true;
                prevIsEmpty = false;
            }
        }

        return false;
    }
}
