package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: LeetCode
 * <p>
 * {@code @Link: https://leetcode.com/problems/generate-parentheses/}
 * <p>
 */
public class GenerateParentheses {

    static class Solution {

        private static String OPEN_TAG = "(";
        private static String CLOSE_TAG = ")";

        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, "", 0, 0, n);
            return result;
        }

        private static void backtrack(List<String> result, String current, int open, int close, int max) {
            if (current.length() == max * 2) {
                result.add(current);
                return;
            }

            if (open < max) {
                backtrack(result, current + OPEN_TAG, open + 1, close, max);
            }
            if (close < open) {
                backtrack(result, current + CLOSE_TAG, open, close + 1, max);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.generateParenthesis(3));
        System.out.println(Solution.generateParenthesis(1));
    }
}
