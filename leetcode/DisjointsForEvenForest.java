package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DisjointsForEvenForest {
    private static class ReturnValue {
        int disjoints;
        int attachedNodeCount;

        public ReturnValue(int disjoints, int attachedNodeCount) {
            this.disjoints = disjoints;
            this.attachedNodeCount = attachedNodeCount;
        }
    }

    private static class Node {
        int data;
        ArrayList<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<Node>();
        }

        public boolean hasChildren() {
            return this.children.size() > 0;
        }

        public void addChild(Node child) {
            this.children.add(child);
        }
    }

    private static ReturnValue countMaximumDisjoints(Node head) {
        if(! head.hasChildren()) {
            return new ReturnValue(0, 1);
        }

        int count = 0;
        int remaining = 0;

        for(Node child : head.children) {
            ReturnValue rv = countMaximumDisjoints(child);
            count += rv.disjoints;
            remaining += rv.attachedNodeCount;
        }

        if((remaining + 1) % 2 == 0) {
            return new ReturnValue(count + 1, 0);
        } else {
            return new ReturnValue(count, remaining + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Node> dataNodeMapping = new HashMap<Integer, Node>();

        String[] inputs = scanner.nextLine().trim().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        while(scanner.hasNextLine()) {
            inputs = scanner.nextLine().trim().split(" ");

            if(inputs[0].length() == 0) {
                break;
            }

            int i1 = Integer.parseInt(inputs[0]);
            int i2 = Integer.parseInt(inputs[1]);
            Node n1;
            Node n2;

            if(dataNodeMapping.get(i1) == null) {
                n1 = new Node(i1);
                dataNodeMapping.put(i1, n1);
            } else {
                n1 = dataNodeMapping.get(i1);
            }

            if(dataNodeMapping.get(i2) == null) {
                n2 = new Node(i2);
                dataNodeMapping.put(i2, n2);
            } else {
                n2 = dataNodeMapping.get(i2);
            }

            n2.addChild(n1);
        }

        Node head = dataNodeMapping.get(1);

        ReturnValue rv = countMaximumDisjoints(head);
        System.out.println(rv.disjoints - 1);
    }
}
