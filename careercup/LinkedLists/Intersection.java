/*
Cracking The Coding Interview - 6th Edition. Page 95.

Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
node. Note that the intersection is defined based on reference, not value. That is, if the kth
node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.
*/

package careercup.linkedlists;

import helpers.java.Inputs;
import helpers.java.LinkedList;
import helpers.java.Node;

class Intersection
{
    private static int length(Node<Integer> head)
    {
        if(head == null)
        {
            return 0;
        }

        int count = 0;
        Node<Integer> current = head;

        while(current != null)
        {
            count += 1;
            current = current.next;
        }

        return count;
    }

    private static Node<Integer> skipNodes(Node<Integer> head, int skip)
    {
        Node<Integer> current = head;

        while(skip > 0)
        {
            current = current.next;
            skip -= 1;
        }

        return current;
    }

    private static Node<Integer> findIntersection(Node<Integer> head1, Node<Integer> head2)
    {
        int len1 = length(head1);
        int len2 = length(head2);
        Node<Integer> current1, current2;

        if(len1 > len2)
        {
            current1 = skipNodes(head1, (len1 - len2));
            current2 = head2;
        }
        else
        {
            current1 = head1;
            current2 = skipNodes(head2, (len2 - len1));
        }

        while(current1 != null && current2 != null)
        {
            if(current1 == current2)
            {
                return current1;
            }

            current1 = current1.next;
            current2 = current2.next;
        }
        return null;
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        String[] lines = Inputs.readAllInputs();
        Integer[] data1 = Inputs.createArrayOfIntegers(lines[0]);
        Integer[] data2 = Inputs.createArrayOfIntegers(lines[1]);
        int position = Integer.parseInt(lines[2]);

        Node<Integer> head1 = linkedList.createFromArray(data1);
        Node<Integer> head2 = linkedList.createFromArray(data2);
        head2 = linkedList.join(head1, head2, position);

        Node<Integer> node = findIntersection(head1, head2);
        System.out.println(node != null ? node.data : "No Intersection!");
    }
}
