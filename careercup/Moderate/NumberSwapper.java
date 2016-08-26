/*
Cracking The Coding Interview - 6th Edition. Page 181.

Number Swapper: Write a function to swap a number in place (that is, without temporary variables).
*/

package careercup.moderate;

class NumberSwapper {
    private static int[] swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;

        return new int[] {a, b};
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 3;

        int[] swapped = swap(a, b);
        System.out.println(a + " " + b);
        System.out.println(swapped[0] + " " + swapped[1]);
    }
}
