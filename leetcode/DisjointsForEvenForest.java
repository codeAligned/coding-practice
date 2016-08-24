package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// TODO: Disjoints not working.

public class DisjointsForEvenForest {
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

    private static int countMaximumDisjoints(Node head) {
        if(! head.hasChildren()) {
            return 0;
        }

        int count = 0;
        int remaining = 0;

        for(Node child : head.children) {
            int disjoints = countMaximumDisjoints(child);
            if(disjoints != 0) {
                count += disjoints;
            } else {
                remaining += 1;
            }
        }

        if((remaining + 1) % 2 == 0) {
            count += 1;
        }

        return count;
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
        System.out.println(countMaximumDisjoints(head));
    }
}
