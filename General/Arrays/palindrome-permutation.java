/*
Cracking the coding interview: Chapter 1: Arrays & Strings.
Q 1.4: Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat". "atco cta". etc.)
*/

class PalindromePermutation
{
    public static void main(String args[])
    {
        String[] strings = {
            "Rats live on no evil star",
			"A man a plan a canal panama",
			"Lleve",
			"Tacotac",
			"asda"
        };

        PalindromePermutation obj = new PalindromePermutation();

		for(String s : strings)
        {
			System.out.println(obj.isPalindromePermutation(s));
		}
    }

    public boolean isPalindromePermutation(String s)
    {
        s = s.replaceAll("\\s+", "").toUpperCase();
        char[] c = s.toCharArray();
        int[] a = new int[26];

        for(int i = 0; i < c.length; i++)
        {
            int ascii = (int) c[i];
            ascii = ascii - 65;
            a[ascii] += 1;
        }

        boolean loner = false;
        for(int x : a)
        {
            int divby2 = x % 2;

            if(divby2 == 0) continue;
            else if(divby2 != 0 && loner == false) loner = true;
            else return false;
        }

        return true;
    }
}
