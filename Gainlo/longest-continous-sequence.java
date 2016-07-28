/*

http://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/

Find longest contiguous sequence within array, that sums to 0. Array includes negative numbers.

E.g.

[-1 0 1] -> 3
[2 3 1 -3 2 -2 3] -> 4

Solution:
The idea here is to understand that 0 means you have started with a sum x and then again ended up with sum x.
This means that somewhere in between x must have increased and then decreased the same amount.

In above example of 2 3 1 -3 2 -2 3
Sum goes like 2 5 6 3 5 and so on. So when you see 5 again, you know that from first 5 the sum must have increased,
and then decreased the same amount. So the subarray from first 5 to second 5 will amount to 0.

*/

import java.util.HashMap;
import java.util.Scanner;

class LongestContinousSequence
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());

        int[] nums = new int[total];
        for(int i = 0; i < total; i++)
        {
            nums[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1);

        int maxLen = 0;
        int sum = 0;

        for(int i = 0; i < total; i++)
        {
            if(nums[i] == 0 && maxLen == 0)
            {
                maxLen = 1;
            }

            sum += nums[i];

            Integer prevI = hm.get(sum);
            if(prevI == null)
            {
                hm.put(sum, i);
            }
            else
            {
                if(i - prevI >= maxLen)
                {
                    maxLen = i - prevI;
                }
            }
        }

        System.out.println(maxLen);
    }
}
