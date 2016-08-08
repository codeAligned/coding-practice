/*
http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
*/

package geeksforgeeks;

import helpers.java.Inputs;
import helpers.java.LinkedList;
import helpers.java.Node;

class ReverseLinkedList
{
    private static Node reverseLinkedListIteratively(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node current = head;
        Node previous = null;
        Node next = null;

        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
        return head;
    }

    private static Node reverseLinkedListRecursively(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node endNode = reverseLinkedListRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return endNode;
    }

    public static void main(String[] args)
    {
        String[] inputs = Inputs.readAllInputs();
        int[] data = Inputs.createArrayInteger(inputs[0]);

        Node head = LinkedList.createFromArray(data);
        head = reverseLinkedListIteratively(head);
        System.out.println();
        LinkedList.printLinkedList(head);
        System.out.println();

        head = LinkedList.createFromArray(data);
        head = reverseLinkedListRecursively(head);
        System.out.println();
        LinkedList.printLinkedList(head);
        System.out.println();
    }
}
