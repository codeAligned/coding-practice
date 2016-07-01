#!/usr/bin/env python3

import time

def binarySearch(value, sample, start, end):
    if start > end:
        return -1

    midIndex = int((start + end) / 2)

    if sample[midIndex] == value:
        return midIndex
    elif sample[midIndex] > value:
        return binarySearch(value, sample, start, midIndex - 1)
    else:
        return binarySearch(value, sample, midIndex + 1, end)

with open('data/primenumbers.txt', 'r') as fileobj:
    primes = fileobj.read().splitlines()
primes = [int(x) for x in primes]

with open('data/happynumbers.txt', 'r') as fileobj:
    happy = fileobj.read().splitlines()
happy = [int(x) for x in happy]

startTime = time.time()
commons = []
happyLen = len(happy)

for i in primes:
    if binarySearch(i, happy, 0, happyLen - 1) >= 0:
        commons.append(i)

print(commons)
endTime = time.time()
print('Total time for intersect using binary: ' + str((endTime - startTime) * 1000))

startTime = time.time()
commons = []
for i in primes:
    if i in happy:
        commons.append(i)

print(commons)
endTime = time.time()
print('Total time for intersect using n^2: ' + str((endTime - startTime) * 1000))
