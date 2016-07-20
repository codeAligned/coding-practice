/*
Cracking the coding interview: Chapter 1: Arrays & Strings.
Q 1.2: Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
*/

import java.util.HashMap;
import java.util.Scanner;

class CheckIfPermutation
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        CheckIfPermutation obj = new CheckIfPermutation();
        System.out.println(obj.isPermutationHM(s1, s2));
        System.out.println(obj.isPermutationArray(s1, s2));
    }

    public boolean isPermutationArray(String s1, String s2)
    {
        char[] c1 = s1.replaceAll("\\s+", "").toUpperCase().toCharArray();
        char[] c2 = s2.replaceAll("\\s+", "").toUpperCase().toCharArray();

        if(c1.length != c2.length)
        {
            return false;
        }

        int arr[] = new int[26];

        for(int i = 0; i < c1.length; i++)
        {
            int ascii = (int) c1[i];
            ascii = ascii - 65;

            arr[ascii] += 1;
        }

        for(int i = 0; i < c2.length; i++)
        {
            int ascii = (int) c2[i];
            ascii = ascii - 65;

            arr[ascii] -= 1;
            
            if(arr[ascii] < 0)
            {
                return false;
            }
        }

        return true;
    }

    public boolean isPermutationHM(String s1, String s2)
    {
        s1 = s1.replaceAll("\\s+", "").toUpperCase();
        s2 = s2.replaceAll("\\s+", "").toUpperCase();

        if(s1.length() != s2.length())
        {
            return false;
        }

        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        for(int i = 0; i < s1.length(); i++)
        {
            String c = s1.charAt(i) + "";
            Integer count = hm.get(c);

            if(count == null)
            {
                hm.put(c, 1);
            }
            else
            {
                hm.put(c, ++count);
            }
        }

        for(int i = 0; i < s2.length(); i++)
        {
            String c = s2.charAt(i) + "";
            Integer count = hm.get(c);

            if(count == null)
            {
                return false;
            }
            else
            {
                hm.put(c, --count);
            }
        }

        for(Integer value : hm.values())
        {
            if(value != 0)
            {
                return false;
            }
        }

        return true;
    }
}
