package cff;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Leet Code</a>
 *
 * @author halng
 */
public class MediumTwoSortedArray extends Evaluator {

    @Override
    protected List<IO> getTestCase() {
        return List.of(
                new IO<>(List.of(new int[]{1, 2}, new int[]{3, 4}), 2.5000),
                new IO<>(List.of(new int[]{1, 3}, new int[]{2}), 2.0000)
        );
    }

    @Override
    protected Object getResult(Object input) {
        List<int[]> arrays = (List<int[]>) input;
        return findMedianSortedArrays(arrays.get(0), arrays.get(1));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        int idxR1, idxR2;
        int numR1 = -1, numR2 = -1;

        idxR1 = len / 2;
        idxR2 = (len % 2 == 0) ? idxR1 - 1 : idxR1;

        int idxNum1 = 0, idxNum2 = 0;
        for (int i = 0; i < len; i++) {
            int currentValue = -1;
            if (idxNum1 < len1 && idxNum2 < len2) {
                if (nums1[idxNum1] > nums2[idxNum2]) {
                    currentValue = nums2[idxNum2];
                    idxNum2++;

                } else {
                    currentValue = nums1[idxNum1];
                    idxNum1++;
                }

            } else {
                if (idxNum1 < len1) {
                    currentValue = nums1[idxNum1];
                    idxNum1++;

                }
                if (idxNum2 < len2) {
                    currentValue = nums2[idxNum2];
                    idxNum2++;

                }
            }

            if (i == idxR1) {
                numR1 = currentValue;
            }
            if (i == idxR2) {
                numR2 = currentValue;
            }

            if (numR1 != -1 && numR2 != -1) {
                break;
            }

        }

        return (numR1 + numR2) / 2.0;

    }

    public static void main(String[] args) {
        new MediumTwoSortedArray().evaluate();
    }
}
