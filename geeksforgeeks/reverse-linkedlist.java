/*
http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
*/

package geeksforgeeks;

import helpers.java.Inputs;
import helpers.java.LinkedList;
import helpers.java.Node;

class ReverseLinkedList
{
    private static Node<Integer> reverseLinkedListIteratively(Node<Integer> head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node<Integer> current = head;
        Node<Integer> previous = null;
        Node<Integer> next = null;

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

    private static Node<Integer> reverseLinkedListRecursively(Node<Integer> head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node<Integer> endNode = reverseLinkedListRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return endNode;
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        String[] lines = Inputs.readAllInputs();
        Integer[] data = Inputs.createArrayOfIntegers(lines[0]);

        Node<Integer> head = linkedList.createFromArray(data);
        head = reverseLinkedListIteratively(head);
        System.out.println();
        linkedList.printLinkedList(head);
        System.out.println();

        head = linkedList.createFromArray(data);
        head = reverseLinkedListRecursively(head);
        System.out.println();
        linkedList.printLinkedList(head);
        System.out.println();
    }
}
