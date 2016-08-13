package helpers.java;

import helpers.java.Node;

public class LinkedListCommons
{
    @SuppressWarnings("rawtypes")
    public static int length(Node head)
    {
        Node current = head;
        int count = 0;

        while(current != null)
        {
            current = current.next;
            count += 1;
        }
        return count;
    }
}
