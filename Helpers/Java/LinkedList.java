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

    /*
    Joins head2's tail to nth position of head1.
    E.g. head1 = 1 2 3 4 5 6    head2 = 7 8    pos = 3 (counting from 0th place)
    Final head2 = 7 8 4 5 6
    */
    public Node<T> join(Node<T> head1, Node<T> head2, int position)
    {
        if(position < 0)
        {
            return head2;
        }

        Node<T> tail2 = head2;
        while(tail2.next != null)
        {
            tail2 = tail2.next;
        }

        Node<T> h1pos = head1;
        while(position > 0)
        {
            h1pos = h1pos.next;
            position -= 1;
        }

        tail2.next = h1pos;
        return head2;
    }
}
