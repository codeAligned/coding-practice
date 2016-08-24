package leetcode;

import helpers.java.Inputs;

public class HammingWeight
{
    private static boolean isBitSet(int n, int pos)
    {
        int mask = 1 << pos;
        return (n & mask) != 0;
    }

    private static int hammingWeight(int n)
    {
        int count = 0;

        for(int i = 0; i < 32; i++)
        {
            if(isBitSet(n, i))
            {
                count += 1;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        String[] lines = Inputs.readAllInputs();
        int n = Integer.parseInt(lines[0]);

        System.out.println(Integer.toBinaryString(n));
        System.out.println(hammingWeight(n));
    }
}
