/*
http://www.geeksforgeeks.org/implement-stack-using-queue/

Implement Stack using Queues
We are given a Queue data structure that supports standard operations like enqueue() and dequeue().
We need to implement a Stack data structure using only instances of Queue.
*/

package geeksforgeeks;

import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingQueues
{
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public ImplementStackUsingQueues()
    {
        this.q1 = new LinkedList<Integer>();
        this.q2 = new LinkedList<Integer>();
    }

    public void push(int x)
    {
        this.q2.add(x);

        while(this.q1.peek() != null)
        {
            this.q2.add(this.q1.remove());
        }

        Queue<Integer> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
    }

    public Integer pop()
    {
        return this.q1.remove();
    }

    public boolean isEmpty()
    {
        return this.q1.peek() == null;
    }

    public static void main(String[] args)
    {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        System.out.println("Stack is " + stack.isEmpty());

        stack.push(1);
        stack.push(2);
        System.out.println("Just added 1, 2.");

        System.out.println("Popping " + stack.pop());
        stack.push(3);
        System.out.println("Popping " + stack.pop());
        System.out.println("Popping " + stack.pop());
    }
}
