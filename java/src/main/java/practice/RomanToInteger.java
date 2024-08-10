package practice;

import java.util.Map;

/**
 * Source: LeetCode
 * <p>
 * {@code @Link: https://leetcode.com/problems/roman-to-integer/description/}
 * <p>
 */
public class RomanToInteger {

    static class Solution {
        private static final Map<Character, Integer> ROMAN_VALUES = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );
        private static boolean isSubtractionCase(char current, char next) {
            return (current == 'I' && (next == 'V' || next == 'X')) ||
                (current == 'X' && (next == 'L' || next == 'C')) ||
                (current == 'C' && (next == 'D' || next == 'M'));
        }
        public static int romanToInt(String s) {
            int sum = 0;
            for (int i = 0; i < s.length(); ) {
                if (i < s.length() - 1 && isSubtractionCase(s.charAt(i), s.charAt(i + 1))) {
                    sum += ROMAN_VALUES.get(s.charAt(i + 1)) - ROMAN_VALUES.get(s.charAt(i));
                    i += 2;
                } else {
                    sum += ROMAN_VALUES.get(s.charAt(i));
                    i++;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.romanToInt("MCMXCIV"));
    }
}
