/*
https://leetcode.com/problems/lru-cache/

Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
it should invalidate the least recently used item before inserting a new item.
*/

package leetcode;

import java.util.HashMap;

public class LRUCache {
    private class Node {
        int key;
        int data;
        Node next;
        Node prev;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private HashMap<Integer, Node> keymap;
    private int capacity;
    private Node head = null;
    private Node tail = null;

    public LRUCache(int capacity) {
        this.keymap = new HashMap<Integer, Node>();
        this.capacity = capacity;
    }

    private void addElementInCache(Node node) {
        if(this.tail == null) {
            head = tail = node;
        } else {
            node.next = tail.next;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    private Node deleteElementInCache(Node node) {
        if(node == null) {
            return null;
        }

        if(node.prev == null && node.next == null) {
            head = tail = null;
            return node;
        }

        if(node.prev == null) {
            node.next.prev = null;
            head = node.next;
        } else if(node.next == null) {
            node.prev.next = node.next;
            tail = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        return node;
    }

    public int get(int key) {
        Node node = this.keymap.get(key);
        if(node == null) {
            return -1;
        }

        node = this.deleteElementInCache(node);
        this.addElementInCache(node);
        return node.data;
    }

    public void set(int key, int value) {
        Node keyNode = this.keymap.get(key);
        if(keyNode != null) {
            keyNode.data = value;
            keyNode = this.deleteElementInCache(keyNode);
            this.addElementInCache(keyNode);
        } else {
            if(this.keymap.size() == this.capacity) {
                Node node = this.deleteElementInCache(this.head);
                this.keymap.remove(node.key);
            }

            Node node = new Node(key, value);
            this.addElementInCache(node);
            this.keymap.put(key, node);
        }
    }

    public void printCache() {
        Node current = this.head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.set(1, 1);cache.printCache();
        cache.set(2, 2);cache.printCache();
        cache.set(3, 3);cache.printCache();
        cache.set(1, 1);cache.printCache();
        cache.set(3, 3);cache.printCache();
        cache.set(4, 4);cache.printCache();
        cache.set(5, 5);cache.printCache();
        cache.set(6, 6);cache.printCache();
        cache.get(3);cache.printCache();
        cache.get(4);cache.printCache();
    }
}
