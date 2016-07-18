/*
Given the following relationships:
Child Parent IsLeft
15    20     true
19    80     true
17    20     false
16    80     false
80    50     false
50    null   false
20    50     true

You should return the following tree:
                  50
               /     \
            20        80
           / \       / \
        15   17     19 16
*/

import java.util.HashMap;

class DrawATree
{
    class Node
    {
        private int data;
        private Node left;
        private Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private HashMap<Integer, Node> hm;

    DrawATree()
    {
        this.hm = new HashMap<Integer, Node>();
    }

    public Node insert(Integer cdata, Integer pdata, boolean isLeft)
    {
        if(pdata == null)
        {
            return this.hm.get(cdata);
        }

        Node parent = this.hm.get(pdata);
        if(parent == null)
        {
            parent = new Node(pdata);
            this.hm.put(pdata, parent);
        }

        Node child = this.hm.get(cdata);
        if(child == null)
        {
            child = new Node(cdata);
            this.hm.put(cdata, child);
        }

        if(isLeft)
        {
            parent.left = child;
        }
        else
        {
            parent.right = child;
        }

        return parent;
    }

    public void printTreeInorder(Node root)
    {
        if(root == null)
        {
            return;
        }

        this.printTreeInorder(root.left);
        System.out.print(root.data + " ");
        this.printTreeInorder(root.right);
    }

    public static void main(String args[])
    {
        DrawATree tree = new DrawATree();
        tree.insert(15, 20, true);
        tree.insert(19, 80, true);
        tree.insert(17, 20, false);
        tree.insert(16, 80, false);
        tree.insert(80, 50, false);
        Node root = tree.insert(50, null, false);
        tree.insert(20, 50, true);

        tree.printTreeInorder(root);
    }
}
