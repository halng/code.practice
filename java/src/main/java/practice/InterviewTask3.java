package practice;

public class InterviewTask3 {

    static class Solution {
        public static String solution(String S, String T) {
            if (S.equals(T)) {
                return "EQUAL";
            }
            int lenS = S.length();
            int lenT = T.length();

            if (lenT == lenS + 1) {
                if (T.substring(1).equals(S)) {
                    return "INSERT " + T.charAt(0);
                }
            }
            if (lenS == lenT + 1) {
                if (S.substring(0, lenS-1).equals(T)) {
                    return "REMOVE " + S.charAt(lenS - 1);
                }
            }

            if (lenS == lenT) {
                int firstPos = -1, secondPos = -1;
                for (int i = 0; i < lenS; i++) {
                    if (S.charAt(i) != T.charAt(i)) {
                        if (firstPos == -1) {
                            firstPos = i;
                        } else if (secondPos == -1) {
                            secondPos = i;
                        } else {
                            return "IMPOSSIBLE";
                        }
                    }
                }
                if (firstPos != -1 && secondPos != -1
                    && S.charAt(firstPos) == T.charAt(secondPos)
                    && S.charAt(secondPos) == T.charAt(firstPos)) {
                    return "SWAP " + S.charAt(firstPos) + " " + S.charAt(secondPos);
                }
            }
            return "IMPOSSIBLE";

        }
    }

    public static void main(String[] args) {
        String S = "gain";
        String T = "again";
        System.out.println(Solution.solution(S, T)); // INSERT a
        System.out.println(Solution.solution("parks", "park")); // REMOVE s
        System.out.println(Solution.solution("park", "park")); // EQUAL
        System.out.println(Solution.solution("o", "odd")); // impossible
        System.out.println(Solution.solution("form", "from")); // SWAP o r
        System.out.println(Solution.solution("fift", "fifth")); // impossible
    }
}
