/*
Cracking The Coding Interview - 6th Edition. Page 95.

Palindrome: Implement a function to check if a linked list is a palindrome.
*/

package careercup.linkedlists;

import java.util.Stack;

import helpers.java.Inputs;
import helpers.java.LinkedList;
import helpers.java.Node;

class Palindrome
{
    private static boolean isPalindromeIteratively(Node<Character> head)
    {
        Stack<Character> stack = new Stack<Character>();
        Node<Character> fast = head;
        Node<Character> slow = head;

        while(fast != null && fast.next != null)
        {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null)
        {
            slow = slow.next;
        }

        while(slow != null)
        {
            if(slow.data.compareTo(stack.pop()) != 0)
            {
                return false;
            }

            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args)
    {
        LinkedList<Character> linkedList = new LinkedList<Character>();

        String[] lines = Inputs.readAllInputs();
        Character[] data = Inputs.createArrayOfChars(lines[0]);

        Node<Character> head = linkedList.createFromArray(data);
        System.out.println(isPalindromeIteratively(head));
    }
}
