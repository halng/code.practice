# Intuition
- Rotate an array to the right by a given number of steps.

# Approach
- Step 1: Init a empty array
- Step 2: loop through A and with each index, will be plus by K
- Step 3: if idx greater than array size then % idx by size

# Complexity
- Time complexity


# Code
```java
public static class Solution {
    public static int[] solution(int[] A, int K) {
        if (K <= 1) {
            return A;
        }
        int size = A.length;
        int[] result = new int[size];

        for(int i=0; i<size; i++) {
            int idx =  i + K;
            if (idx >= size) {
                idx %= size;
            }
            result[idx] = A[i];
        }

        return result;
    }
}
```