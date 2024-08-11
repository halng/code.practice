package practice;

/**
 * Source: LeetCode
 * <p>
 * {@code @Link: https://leetcode.com/problems/longest-palindromic-substring/}
 * <p>
 * Find value that occurs in odd number of elements.
 */
public class LongestPalindromicSubstring {

    static class Solution {

        public static String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            boolean[][] dp = new boolean[len][len];
            int start = 0;
            int maxLength = 1;

            // All substrings of length 1 are palindromes
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            // Check for substrings of length 2
            for (int i = 0; i < len - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    start = i;
                    maxLength = 2;
                }
            }

            // Check for lengths greater than 2
            for (int k = 3; k <= len; k++) {
                for (int i = 0; i < len - k + 1; i++) {
                    int j = i + k - 1;
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        if (k > maxLength) {
                            start = i;
                            maxLength = k;
                        }
                    }
                }
            }

            return s.substring(start, start + maxLength);

        }
    }

    public static void main(String[] args) {
        String case1 = "babad";
        System.out.println(Solution.longestPalindrome(case1));

        String case2 = "cbbd";
        System.out.println(Solution.longestPalindrome(case2));

        String case3 = "reifadyqgztixemwswtccodfnchcovrmiooffbbijkecuvlvukecutasfxqcqygltrogrdxlrslbnzktlanycgtniprjlospzhhgdrqcwlukbpsrumxguskubokxcmswjnssbkutdhppsdckuckcbwbxpmcmdicfjxaanoxndlfpqwneytatcbyjmimyawevmgirunvmdvxwdjbiqszwhfhjmrpexfwrbzkipxfowcbqjckaotmmgkrbjvhihgwuszdrdiijkgjoljjdubcbowvxslctleblfmdzmvdkqdxtiylabrwaccikkpnpsgcotxoggdydqnuogmxttcycjorzrtwtcchxrbbknfmxnonbhgbjjypqhbftceduxgrnaswtbytrhuiqnxkivevhprcvhggugrmmxolvfzwadlnzdwbtqbaveoongezoymdrhywxcxvggsewsxckucmncbrljskgsgtehortuvbtrsfisyewchxlmxqccoplhlzwutoqoctgfnrzhqctxaqacmirrqdwsbdpqttmyrmxxawgtjzqjgffqwlxqxwxrkgtzqkgdulbxmfcvxcwoswystiyittdjaqvaijwscqobqlhskhvoktksvmguzfankdigqlegrxxqpoitdtykfltohnzrcgmlnhddcfmawiriiiblwrttveedkxzzagdzpwvriuctvtrvdpqzcdnrkgcnpwjlraaaaskgguxzljktqvzzmruqqslutiipladbcxdwxhmvevsjrdkhdpxcyjkidkoznuagshnvccnkyeflpyjzlcbmhbytxnfzcrnmkyknbmtzwtaceajmnuyjblmdlbjdjxctvqcoqkbaszvrqvjgzdqpvmucerumskjrwhywjkwgligkectzboqbanrsvynxscpxqxtqhthdytfvhzjdcxgckvgfbldsfzxqdozxicrwqyprgnadfxsionkzzegmeynye";
        System.out.println(Solution.longestPalindrome(case3));
    }
}
