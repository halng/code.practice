package cff;

import java.util.List;

public class CodilityTask2_1 extends Evaluator {

    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO("><^v", 2), new IO("<<^<v>>", 5), new IO("<<<<<<<<<<", 10),
            new IO("><<<<<<<^", 1));
    }

    @Override
    protected Object getResult(Object input) {
        return solution((String) input);
    }

    public int solution(String S) {
        S = " " + S;
        char[] charArrays = S.toCharArray();
        int count = 0;

        for (int i = 1; i < charArrays.length; i++) {
            if (charArrays[i] == '^' || charArrays[i] == 'v') {
                count++;
                charArrays[i] = ' ';
            } else if (charArrays[i] == '<' && charArrays[i - 1] == ' ') {
                charArrays[i - 1] = charArrays[i];
                charArrays[i] = ' ';
                count++;
            } else if (charArrays[i] == '>' && i < charArrays.length - 1
                && charArrays[i + 1] == ' ') {
                charArrays[i + 1] = charArrays[i];
                charArrays[i] = ' ';
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        new CodilityTask2_1().evaluate();
    }
}
