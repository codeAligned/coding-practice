/*
http://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/

Given an array, reverse every sub-array formed by consecutive k elements.

Examples:

Input:
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
k = 3
Output:
[3, 2, 1, 6, 5, 4, 9, 8, 7]

Input:
arr = [1, 2, 3, 4, 5, 6, 7, 8]
k = 5
Output:
[5, 4, 3, 2, 1, 8, 7, 6]

Input:
arr = [1, 2, 3, 4, 5, 6]
k = 1
Output:
[1, 2, 3, 4, 5, 6]

Input:
arr = [1, 2, 3, 4, 5, 6, 7, 8]
k = 10
Output:
[8, 7, 6, 5, 4, 3, 2, 1]
*/

package geeksforgeeks;

class ReverseArrayInGroupsOfGivenSize
{
    private static void reverseSubArray(int[] array, int start, int end)
    {
        int i = start;
        int j = end - 1;

        while(i < j)
        {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            i += 1;
            j -= 1;
        }
    }

    private static void reverse(int[] array, int k)
    {
        int size = array.length;
        int start = 0;

        while(start < size)
        {
            int end = start + k;
            if(end > size)
            {
                end = size;
            }

            reverseSubArray(array, start, end);
            start = end;
        }
    }

    private static void print(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] array3 = {1, 2, 3, 4, 5, 6};
        int[] array4 = {1, 2, 3, 4, 5, 6, 7, 8};

        reverse(array1, 3);
        reverse(array2, 5);
        reverse(array3, 1);
        reverse(array4, 10);

        print(array1);
        print(array2);
        print(array3);
        print(array4);
    }
}
