package practice;

public class CodilityTask2_1 {

    static class Solution {

        public static int solution(String S) {
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

    }

    public static void main(String[] args) {
        String case1 = "><^v";
        System.out.println(Solution.solution(case1));

        String case2 = "<<^<v>>";
        System.out.println(Solution.solution(case2));

        String case3 = "<<<<<<<<<<";
        System.out.println(Solution.solution(case3));

        String case4 = "><<<<<<<^";
        System.out.println(Solution.solution(case4));
    }
}
