package ru.nimdator.leetcode.tasks.task0966;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    static Stream<Arguments> spellcheckerTestData() {
        return Stream.of(
                Arguments.of(
                        new String[]{"KiTe", "kite", "hare", "Hare"},
                        new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"},
                        new String[]{"kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"}
                ),
                Arguments.of(
                        new String[]{"hello"},
                        new String[]{"hello", "HELLO", "Hello"},
                        new String[]{"hello", "hello", "hello"}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("spellcheckerTestData")
    void testSpellchecker(String[] wordlist, String[] queries, String[] expected) {
        Solution solution = new Solution();
        assertArrayEquals(expected, solution.spellchecker(wordlist, queries));
    }
}