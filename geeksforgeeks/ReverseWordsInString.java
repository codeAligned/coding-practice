/*
http://www.geeksforgeeks.org/reverse-words-in-a-given-string/
*/

package geeksforgeeks;

import helpers.java.Inputs;

public class ReverseWordsInString {
    private static String join(String[] s, String delimeter)
    {
        if(s.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String word : s)
        {
            sb.append(word + delimeter);
        }

        String joined = sb.toString();
        return joined.substring(0, joined.length() - delimeter.length());
    }

    private static String reverseString(String s) {
        String[] words = s.split("\\s+");
        int length = words.length;

        int mid;
        if(length % 2 == 0) {
            mid = (length / 2) - 1;
        } else {
            mid = length / 2;
        }

        for(int i = mid; i >= 0; i--) {
            int mirrorPosition = length - 1 - i;
            String temp = words[i];
            words[i] = words[mirrorPosition];
            words[mirrorPosition] = temp;
        }

        return join(words, " ");
    }

    public static void main(String[] args) {
        String[] inputs = Inputs.readAllInputs();
        System.out.println(reverseString(inputs[0]));
    }
}
