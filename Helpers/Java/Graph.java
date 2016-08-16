package helpers.java;

import java.util.HashMap;
import helpers.java.Node;

public class Graph<T>
{
    /*
    A n*2 matrix will have one node pointing to other node.
    E.g. 1-2 1-3 2-3 means that node 1 points to 2 and 3. Node 2 points to 3.

    The final graph representation will be an array which represent each vertex.
    Each item in array is the head to a linked list which links this vertex's neighbours.
    */
    public HashMap<T, Node<T>> createFromArray(T[][] data)
    {
        HashMap<T, Node<T>> graph = new HashMap<T, Node<T>>();

        for(T[] assoc : data)
        {
            Node<T> head = graph.get(assoc[0]);
            if(head == null)
            {
                head = new Node<T>(assoc[1]);
                graph.put(assoc[0], head);
            }
            else
            {
                Node<T> node = new Node<T>(assoc[1]);
                node.next = head;
                graph.put(assoc[0], node);
            }
        }

        return graph;
    }

    /*
    Provides clear steps to produce a graph on pen and paper.
    */
    public void printGraph(HashMap<T, Node<T>> graph)
    {
        System.out.println("\nFirst draw circles with below data in them.");
        for(T key : graph.keySet())
        {
            System.out.print(key + " ");
        }

        System.out.println("\n");
        for(T key : graph.keySet())
        {
            Node<T> head = graph.get(key);
            Node<T> current = head;

            System.out.print("From node " + key + " draw lines to ");
            while(current != null)
            {
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Your graph is done!");
        System.out.println();
    }
}
