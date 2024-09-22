package cff;

import java.util.List;

public class MediumTwoSortedArray extends Evaluator {

    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO<>(List.of(new int[]{1, 2}, new int[]{3, 4}), 2.0000));
    }

    @Override
    protected Object getResult(Object input) {
        List<int[]> arrays = (List<int[]>) input;
        return findMedianSortedArrays(arrays.get(0), arrays.get(1));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0;
    }

    public static void main(String[] args) {
        new MediumTwoSortedArray().evaluate();
    }
}
