/*
https://leetcode.com/problems/reverse-words-in-a-string/

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

Clarification:
==============
What constitutes a word?
A sequence of non-space characters constitutes a word.

Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.

How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/

package leetcode;

import helpers.java.Inputs;

class ReverseWordsInString
{
    private static String join(String[] s, String delimeter)
    {
        StringBuilder sb = new StringBuilder();
        for(String word : s)
        {
            sb.append(word + delimeter);
        }

        String joined = sb.toString();
        return joined.substring(0, joined.length() - delimeter.length());
    }

    private static String reverseWords(String s)
    {
        s = s.trim();
        String[] sa = s.split("\\s+");

        int mid;
        if(sa.length % 2 == 0)
        {
            mid = (sa.length / 2) - 1;
        }
        else
        {
            mid = sa.length / 2;
        }

        for(int i = mid; i >= 0; i--)
        {
            int mi = (sa.length - i) - 1;

            String temp = sa[i];
            sa[i] = sa[mi];
            sa[mi] = temp;
        }

        return join(sa, " ");
    }

    public static void main(String[] args)
    {
        String[] lines = Inputs.readAllInputs();
        System.out.println(reverseWords(lines[0]));
    }
}
