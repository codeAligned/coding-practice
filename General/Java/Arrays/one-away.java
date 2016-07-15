/*
Cracking the coding interview: Chapter 1: Arrays & Strings.
Q 1.5: One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, pIe -> true
pales. pale -> true
pale. bale -> true
pale. bake -> false
*/

class OneAway
{
    public static void main(String args[])
    {
        String[][] tests = {
            {"a", "b", "true"},
			{"", "d", "true"},
			{"d", "de", "true"},
			{"pale", "pse", "false"},
			{"acdsfdsfadsf", "acdsgdsfadsf", "true"},
			{"acdsfdsfadsf", "acdsfdfadsf", "true"},
			{"acdsfdsfadsf", "acdsfdsfads", "true"},
			{"acdsfdsfadsf", "cdsfdsfadsf", "true"},
			{"adfdsfadsf", "acdfdsfdsf", "false"},
			{"adfdsfadsf", "bdfdsfadsg", "false"},
			{"adfdsfadsf", "affdsfads", "false"},
			{"pale", "pkle", "true"},
			{"pkle", "pable", "false"}
        };

        OneAway obj = new OneAway();

		for(int i = 0; i < tests.length; i++)
        {
			String[] test = tests[i];
			String a = test[0];
			String b = test[1];
			boolean expected = Boolean.parseBoolean(test[2]);
            boolean result = obj.isOneAway(a, b);

            if(expected == result)
            {
                System.out.println("Test Passed.");
            }
            else
            {
                System.out.println("Test Failed!");
            }
		}
    }

    public boolean isOneAway(String s1, String s2)
    {
        if(Math.abs(s1.length() - s2.length()) > 1) return false;

        int count = 0;
        int i = 0, j = 0;

        for(i = 0; i < s1.length(); i++)
        {
            if(j >= s2.length()) break;

            if(s1.charAt(i) != s2.charAt(j))
            {
                count++;
                System.out.print("Checked i = " + i + ", " + s1.charAt(i) + ", j = " + j + ", " + s2.charAt(j) + ", count = " + count + ". ");

                if(i == j) j++;
            }
            else j++;
        }

        count += s2.length() - j;
        System.out.println("New Count: " + count);

        return count <= 1;
    }
}
