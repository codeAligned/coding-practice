/*
Cracking The Coding Interview - 6th Edition. Page 94.

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
    private static Node sum(Node head1, Node head2)
    {
        Node curr1 = head1;
        Node curr2 = head2;
        Node sumHead = null;
        Node sumTail = null;

        int carry = 0;
        while(curr1 != null || curr2 != null)
        {
            int digitA = 0;
            int digitB = 0;

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

            Node n = new Node(sum % 10);
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
            Node n = new Node(carry);
            sumTail.next = n;
            sumTail = sumTail.next;
        }

        return sumHead;
    }

    public static void main(String[] args)
    {
        String[] inputs = Inputs.readAllInputs();
        int[] num1 = Inputs.createArrayInteger(inputs[0]);
        int[] num2 = Inputs.createArrayInteger(inputs[1]);

        Node head1 = LinkedList.createFromArray(num1);
        Node head2 = LinkedList.createFromArray(num2);

        Node sumHead = sum(head1, head2);

        System.out.println();
        LinkedList.printLinkedList(sumHead);
        System.out.println();
    }
}
