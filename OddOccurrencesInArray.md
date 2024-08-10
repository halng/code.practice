### Plan
1. **Use XOR Operation**: Instead of using a `HashMap`, we can use the XOR operation to find the element with an odd frequency.
2. **Iterate through the array**: XOR all elements in the array. The result will be the element with an odd frequency.

### Code
```java
public static int solution2(int[] A) {
    int result = 0;
    for (int k : A) {
        result ^= k;
    }
    return result;
}
```