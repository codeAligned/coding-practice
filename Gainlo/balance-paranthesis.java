/*

http://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/

Given the string of brackets. Return the flips needed to make the string look like a balanced bracket expression. You can only flip the brackets ({->} and }->{), delete or add is not allowed. No additional space can be used here.

Examples:
}{ -> 2 flips will give {}
{}{}{} -> No flips required
{{{} -> 1 flip (second bracket) is required
{{{}}}{} -> No flips required
{{}} -> No flips required

*/

import java.util.Scanner;

class BalanceParanthesis
{
    private static int flipsRequired(String sample)
    {
        char[] array = sample.toCharArray();
        int flips = 0;
        int count = 0;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == '{')
            {
                count++;
            }
            else if(array[i] == '}')
            {
                if(count <= 0)
                {
                    array[i] = '{';

                    flips++;
                    count++;
                }
                else
                {
                    count--;
                }
            }
        }

        return flips + Math.abs(count) / 2;
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String sample = scanner.nextLine();

        System.out.println(flipsRequired(sample));
    }
}
