/*
http://www.geeksforgeeks.org/find-combinations-k-bit-numbers-n-bits-set-1-n-k-sorted-order/
*/
// TODO: Complete K-Bit numbers.
class KBitCombinations
{
    private static void printCombinations(int k, String prepend)
    {
        if(k == 1)
        {
            System.out.println(1);
        }
        else if(k == 2)
        {
            System.out.println("01 10");
            System.out.println("11");
        }
    }
}
