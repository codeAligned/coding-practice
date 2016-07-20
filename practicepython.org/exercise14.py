#!/usr/bin/env python3

import random

def removeDuplicatesUsingLoop(sampleList):
    finalList = []

    for i in sampleList:
        if i not in finalList:
            finalList.append(i)

    return finalList

def removeDuplicatesWithoutLoop(sampleList):
    return list(set(sampleList))

sampleList = [random.randint(1, 5) for x in range(10)]
print('Original List: ' + str(sampleList))
print(removeDuplicatesUsingLoop(sampleList))
print(removeDuplicatesWithoutLoop(sampleList))
