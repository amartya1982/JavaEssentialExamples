package com.java.EasyAlgo;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepetativeChar {
    public static Character findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Return the first character with frequency 1
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null; // or throw exception if no unique character
    }

    public static void main(String[] args) {
        String input = "swiss";
        Character result = findFirstNonRepeatingChar(input);
        if (result != null)
            System.out.println("First non-repeating character: " + result);
        else
            System.out.println("No non-repeating character found.");
    }
}
