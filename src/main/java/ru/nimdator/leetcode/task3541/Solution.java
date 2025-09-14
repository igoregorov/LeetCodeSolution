package ru.nimdator.leetcode.task3541;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    private static final Set<Character> voewlSet = new HashSet<>();

    static {
        voewlSet.add('a');
        voewlSet.add('e');
        voewlSet.add('i');
        voewlSet.add('o');
        voewlSet.add('u');
    }

    public int maxFreqSum(String s) {
        Map<Character, Integer> letterCounter = new HashMap<>();
        int aVoewl = 0;
        int bNonVoewl = 0;
        for (Character c : s.toCharArray()) {
            letterCounter.put(c, letterCounter.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : letterCounter.entrySet()) {
            if (voewlSet.contains(entry.getKey())) {
                aVoewl = aVoewl < entry.getValue() ? entry.getValue() : aVoewl;
                continue;
            }
            if (bNonVoewl < entry.getValue()) {
                bNonVoewl = entry.getValue();
            }
        }
        return aVoewl + bNonVoewl;
    }

    public int maxFreqSum_v2(String s) {
        Map<Character, Integer> letterCounter = new HashMap<>();
        int aVoewl = 0;
        int bNonVoewl = 0;
        for (Character c : s.toCharArray()) {
            int freq = letterCounter.getOrDefault(c, 0) + 1;
            letterCounter.put(c, freq);
            if (voewlSet.contains(c)) {
                aVoewl = Math.max(aVoewl, freq);
                continue;
            }
            bNonVoewl = Math.max(bNonVoewl, freq);
        }
        return aVoewl + bNonVoewl;
    }

    public int maxFreqSum_v3(String s) {
        Map<Character, Integer> letterCounter = new HashMap<>();
        int aVoewl = 0;
        int bNonVoewl = 0;
        int vSum = 0;
        for (Character c : s.toCharArray()) {
            int freq = letterCounter.getOrDefault(c, 0) + 1;
            letterCounter.put(c, freq);
            if (voewlSet.contains(c)) {
                if (aVoewl < freq) {
                    aVoewl = freq;
                    vSum++;
                }
                continue;
            }
            if (bNonVoewl < freq) {
                bNonVoewl = freq;
                vSum++;
            }
        }
        return vSum;
    }


    public int maxFreqSum_v4(String s) {
        Map<Character, Integer> letterCounter = new HashMap<>();
        int aVoewl = 0;
        int vSum = 0;
        for (Character c : s.toCharArray()) {
            int freq = letterCounter.getOrDefault(c, 0) + 1;
            letterCounter.put(c, freq);
            if (voewlSet.contains(c)) {
                if (aVoewl < freq) {
                    aVoewl = freq;
                    vSum++;
                }
                continue;
            }
            if ((vSum - aVoewl) < freq) {
                vSum++;
            }
        }
        return vSum;
    }
}