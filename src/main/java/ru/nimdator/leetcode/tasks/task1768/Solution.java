package ru.nimdator.leetcode.tasks.task1768;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len = word1.length() + word2.length();
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i < word1.length()) sb.append(word1Chars[i]);
            if (i < word2.length()) sb.append(word2Chars[i]);
        }
        return sb.toString();
    }
}
