package cff;

import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/description/">Leetcode</a>
 */
public class RomanToInteger extends Evaluator {
    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO<>("III", 3), new IO<>("LVIII", 58), new IO<>("MCMXCIV", 1994));
    }

    @Override
    protected Object getResult(Object input) {
        return romanToInt((String) input);
    }

    public int romanToInt(String roman) {
        Map<Character, Integer> maps = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        int result = 0;

        int len = roman.length();
        int i = 0;
        while (i < len) {
            int tempNum = maps.get(roman.charAt(i));

            if (i + 1 < len) {
                char current = roman.charAt(i);
                char next = roman.charAt(i + 1);
                if (current == 'I' && (next == 'X' || next == 'V') || current == 'X' && (next == 'L' || next == 'C') || current == 'C' && (next == 'D' || next == 'M')) {
                    i++;
                    tempNum = maps.get(next) - tempNum;
                }
            }

            result += tempNum;
            i++;
        }

        return result;
    }


    public static void main(String... args) {
        new RomanToInteger().evaluate();
    }
}
