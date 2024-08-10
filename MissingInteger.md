### Plan
1. **Filter and Sort**: Filter out non-positive integers and sort the remaining elements.
2. **Find Missing Integer**: Iterate through the sorted list to find the smallest missing positive integer.

### Code
```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }

        int smallestPositive = 1;
        while (set.contains(smallestPositive)) {
            smallestPositive++;
        }

        return smallestPositive;
    }
}
```