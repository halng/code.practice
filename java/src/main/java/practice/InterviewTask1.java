package practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A technology company announced that a new supply of P monitors would soon be available at their
 * store. There were N orders (numbered from 0 to N−1) placed by customers who wanted to buy those
 * monitors. The K-th order has to be delivered to a location at distance D[K] from the store and is
 * for exactly C[K] monitors. Now the time has come for the monitors to be delivered. The orders
 * will be fulfilled one by one. To minimize the shipping time, it has been decided that the
 * deliveries will be made in order of increasing distance from the store. If there are many
 * customers at the same distance, they can be processed in any order. Monitors to more distant
 * customers will be delivered only once all orders to customers closer to the store have already
 * been fulfilled. What is the maximum total number of orders that can be fulfilled?
 */
public class InterviewTask1 {

    static class Solution {

        public static int solution(int[] D, int[] C, int P) {
            int len = D.length;
            int amountMonitors = 0, result = 0;

            Integer[] tempArr = new Integer[len];
            for (int i = 0; i < len; i++) {
                tempArr[i] = i;
            }

            Arrays.sort(tempArr, Comparator.comparingInt(i -> D[i]));

            for (int idx : tempArr) {
                if (amountMonitors + C[idx] > P) {
                    break;
                }
                amountMonitors += C[idx];
                result++;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int[] D = {5, 11, 1, 3};
        int[] C = {6, 1, 3, 2};
        int P = 7;
        System.out.println(Solution.solution(D, C, P)); // 2

    }
}
