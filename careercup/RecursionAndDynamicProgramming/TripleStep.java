/*
Cracking The Coding Interview - 6th Edition. Page 134.

Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
Implement a method to count how many possible ways the child can run up the stairs.
*/

package careercup.recursionanddynamicprogramming;

import helpers.java.Inputs;

public class TripleStep {
    private static int countDifferentWays(int n) {
        int[] ways = new int[n];
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;

        int total = 0;
        while(n > 0) {

        }

        return total;
    }

    private static void main(String[] args) {
        String[] inputs = Inputs.readAllInputs();
        int n = Integer.parseInt(inputs[0]);
        System.out.println(countDifferentWays(n));
    }
}
