/*
Cracking The Coding Interview - 6th Edition. Page 134.

Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
Implement a method to count how many possible ways the child can run up the stairs.
*/

package careercup.recursionanddynamicprogramming;

import helpers.java.Inputs;

public class TripleStep {
    private static int[] ways;

    private static int countDifferentWays(int n) {
        if(ways[n] != 0) {
            return ways[n];
        }

        int oneway = countDifferentWays(n - 1);
        int twoway = countDifferentWays(n - 2);
        int threeway = countDifferentWays(n - 3);

        ways[n] = oneway + twoway + threeway;
        return ways[n];
    }

    public static void main(String[] args) {
        String[] inputs = Inputs.readAllInputs();
        int n = Integer.parseInt(inputs[0]);

        ways = new int[n + 1];
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;

        System.out.println(countDifferentWays(n));
    }
}
