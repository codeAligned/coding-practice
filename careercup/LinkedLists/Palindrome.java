/*
Cracking The Coding Interview - 6th Edition. Page 95.

Palindrome: Implement a function to check if a linked list is a palindrome.
*/

package careercup.linkedlists;

import java.util.Stack;

import helpers.java.Inputs;
import helpers.java.LinkedList;
import helpers.java.LinkedListCommons;
import helpers.java.Node;

class Palindrome
{
    private static class PalindromeNode
    {
        public Node<Character> node;
        public boolean isPalindrome;

        public PalindromeNode(Node<Character> node, boolean isPalindrome)
        {
            this.node = node;
            this.isPalindrome = isPalindrome;
        }
    }

    private static PalindromeNode traverseForPalindrome(Node<Character> head, int length)
    {
        if(length == 0)
        {
            return new PalindromeNode(head, true);
        }
        else if(length == 1)
        {
            return new PalindromeNode(head.next, true);
        }

        PalindromeNode palindromeNode = traverseForPalindrome(head.next, length - 2);
        if(palindromeNode.isPalindrome == false || ! palindromeNode.node.data.equals(head.data))
        {
            return new PalindromeNode(palindromeNode.node.next, false);
        }
        else
        {
            return new PalindromeNode(palindromeNode.node.next, true);
        }
    }

    private static boolean isPalindromeRecursively(Node<Character> head)
    {
        int length = LinkedListCommons.length(head);
        PalindromeNode palindromeNode = traverseForPalindrome(head, length);
        return palindromeNode.isPalindrome;
    }

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
        System.out.println(isPalindromeRecursively(head));
    }
}
