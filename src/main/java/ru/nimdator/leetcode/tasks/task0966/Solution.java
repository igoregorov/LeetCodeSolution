package ru.nimdator.leetcode.tasks.task0966;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        List<String> result = new ArrayList<>();
        List<String> words = List.of(wordlist);
        int i = 0;
        for (String query : queries) {
            System.out.println("index " + i + "query " + query);
            result.add(checkWord(words, query));
            i++;
        }
        System.out.println(" result : " + result);
        return result.toArray(new String[0]);
    }

    private String checkWord(List<String> wordlist, String query) {
        System.out.println("query :" + query);
        if (wordlist.contains(query)) return query;
        String lowerCase = query.toLowerCase();
        String checkWord = checkWithCaseIgnore(wordlist, lowerCase);
        System.out.println("checkWord " + checkWord);
        if (checkWord != null) {
            return checkWord;
        }
        return checkWithVowelReplace(wordlist, lowerCase);
    }

    private String checkWithVowelReplace(List<String> wordlist, String query) {
        String result = "";
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        List<Integer> vowelPositions = IntStream.range(0, query.length())
                .filter(i -> vowels.contains(query.charAt(i)))
                .boxed()
                .toList();
        System.out.println("vowelPositions " + vowelPositions);
        if (vowelPositions.isEmpty()) return result;
        for (int i = 0; i < query.length(); i++) {
            char c = query.charAt(i);
            if (!vowels.contains(c)) continue;
            

        }
        return "";
    }

    public static String replaceCharAt(String str, int index, char newChar) {

        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(index, newChar);
        return sb.toString();
    }


    private String checkWithCaseIgnore(List<String> wordlist, String query) {
        return wordlist.stream()
                .filter(word -> word.equalsIgnoreCase(query))
                .findFirst()
                .orElse(null);
    }

}