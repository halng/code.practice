package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Source: Codility
 * <p>
 * {@code @Link: https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/}
 * <p>
 * Find value that occurs in odd number of elements.
 */
public class OddOccurrencesInArray {

    public static class Solution {

        public static int solution2(int[] A) {
            Map<Integer, Integer> hm = new HashMap<>();
            for (int k : A) {
              hm.put(k, hm.getOrDefault(k,0) + 1);
            }

            for (Map.Entry<Integer, Integer> h : hm.entrySet()) {
                if (h.getValue() % 2 != 0) {
                    return h.getKey();
                }
            }
            return -1;
        }

        public static int solution3(int[] A) {
            int result = 0;
            for (int k : A) {
                result ^= k;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(Solution.solution3(A));
    }
}
