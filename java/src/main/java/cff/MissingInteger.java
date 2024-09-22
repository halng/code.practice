package cff;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingInteger extends Evaluator {

    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO<>(List.of(2, 3, 1, 6, 7, 8, 5), 4),
            new IO<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 11),
            new IO<>(List.of(2, 3, 4, 5, 6, 7, 8, 11), 1));
    }

    @Override
    protected Object getResult(Object input) {
        List<Integer> castedInput = (List<Integer>) input;
        return solution(castedInput);
    }


    private int solution(List<Integer> arr) {
        Set<Integer> hs = new HashSet<>();
        for (int a : arr) {
            if (a > 0) {
                hs.add(a);
            }
        }

        int minPos = 1;
        while (hs.contains(minPos)) {
            minPos++;
        }
        return minPos;
    }


    public static void main(String... args) {
        new MissingInteger().evaluate();
    }
}
