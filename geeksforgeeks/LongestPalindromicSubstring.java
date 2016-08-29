/*
http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
*/

package geeksforgeeks;

import helpers.java.Inputs;

public class LongestPalindromicSubstring
{
    private static String expandAroundCenter(String s, int i, int j) {
        int length = s.length();
        for(; i >= 0 && j < length && (s.charAt(i) == s.charAt(j)); ) {
            i -= 1;
            j += 1;
        }
        
        if(i + 1 > j) {
            return "";
        }
        return s.substring(i + 1, j);
    }

    private static String findLongestPalindromeInPolynomial(String s) {
        int length = s.length();
        if(length == 0) {
            return s;
        }

        String longestPalindrome = s.substring(0, 1);

        for(int i = 0; i < length - 1; i++) {
            String palindrome = expandAroundCenter(s, i, i);
            if(palindrome.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome;
            }

            palindrome = expandAroundCenter(s, i, i + 1);
            if(palindrome.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome;
            }
        }

        return longestPalindrome;
    }

    public static void main(String[] args) {
        String[] lines = Inputs.readAllInputs();

        System.out.println(findLongestPalindromeInPolynomial(lines[0]));
    }
}
