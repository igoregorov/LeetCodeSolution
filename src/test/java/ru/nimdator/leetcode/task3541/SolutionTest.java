package ru.nimdator.leetcode.task3541;

import org.junit.jupiter.api.Test;
import ru.nimdator.leetcode.tasks.task3541.Solution;


import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void testMaxFreqSum_v3_CorrectCase() {
        Solution solution = new Solution();

        String input = "aaabbb";
        int expected = 6;

        int result = solution.maxFreqSum_v3(input);

        assertEquals(expected, result);
    }
}