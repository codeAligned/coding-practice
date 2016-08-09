/*
Cracking The Coding Interview - 6th Edition. Page 95.

Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
The digits are stored in reverse order, such that the 1's digit is at the head of the list.
Write a function that adds the two numbers and returns the sum as a linked list.

EXAMPLE
Input: (7-) 1 -) 6) + (5 -) 9 -) 2).Thatis,617 + 295. Output: 2 -) 1 -) 9.That is, 912.

FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
Input: (6 -) 1 -) 7) + (2 -) 9 -) 5).Thatis,617 + 295. Output: 9 -) 1 -) 2.That is, 912.
*/

package careercup.linkedlists;

import helpers.java.Inputs;
import helpers.java.LinkedList;
import helpers.java.Node;

class SumLists
{
    private static Node<Integer> sum(Node<Integer> head1, Node<Integer> head2)
    {
        Node<Integer> curr1 = head1;
        Node<Integer> curr2 = head2;
        Node<Integer> sumHead = null;
        Node<Integer> sumTail = null;

        int carry = 0;
        while(curr1 != null || curr2 != null)
        {
            Integer digitA = 0;
            Integer digitB = 0;

            if(curr1 == null)
            {
                digitA = 0;
            }
            else
            {
                digitA = curr1.data;
                curr1 = curr1.next;
            }

            if(curr2 == null)
            {
                digitB = 0;
            }
            else
            {
                digitB = curr2.data;
                curr2 = curr2.next;
            }

            int sum = digitA + digitB + carry;
            carry = sum > 9 ? 1 : 0;

            Node<Integer> n = new Node<Integer>(sum % 10);
            if(sumHead == null)
            {
                sumHead = n;
                sumTail = sumHead;
            }
            else
            {
                sumTail.next = n;
                sumTail = sumTail.next;
            }
        }

        if(carry > 0)
        {
            Node<Integer> n = new Node<Integer>(carry);
            sumTail.next = n;
            sumTail = sumTail.next;
        }

        return sumHead;
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        String[] lines = Inputs.readAllInputs();
        Integer[] num1 = Inputs.createArrayOfIntegers(lines[0]);
        Integer[] num2 = Inputs.createArrayOfIntegers(lines[1]);

        Node<Integer> head1 = linkedList.createFromArray(num1);
        Node<Integer> head2 = linkedList.createFromArray(num2);

        Node<Integer> sumHead = sum(head1, head2);

        System.out.println();
        linkedList.printLinkedList(sumHead);
        System.out.println();
    }
}
