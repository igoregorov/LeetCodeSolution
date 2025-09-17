package ru.nimdator.leetcode.tasks.task1431;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);
        int maxElement = candies[0];
        for (int candy : candies) {
            if (candy > maxElement) maxElement = candy;
        }

        maxElement -= extraCandies;

        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] >= maxElement);
        }
        return result;
    }

}
