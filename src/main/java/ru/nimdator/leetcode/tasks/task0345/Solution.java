package ru.nimdator.leetcode.tasks.task0345;

public class Solution {
    private static boolean[] isVowel = new boolean[128];
    static {
        for (char c : new char[]{'a','e','i','o','u','A','E','I','O','U'}) {
            isVowel[c] = true;
        }
    }

    public String reverseVowels(String s) {
        char[] wordSeq = s.toCharArray();
        int i = 0, j = wordSeq.length - 1;
        while (i < j) {
            while (i < j && !isVowel[wordSeq[i]]) {
                i++;
            }
            while (i < j && !isVowel[wordSeq[j]]) {
                j--;
            }
            if (i < j) {
                char temp = wordSeq[i];
                wordSeq[i] = wordSeq[j];
                wordSeq[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(wordSeq);
    }
}