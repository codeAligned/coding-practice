#!/usr/bin/env python3

from linkedliststack import LinkedListStack

string = 'Hello'
ll = LinkedListStack()

for x in string:
    ll.push(x)

while ll.isEmpty() == False:
    print(ll.pop(), end = '')
print()
