#!/usr/bin/env python3

import random

class ListOperations:
    def intersectLists(list1, list2):
        return list(set( x for x in list1 if x in list2 ))


list1 = [1, 1, 2]
list2 = [2, 2, 1, 1]

print(list1)
print(list2)
print(ListOperations.intersectLists(list1, list2))
