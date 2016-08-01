/*

http://www.geeksforgeeks.org/largest-independent-set-problem/

Given a binary tree find the size of largest independent set (LIS). This means that no two nodes in final set should have direct link with each other.

Node {
  int data;
  Node* lChild, rChild;
}

/**
 *              a1
 *             /  \
 *            a2   a3
 *           / \    \
 *          a4  a5  a6
 *              / \
 *             a8  a9
 *
 *
 LIS->5 because the set would be a1,a6,a4,a8,a9
 Input: root node of tree
 Output: Size of LIS

*/

class LargestIndependentSet
{
    private class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static int max(int a, int b)
    {
        return a > b ? a : b;
    }

    private static int LIS(Node head)
    {
        if(head == null)
        {
            return 0;
        }

        int leftSubChildCount = 0;
        int rightSubChildCount = 0;
        int leftChildCount = 0;
        int rightChildCount = 0;

        if(head.left != null)
        {
            leftSubChildCount = LIS(head.left.left) + LIS(head.left.right);
            leftChildCount = LIS(head.left);
        }

        if(head.right != null)
        {
            rightSubChildCount = LIS(head.right.left) + LIS(head.right.right);
            rightChildCount = LIS(head.right);
        }

        return max(1 + leftSubChildCount + rightSubChildCount, leftChildCount + rightChildCount);
    }

    public static void main(String args[])
    {
        Node a1 = new LargestIndependentSet().new Node(1, null, null);
        Node a2 = new LargestIndependentSet().new Node(2, null, null);
        Node a3 = new LargestIndependentSet().new Node(3, null, null);
        Node a4 = new LargestIndependentSet().new Node(4, null, null);
        Node a5 = new LargestIndependentSet().new Node(5, null, null);
        Node a6 = new LargestIndependentSet().new Node(6, null, null);
        Node a7 = new LargestIndependentSet().new Node(7, null, null);
        Node a8 = new LargestIndependentSet().new Node(8, null, null);
        Node a9 = new LargestIndependentSet().new Node(9, null, null);

        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;

        a3.right = a6;

        a5.left = a8;
        a5.right = a9;

        System.out.println(LIS(a1));
    }
}
