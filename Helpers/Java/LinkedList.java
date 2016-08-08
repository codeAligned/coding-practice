package helpers.java;

import helpers.java.Node;

public class LinkedList
{
    public static Node createFromArray(int[] data)
    {
        Node head = null;
        Node tail = null;

        for(int d : data)
        {
            Node n = new Node(d);

            if(head == null)
            {
                head = n;
                tail = head;
            }
            else
            {
                tail.next = n;
                tail = tail.next;
            }
        }

        return head;
    }

    public static void printLinkedList(Node head)
    {
        Node current = head;

        while(current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
