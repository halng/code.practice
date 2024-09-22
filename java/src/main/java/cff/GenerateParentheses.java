package cff;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: LeetCode
 * <p>
 * {@code @Link: https://leetcode.com/problems/generate-parentheses/}
 * <p>
 */
public class GenerateParentheses extends Evaluator {

    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO<>(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
            new IO<>(1, List.of("()")));
    }

    @Override
    protected Object getResult(Object input) {
        return Solution.generateParenthesis((Integer) input);
    }

    static class Solution {

        private static final String OPEN_TAG = "(";
        private static final String CLOSE_TAG = ")";

        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, "", 0, 0, n);
            return result;
        }

        private static void backtrack(List<String> result, String current, int open, int close,
            int max) {
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
        new GenerateParentheses().evaluate();
    }
}
