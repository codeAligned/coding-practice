/*
Cracking The Coding Interview - 6th Edition. Page 95.

Palindrome: Implement a function to check if a linked list is a palindrome.
*/

package careercup.linkedlists;

import java.util.HashMap;

import helpers.java.Inputs;
import helpers.java.LinkedList;
import helpers.java.Node;

class Palindrome
{
    private static boolean isPalindrome(Node<Character> head)
    {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        Node<Character> current = head;

        while(current != null)
        {
            Integer count = hm.get(current.data);
            if(count == null)
            {
                hm.put(current.data, 1);
            }
            else
            {
                hm.put(current.data, count + 1);
            }

            current = current.next;
        }

        int unbalancedCount = 0;
        Object[] counts = hm.values().toArray();

        for(Object obj : counts)
        {
            int count = (Integer) obj;

            if(count % 2 != 0)
            {
                unbalancedCount += 1;

                if(unbalancedCount > 1)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        LinkedList<Character> linkedList = new LinkedList<Character>();

        String[] lines = Inputs.readAllInputs();
        Character[] data = Inputs.createArrayOfChars(lines[0]);

        Node<Character> head = linkedList.createFromArray(data);
        System.out.println(isPalindrome(head));
    }
}
