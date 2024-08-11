package practice;

import java.util.PriorityQueue;

/**
 * In order to finish a game, a player has to complete N missions. The missions are numbered from 0
 * to N-1. The K-th mission has an integer D[K] assigned, representing its difficulty level. During
 * a day, you can perform any number of missions given the two following rules: * the difference
 * between the difficulty levels of any two missions performed on the same day should not be greater
 * than an integer X. * missions should be performed in the specified order, in other words, a
 * mission can be undertaken only if all of the missions preceding it have already been completed;
 * <p>
 * Example: 1. Given D = [5, 8, 2, 7] and X = 3, your function should return 3. The first two
 * missions can be performed on the first day, the third mission on the second day and the last
 * mission on the third day. It is not possible to complete all of the missions in fewer days. 2.
 * Given D = [2, 5, 9, 2, 1, 4] and X = 4, your function should return 3. The first two missions can
 * be performed on the first day, the third mission on the second day and all of the remaining
 * missions on the third day. Note that it is possible to perform the first mission on the first day
 * and the next two missions on the second day. In both of these cases, the minimum number of days
 * required to complete all of the missions is 3. 3. Given D = [1, 12, 10, 4, 5, 2] and X = 2, your
 * function should return 4. The first mission can be performed on the first day, the next two
 * missions on the second day, the fourth and fifth missions on the third day, and the last
 * remaining mission on the fourth day. It is not possible to complete all of the missions in fewer
 * days.
 */
public class InterviewTask2 {

    static class Solution {

        public static int solution(int[] D, int X) {
            // greedy algorithm
//            int result = 0;
//            PriorityQueue<Integer> tracker = new PriorityQueue<>((a0, a1) -> a1 - a0);
//
//            for (int j : D) {
//                tracker.offer(j);
//                if (tracker.peek() != null
//                    && tracker.peek() - tracker.stream().min(Integer::compareTo).orElse(0) > X) {
//                    result++;
//                    tracker.clear();
//                    tracker.offer(j);
//                }
//            }
//
//            if (!tracker.isEmpty()) {
//                result++;
//            }
//
//            return result;

            int results = 0, startDate = 0;
            int len = D.length;

            while (startDate < len) {
                int endDate = startDate;
                int minDiffLevel = D[startDate];
                int maxDiffLevel = D[startDate];

                while (endDate < len && maxDiffLevel - minDiffLevel <= X) {
                    endDate++;
                    if (endDate < len) {
                        minDiffLevel = Math.min(minDiffLevel, D[endDate]);
                        maxDiffLevel = Math.max(maxDiffLevel, D[endDate]);
                    }
                }

                results++;
                startDate = endDate;
            }

            return results;
        }
    }

    public static void main(String[] args) {
        int[] D = {5, 8, 2, 7};
        int X = 3;
        System.out.println(Solution.solution(D, X));

        int[] D1 = {2, 5, 9, 2, 1, 4};
        int X1 = 4;
        System.out.println(Solution.solution(D1, X1));

        int[] D2 = {1, 12, 10, 4, 5, 2};
        int X2 = 2;
        System.out.println(Solution.solution(D2, X2));
    }
}
