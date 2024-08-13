package practice;


import java.util.Arrays;

/**
 * Source: LeetCode
 * <p>
 * {@code @Link: https://leetcode.com/problems/rotate-image/}
 * <p>
 */

public class RotateImage {

    static class Solution {

        public static void rotate(int[][] matrix) {
            int len = matrix.length;
            // Transpose the matrix
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            // Reverse each row
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][len - j - 1];
                    matrix[i][len - j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
