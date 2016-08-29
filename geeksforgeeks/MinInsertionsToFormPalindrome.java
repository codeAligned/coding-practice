/*

http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/

Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd
*/

package geeksforgeeks;

import helpers.java.Inputs;

public class MinInsertionsToFormPalindrome {
    private static int formPalindrome(String s, int i, int j) {
        int length = s.length();
        int insertions = 0;

        while(i >= 0 || j < length) {
            if(i < 0 || j >= length) {
                insertions += 1;
            } else if(s.charAt(i) != s.charAt(j)) {
                insertions += 2;
            }

            i -= 1;
            j += 1;
        }

        return insertions;
    }

    private static int minStepsToTransformToPalindrome(String s) {
        int insertions = Integer.MAX_VALUE;

        int length = s.length();
        for(int i = 0; i < length; i++) {
            int steps = formPalindrome(s, i - 1, i);
            if(steps < insertions) {
                insertions = steps;
            }

            steps = formPalindrome(s, i, i);
            if(steps < insertions) {
                insertions = steps;
            }
        }

        return insertions;
    }

    public static void main(String[] args) {
        String[] inputs = Inputs.readAllInputs();
        System.out.println(minStepsToTransformToPalindrome(inputs[0]));
    }
}
