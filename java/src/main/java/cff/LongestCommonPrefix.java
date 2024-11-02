package cff;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/https://leetcode.com/problems/longest-common-prefix/">LeetCode: Longest Common Prefix</a>
 */
public class LongestCommonPrefix extends Evaluator {
    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO<>(new String[]{"flower", "flow", "flight"}, "fl"), new IO<>(new String[]{"a"}, "a"));
    }

    @Override
    protected Object getResult(Object input) {
        return solution((String[]) input);
    }

    public String solution(String[] strs) {
        StringBuilder builder = new StringBuilder();

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }

        for (int i = 0; i < minLength; i++) {
            char current = strs[0].charAt(i);
            boolean isSame = true;
            for (int j = 1; j < strs.length; j++) {
                isSame = isSame && current == strs[j].charAt(i);
            }

            if (isSame) {
                builder.append(current);
            } else {
                break;
            }
        }

        return builder.toString();
    }

    public static void main(String... args) {
        new LongestCommonPrefix().evaluate();
    }
}
