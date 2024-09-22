package cff;

import java.util.List;

public class LongestPalindrome extends Evaluator {

    @Override
    protected List<IO> getTestCase() {
        return List.of(new IO<>("babad", "bab"), new IO<>("cbbd", "bb"), new IO(
            "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfy"
                + "wcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdeg"
                + "wycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxi"
                + "ldtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqd"
                + "rkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehz"
                + "zapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukal"
                + "brzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusf"
                + "rsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopir"
                + "mhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmls"
                + "rjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnyduf"
                + "sidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbc"
                + "wkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir", "gykrkyg"));
    }

    @Override
    protected Object getResult(Object input) {
        return longestPalindrome((String) input);
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len - i; j++) {
                if (isPalindrome(s, j, j + i)) {
                    return s.substring(j, j + i + 1);
                }
            }
        }
        return "";
    }

    public static void main(String... args) {
        new LongestPalindrome().evaluate();
    }
}
