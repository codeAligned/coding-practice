/*
Cracking The Coding Interview - 6th Edition. Page 95.

Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
so as to make a loop in the linked list.

EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same case earlier]
Output: C
*/

package careercup.linkedlists;

import java.util.HashMap;

import helpers.java.Inputs;
import helpers.java.LinkedList;
import helpers.java.Node;

class LoopDetection
{
    private static Node<Integer> detectLoopWithHashMap(Node<Integer> head)
    {
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        Node<Integer> current = head;

        while(current != null)
        {
            Boolean isPresent = hm.get(current.data);
            if(isPresent == null)
            {
                hm.put(current.data, true);
            }
            else
            {
                return current;
            }

            current = current.next;
        }
        return null;
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        String[] lines = Inputs.readAllInputs();
        Integer[] data = Inputs.createArrayOfIntegers(lines[0]);

        Node<Integer> head = linkedList.createFromArray(data);
        Node<Integer> node = detectLoopWithHashMap(head);
        System.out.println(node == null ? "No Loops." : node.data);
    }
}
