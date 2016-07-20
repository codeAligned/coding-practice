#!/usr/bin/env python3

class Node:
    def __init__(self, data, next = None):
        self.data = data
        self.next = next

class LinkedListStack:
    head = None

    def push(self, data):
        node = Node(data)

        if self.head == None:
            self.head = node
        else:
            node.next = self.head
            self.head = node

    def pop(self):
        if self.head == None:
            return None
        
        data = self.head.data
        self.head = self.head.next
        return data

    def isEmpty(self):
        return self.head == None

if __name__ == '__main__':
    ll = LinkedListStack()
    ll.push(1)
    ll.push(2)
    ll.push(3)
    ll.push(4)
    ll.push(5)

    print(ll.pop())
    print(ll.pop())
    print(ll.pop())
    print(ll.pop())

    print(ll.isEmpty())
    print(ll.pop())
    print(ll.isEmpty())
