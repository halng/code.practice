package cff;

import java.util.ArrayList;
import java.util.List;

public class LexicoGraphicalNumbers extends Evaluator {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i < 10; i++) {
            int next = 10 * current + i;
            if (next > n) {
                return;
            }
            dfs(next, n, result);
        }
    }

    public static void main(String[] args) {
        new LexicoGraphicalNumbers().evaluate();
    }

    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO(1, List.of(1)),
            new IO(13, List.of(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9)),
            new IO(10, List.of(1, 10, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    @Override
    protected Object getResult(Object input) {
        int n = (int) input;
        return lexicalOrder(n);
    }
}
