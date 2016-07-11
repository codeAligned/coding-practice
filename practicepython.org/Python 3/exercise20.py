#!/usr/bin/env python3

import random

def binarySearch(value, sample, start, end):
    if start > end:
        return -1

    midIndex = int((start+end) / 2)
    if value == sample[midIndex]:
        return midIndex
    elif value < sample[midIndex]:
        return binarySearch(value, sample, start, midIndex - 1)
    else:
        return binarySearch(value, sample, midIndex + 1, end)

sample = [x for x in range(100)]
value = random.randint(0, 150)

position = binarySearch(value, sample, 0, len(sample) - 1)
print(str(value) + ' is found at index ' + str(position))

import time
print('Python in vs binartSearch time.')

startTime = time.time()
if 20 in sample:
    pass
endTime = time.time()
print('Total time for in: ' + str((endTime - startTime) * 1000000))

startTime = time.time()
binarySearch(20, sample, 0, len(sample) - 1)
endTime = time.time()
print('Total time for binary: ' + str((endTime - startTime) * 1000000))
