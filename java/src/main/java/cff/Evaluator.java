package cff;

import java.util.Arrays;
import java.util.List;

public abstract class Evaluator {

    protected abstract List<IO> getTestCase();

    protected String getClassName() {
        return this.getClass().toString();
    }

    protected abstract Object getResult(Object input);

    protected void evaluate() {
        List<IO> testCases = getTestCase();
        int idx = 1;
        for (var testCase : testCases) {
            var result = getResult(testCase.input());
            var expected = testCase.expected();
            if (!compare(result, expected)) {
                System.out.printf(
                    "%s | Test case - %d: FAILED for input: %s, expected: %s, got: %s\n",
                    getClassName(), idx, testCase.input(), expected, result);
            } else {
                System.out.printf("%s | Test case - %d: PASSED\n", getClassName(), idx);
            }
            idx++;
        }
    }

    private boolean compare(Object result, Object expected) {
        if (result instanceof Object[] re && expected instanceof Object[] ex) {
            return Arrays.deepEquals(re, ex);
        }
        return result.equals(expected);
    }
}
