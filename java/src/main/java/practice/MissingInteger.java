package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Source: Codility
 * <p>
 * {@code @Link: https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/}
 * <p>
 * Find value that occurs in odd number of elements.
 */
public class MissingInteger {

    public static class Solution {

        private static int solution(int[] arr) {
            Set<Integer> hs = new HashSet<>();
            for (int a : arr) {
                if (a > 0) {
                    hs.add(a);
                }
            }

            int minPos = 1;
            while (hs.contains(minPos)) {
                minPos++;
            }
            return minPos;
        }
    }

    public static void main(String... args) {
        int[] arr = {2, 3, 1, 6, 7, 8, 5};
        System.out.println(Solution.solution(arr));
    }
}
