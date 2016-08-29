/*
http://www.geeksforgeeks.org/longest-common-substring/

Given two strings 'x' and 'y', find the length of the longest common substring.
For example, if the given strings are 'GeeksforGeeks' and 'GeeksQuiz',
the output should be 5 as longest common substring is 'Geeks'.
*/

package geeksforgeeks;

import helpers.java.Inputs;

public class LongestCommonSubstring {
    private int[][] dp;
    private String s1;
    private String s2;

    public LongestCommonSubstring(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;

        int len1 = s1.length();
        int len2 = s2.length();
        this.dp = new int[len1 + 1][len2 + 1];
    }

    public int findLongestSubstringLength() {
        int len1 = this.s1.length();
        int len2 = this.s2.length();

        int longestSubstringLength = -1;
        for(int i = 0; i <= len1; i++) {
            for(int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    this.dp[i][j] = 0;
                } else if(this.s1.charAt(i - 1) == this.s2.charAt(j - 1)) {
                    this.dp[i][j] = this.dp[i-1][j-1] + 1;

                    if(this.dp[i][j] > longestSubstringLength) {
                        longestSubstringLength = this.dp[i][j];
                    }
                } else {
                    this.dp[i][j] = 0;
                }
            }
        }

        return longestSubstringLength;
    }

    public static void main(String[] args) {
        String[] lines = Inputs.readAllInputs();

        LongestCommonSubstring lcs = new LongestCommonSubstring(lines[0], lines[1]);
        System.out.println(lcs.findLongestSubstringLength());
    }
}
