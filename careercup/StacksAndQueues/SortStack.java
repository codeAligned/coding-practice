/*
Cracking The Coding Interview - 6th Edition. Page 237.

Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
*/

package careercup.stacksandqueues;

import java.util.Stack;

public class SortStack {
    private static Stack<Integer> sortStack(Stack<Integer> s1) {
        if(s1.isEmpty()) {
            return s1;
        }

        Stack<Integer> s2 = new Stack<Integer>();
        s2.push(s1.pop());

        while(! s1.isEmpty()) {
            int element = s1.pop();

            if(element <= s2.peek()) {
                s2.push(element);
            } else {
                while(! s2.isEmpty() && s2.peek() < element) {
                    s1.push(s2.pop());
                }

                s2.push(element);
            }
        }

        return s2;
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(5);
        s1.push(2);
        s1.push(3);
        s1.push(6);
        s1.push(5);
        s1.push(1);
        s1.push(7);
        s1.push(8);
        s1.push(3);
        s1.push(13);
        s1.push(9);
        s1.push(2);
        s1.push(4);
        s1.push(8);
        s1.push(10);
        s1.push(20);
        s1.push(15);

        s1 = sortStack(s1);
        while(! s1.isEmpty()) {
            System.out.println(s1.pop());
        }
    }
}
