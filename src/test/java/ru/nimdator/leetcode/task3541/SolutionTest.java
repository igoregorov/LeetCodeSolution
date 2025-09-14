package ru.nimdator.leetcode.task3541;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testMaxFreqSum_v3_Error() {
        Solution solution = new Solution();

        // Тест, где vSum != правильный ответ
        String input = "abcabcabc";  // каждая буква встречается 3 раза
        int expected = 6;  // макс. гласная ('a') = 3 + макс. согласная ('b' или 'c') = 3

        int result = solution.maxFreqSum_v3(input);

        // Этот тест ПРОВАЛИТСЯ, потому что:
        // - метод вернет vSum = 9 (количество обновлений)
        // - а должен вернуть 6 (сумма максимальных частот)
        assertEquals(expected, result);  // FAIL: expected 6, but was 9
    }

    @Test
    public void testMaxFreqSum_v3_CorrectCase() {
        Solution solution = new Solution();

        // Тест, где случайно vSum = правильный ответ
        String input = "aaabbb";  // 'a' - 3 раза, 'b' - 3 раза
        int expected = 6;  // 3 + 3

        int result = solution.maxFreqSum_v3(input);

        // Этот тест ПРОЙДЕТ, потому что случайно vSum = 6
        assertEquals(expected, result);  // PASS: both are 6
    }
}