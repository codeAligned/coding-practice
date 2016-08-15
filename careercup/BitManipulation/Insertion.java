/*
Cracking The Coding Interview - 6th Edition. Page 115.

Insertion: You are given two 32-bit numbers, Nand M, and two bit positions, i and j.
Write a method to insert Minto Nsuch that Mstarts at bit j and ends at bit i.
You can assume that the bits j through i have enough space to fit all of M.
That is, if M= 18811, you can assume that there are at least 5 bits between j and i.
You would not, for example, have j = 3 and i = 2, because Mcould not fully fit between bit 3 and bit 2.

EXAMPLE
Input: N = 10000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100
*/


package careercup.bitmanipulation;

import helpers.java.Inputs;

class Insertion
{
    private static int unsetRange(int n, int j, int i)
    {
        int left = -1 << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        return n & mask;
    }

    private static int insertion(int n, int m, int i, int j)
    {
        int mask = unsetRange(n, j, i);
        return (m << i) | mask;
    }

    public static void main(String[] args)
    {
        String[] lines = Inputs.readAllInputs();
        int n = Integer.parseInt(lines[0], 2);
        int m = Integer.parseInt(lines[1], 2);
        int i = Integer.parseInt(lines[2]);
        int j = Integer.parseInt(lines[3]);

        int result = insertion(n, m, i, j);
        System.out.println(Integer.toBinaryString(result));
    }
}
