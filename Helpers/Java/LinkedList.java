package helpers.java;

import helpers.java.Node;

public class LinkedList<T>
{
    public Node<T> createFromArray(T[] data)
    {
        Node<T> head = null;
        Node<T> tail = null;

        for(T d : data)
        {
            Node<T> n = new Node<T>(d);

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

    public void printLinkedList(Node<T> head)
    {
        Node<T> current = head;

        while(current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
