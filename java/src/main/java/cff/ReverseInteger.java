package cff;

import java.util.List;

public class ReverseInteger extends Evaluator {

    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO<>(123, 321), new IO<>(-123, -321), new IO<>(210, 12),
            new IO<>(1534236469, 0));
    }

    @Override
    protected Object getResult(Object input) {
        return reverse((int) input);
    }

    public int reverse(int x) {
        long reversed = 0;
        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) reversed;
    }

    public static void main(String... args) {
        new ReverseInteger().evaluate();
    }
}
